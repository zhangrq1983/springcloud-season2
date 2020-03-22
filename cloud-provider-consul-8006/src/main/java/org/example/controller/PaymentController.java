package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author zhangrq
 * @version V1.0
 * @Title: controller
 * @Package org.example.controller
 * @Description:
 * @date 2020-03-22 12:09
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String SERVER_PORT;

    @RequestMapping("/consul")
    public String paymentZK() {
        return "springcloud with consul :" + SERVER_PORT + "\t" + UUID.randomUUID().toString();
    }
}
