package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Consumer_Consul_80 {

    public static void main(String[] args) {
        SpringApplication.run(Consumer_Consul_80.class, args);
    }

}
