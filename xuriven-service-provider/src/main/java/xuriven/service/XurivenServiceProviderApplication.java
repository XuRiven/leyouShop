package xuriven.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("xuriven.service.mapper")//Mapper接口的包扫描
@EnableDiscoveryClient //启用Eureka客户端
public class XurivenServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(XurivenServiceProviderApplication.class, args);
    }

}
