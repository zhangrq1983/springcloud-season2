package org.example;

import org.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @ClassName: OrderMain80
 * @description:
 * @author: XZQ
 * @create: 2020/3/5 21:14
 **/
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "PROVIDER-PAYMENT-SERVICE")
//@RibbonClient(name = "PROVIDER-PAYMENT-SERVICE", configuration = MySelfRule.class)
public class Consumer_order_80 {
    public static void main(String[] args) {
        SpringApplication.run(Consumer_order_80.class, args);
    }
}
