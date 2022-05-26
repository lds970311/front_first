package com.hmdp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.dto.Result;
import com.hmdp.entity.SeckillVoucher;
import com.hmdp.entity.VoucherOrder;
import com.hmdp.mapper.VoucherOrderMapper;
import com.hmdp.service.ISeckillVoucherService;
import com.hmdp.service.IVoucherOrderService;
import com.hmdp.utils.RedisIDUtil;
import com.hmdp.utils.UserHolder;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Collections;
import java.util.concurrent.*;


@Service
@EnableAspectJAutoProxy(exposeProxy = true)
@Slf4j
public class VoucherOrderServiceImpl extends ServiceImpl<VoucherOrderMapper, VoucherOrder> implements IVoucherOrderService {

    @Resource
    private ISeckillVoucherService seckillVoucherService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private RedisIDUtil redisIDUtil;

    @Resource
    private RedissonClient redissonClient;

    private static final DefaultRedisScript<Long> seckillScript;

    private BlockingQueue<VoucherOrder> orderTasks = new ArrayBlockingQueue<>(1024 * 1024);

    private static final ExecutorService orderThreadPool = Executors.newSingleThreadExecutor();

    private IVoucherOrderService orderServiceProxy;//获取代理对象

    private class VoucherOrderHandler implements Runnable {

        @Override
        public void run() {
            while (true) {
                //获取队列中的订单信息
                try {
                    VoucherOrder voucherOrder = orderTasks.take();
                    handleVoucherOrder(voucherOrder);
                } catch (Exception e) {
                    log.error(e.getMessage());
                }
            }
        }
    }

    private void handleVoucherOrder(VoucherOrder voucherOrder) {
        Long userId = voucherOrder.getUserId();
        RLock lock = redissonClient.getLock("lock:order" + userId);
        boolean isLock = false;
        try {
            isLock = lock.tryLock(1, TimeUnit.SECONDS);
            if (!isLock) {
                return;
            }
            orderServiceProxy.saveVoucherOrder(voucherOrder);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    static {
        seckillScript = new DefaultRedisScript<>();
        seckillScript.setLocation(new ClassPathResource("scripts/seckill.lua"));
        seckillScript.setResultType(Long.class);
    }

    @PostConstruct
    private void init() {
        orderThreadPool.submit(new VoucherOrderHandler());
    }

    /*@Override
    @Transactional
    public Result seckillVoucher(Long voucherId) {
        SeckillVoucher voucher = seckillVoucherService.getById(voucherId);
        LocalDateTime beginTime = voucher.getBeginTime();
        LocalDateTime endTime = voucher.getEndTime();
        //判断秒杀是否开始
        if (beginTime.isAfter(LocalDateTime.now())) {
            //未开始
            return Result.fail("秒杀尚未开始!");
        }
        if (endTime.isBefore(LocalDateTime.now())) {
            //已经结束
            return Result.fail("秒杀已结束!");
        }
        Integer stock = voucher.getStock();
        if (stock < 1) {
            return Result.fail("库存不足!");
        }
        Long id = UserHolder.getUser().getId();
        *//*synchronized (id.toString().intern()) {
            //解决spring失误失效
            IVoucherOrderService orderService = (IVoucherOrderService) AopContext.currentProxy();//获取代理对象
            return orderService.createVoucherOrder(voucherId, voucher, id);
        }*//*

        //创建锁对象(分布式锁)
//        SimpleRedisLock simpleRedisLock = new SimpleRedisLock("order:" + id, stringRedisTemplate);
        //redisson实现分布式锁
        RLock lock = redissonClient.getLock("lock:order:" + id);
        boolean isLock = false;
        try {
            isLock = lock.tryLock(1, TimeUnit.SECONDS);
            if (isLock) {
                IVoucherOrderService orderService = (IVoucherOrderService) AopContext.currentProxy();//获取代理对象
                return orderService.createVoucherOrder(voucherId, voucher, id);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
       *//* if (!isLock) {
            //获取锁失败
            return Result.fail("不允许重复下单!");
        }
        //获取锁成功
        try {
            IVoucherOrderService orderService = (IVoucherOrderService) AopContext.currentProxy();//获取代理对象
            return orderService.createVoucherOrder(voucherId, voucher, id);
        } finally {
            //释放锁
            simpleRedisLock.unlock();
        }*//*
        return Result.fail("秒杀失败!");
    }*/

    @Override
    @Transactional
    public Result seckillVoucher(Long voucherId) {
        Long userId = UserHolder.getUser().getId();
        Long orderId = redisIDUtil.nextID("order");
        //执行lua脚本
        int result = stringRedisTemplate.execute(seckillScript, Collections.emptyList(), voucherId.toString(), userId.toString(),
                orderId.toString()).intValue();
        if (result != 0) {
            //没有下单资格
            return Result.fail(result == 1 ? "库存不足!" : "不能重复下单!");
        }
        //成功下单,保存阻塞队列

        VoucherOrder voucherOrder = new VoucherOrder();
        voucherOrder.setId(orderId);
        voucherOrder.setUserId(userId);
        voucherOrder.setVoucherId(voucherId);
        orderServiceProxy = (IVoucherOrderService) AopContext.currentProxy();
        orderTasks.add(voucherOrder);
        return Result.ok(orderId);
    }

    @Transactional
    public Result createVoucherOrder(Long voucherId, SeckillVoucher voucher, Long id) {
        //一人一单
        Integer count = this.query().eq("user_id", id).eq("voucher_id", voucher.getVoucherId()).count();
        if (count > 0) {
            //该用户已经下过单
            return Result.fail("不能重复提交订单!");
        }

        //扣减库存
        boolean success = seckillVoucherService.update().setSql("stock = stock - 1").eq("voucher_id", voucherId).gt("stock", 0) //cas乐观锁实现
                .update();
        if (!success) {
            //扣减失败
            return Result.fail("库存不足!");
        }

        //创建订单
        VoucherOrder voucherOrder = new VoucherOrder();
        voucherOrder.setId(redisIDUtil.nextID("order"));
        voucherOrder.setUserId(id);
        voucherOrder.setVoucherId(voucherId);
        //写入数据库
        this.save(voucherOrder);
        return Result.ok(voucherOrder.getId());
    }

    @Transactional
    @Override
    public void saveVoucherOrder(VoucherOrder voucherOrder) {
        //扣减库存
        boolean success = seckillVoucherService.update().setSql("stock = stock - 1").eq("voucher_id", voucherOrder.getVoucherId()).gt("stock", 0) //cas乐观锁实现
                .update();
        if (!success) {
            //扣减失败
            return;
        }

        save(voucherOrder);
    }
}
