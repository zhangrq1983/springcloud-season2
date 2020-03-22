package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Cloud_Provider_Consul_8006 {

    public static void main(String[] args) {
        SpringApplication.run(Cloud_Provider_Consul_8006.class, args);
    }

}
