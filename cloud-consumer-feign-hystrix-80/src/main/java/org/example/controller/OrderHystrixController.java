package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.service.PaymentHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangrq
 * @version V1.0
 * @Title: PaymentController
 * @Package org.example.controller
 * @Description:
 * @date 2020-03-23 16:20
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") int id){
        String result = paymentHystrixService.paymentInfo_OK(id);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") int id){
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        return result;
    }
}
