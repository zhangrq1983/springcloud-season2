package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
//@EnableFeignClients
public class Alibaba_Consumer_Nacos_84 {

    public static void main(String[] args) {
        SpringApplication.run(Alibaba_Consumer_Nacos_84.class, args);
    }

}
