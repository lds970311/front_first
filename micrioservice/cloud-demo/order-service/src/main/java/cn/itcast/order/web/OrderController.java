package cn.itcast.order.web;


import cn.itcast.order.pojo.Order;
import cn.itcast.order.service.OrderService;
import com.evan.feign.clients.UserClient;
import com.evan.feign.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /*  @Autowired
    private RestTemplate restTemplate;

    @GetMapping("{orderId}")
    public Order queryOrderByUserId(@PathVariable("orderId") Long orderId) {
        Order order = orderService.queryOrderById(orderId);
        String url = "http://userservice/user/" + order.getUserId();
        //发送http请求,实现远程调用
        User user = restTemplate.getForObject(url, User.class);
        order.setUser(user);
        // 返回结构
        return order;
    }
    */

    //使用feign实现远程调用
    @Resource
    private UserClient userClient;

    @GetMapping("{orderId}")
    public Order queryOrderByUserId(@PathVariable("orderId") Long orderId) {
        Order order = orderService.queryOrderById(orderId);
        User user = userClient.findUserById(order.getUserId());
        order.setUser(user);
        // 返回结构
        return order;
    }
}
