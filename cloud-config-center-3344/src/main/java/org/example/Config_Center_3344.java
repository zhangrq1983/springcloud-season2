package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Config_Center_3344 {

    public static void main(String[] args) {
        SpringApplication.run(Config_Center_3344.class, args);
    }

}
