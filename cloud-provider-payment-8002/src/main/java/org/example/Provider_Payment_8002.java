package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName: PaymentMain8001
 * @description: PaymentMain8001主启动类
 * @author: XZQ
 * @create: 2020/3/5 17:30
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class Provider_Payment_8002 {
    public static void main(String[] args) {
        SpringApplication.run(Provider_Payment_8002.class, args);
    }
}
