package xuriven.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 引导类：spring boot应用的入口
 */

@SpringBootApplication//使用组合注解，相当于@EnableAutoConfiguration+@ComponentScan+@SpringBootConfiguration
public class TestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
}
