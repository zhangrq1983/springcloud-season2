package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class Consumer_Hystrix_Dashboard_9001 {

    public static void main(String[] args) {
        SpringApplication.run(Consumer_Hystrix_Dashboard_9001.class, args);
    }

}
