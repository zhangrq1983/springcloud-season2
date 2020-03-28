package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Alibaba_Consumer_Nacos_83 {

    public static void main(String[] args) {
        SpringApplication.run(Alibaba_Consumer_Nacos_83.class, args);
    }

}
