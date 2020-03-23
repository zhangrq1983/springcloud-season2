package org.example.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhangrq
 * @version V1.0
 * @Title null.java
 * @Package org.example
 * @Description
 * @date 2020-03-23 16:15
 */
@FeignClient(value="PROVIDER-HYSTRIX-PAYMENT-SERVICE")
public interface PaymentHystrixService {

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") int id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") int id);

}
