package xuriven.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/*@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker//开启熔断*/
@SpringCloudApplication//组合注解,相当于SpringBootApplication + EnableDiscoveryClient + EnableCircuitBreaker
public class XurivenServiceConsumerApplication {

    @Bean
    @LoadBalanced//开启负载均衡Ribbon
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        /*try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        SpringApplication.run(XurivenServiceConsumerApplication.class, args);
    }


}
