package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
public class Consumer_Feign_Hystrix_80 {

    public static void main(String[] args) {
        SpringApplication.run(Consumer_Feign_Hystrix_80.class, args);
    }

}
