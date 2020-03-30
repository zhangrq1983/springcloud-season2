package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Alibaba_Sentinel_Service_8401 {

    public static void main(String[] args) {
        SpringApplication.run(Alibaba_Sentinel_Service_8401.class, args);
    }

}
