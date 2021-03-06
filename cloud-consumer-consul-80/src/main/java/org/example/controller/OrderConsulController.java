package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: OrderZKController
 * @description:
 * @author: XZQ
 * @create: 2020/3/6 22:02
 **/
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderConsulController {

    private static final String INVOKE_URL = "http://provider-payment-service";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/payment/consul")
    public String get() {
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
        return result;
    }


}
