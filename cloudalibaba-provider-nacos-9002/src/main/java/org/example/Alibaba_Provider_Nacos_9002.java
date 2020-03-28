package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Alibaba_Provider_Nacos_9002 {

    public static void main(String[] args) {
        SpringApplication.run(Alibaba_Provider_Nacos_9002.class, args);
    }

}
