package xuriven.service.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import xuriven.service.client.UserClient;
import xuriven.service.pojo.User;

import java.util.List;

@RequestMapping("/consumer/user")
@Controller
//@DefaultProperties(defaultFallback = "fallBackMethod") //在类上指明统一的失败降级方法
public class UserController {
//    @Autowired
//    private RestTemplate restTemplate;

    //@Autowired
//    private DiscoveryClient discoveryClient;

    @Autowired
    private UserClient userClient;

    @GetMapping
    @ResponseBody
//    @HystrixCommand//标记该方法需要熔断
    public User queryUserById(@RequestParam("id") Long id) {
//        List<ServiceInstance> instances = discoveryClient.getInstances("service-provider");
//        ServiceInstance serviceInstance = instances.get(0);
//        String baseUrl = "http://service-provider/user/" + id;
//        return this.restTemplate.getForObject(baseUrl, String.class);
        return userClient.queryUserById(id);
    }

    /**
     * 熔断方法
     * 返回值要和被熔断的方法返回值一致
     * 熔断方法不需要参数
     * 熔断:
     *     1、closed:关闭状态，所有请求都正常访问
     *     2、open:打开状态，所有请求都会被降级。Hystix会对请求情况计数，当一定时间内失败请求百分比达到阈值，则触发熔断，断路器会完全打开。
     *             默认失败比例的阈值是50%，请求次数最少不低于20次。
     *     3、Half Open：半开状态，open状态不是永久的，打开后会进入休眠时间（默认是5S）。随后断路器会自动进入半开状态。
     *                   此时会释放部分请求通过，若这些请求都是健康的，则会完全关闭断路器，否则继续保持打开，再次进行休眠计时
     * @return
     */
//    public String fallBackMethod() {
//        return "服务器正忙，请稍后再试！";
//    }

}
