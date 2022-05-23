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
import org.springframework.aop.framework.AopContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;


@Service
@EnableAspectJAutoProxy(exposeProxy = true)
public class VoucherOrderServiceImpl extends ServiceImpl<VoucherOrderMapper, VoucherOrder> implements IVoucherOrderService {

    @Resource
    private ISeckillVoucherService seckillVoucherService;

    @Resource
    private RedisIDUtil redisIDUtil;

    @Override
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
        synchronized (id.toString().intern()) {
            //解决spring失误失效
            IVoucherOrderService orderService = (IVoucherOrderService) AopContext.currentProxy();//获取代理对象
            return orderService.createVoucherOrder(voucherId, voucher, id);
        }
    }

    @Transactional
    public Result createVoucherOrder(Long voucherId, SeckillVoucher voucher, Long id) {
        //一人一单
        Integer count = this.query()
                .eq("user_id", id)
                .eq("voucher_id", voucher.getVoucherId())
                .count();
        if (count > 0) {
            //该用户已经下过单
            return Result.fail("不能重复提交订单!");
        }

        //扣减库存
        boolean success = seckillVoucherService.update()
                .setSql("stock = stock - 1")
                .eq("voucher_id", voucherId)
                .gt("stock", 0) //cas乐观锁实现
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

}
