package org.example.controller;

import org.example.entities.CommonResult;
import org.example.entities.Payment;
import org.example.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: PaymentController
 * @description:
 * @author: XZQ
 * @create: 2020/3/5 19:03
 **/
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Autowired
    private EurekaDiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String SERVER_PORT;

    /**
     * 1.方法参数没有加@RequestBody，直接用postman做测试是可以直接插入数据库的，
     * 但是消费者rest调用此方法时会出现问题，数据插入数据库了，字段是null的问题
     * 2.方法参数加@RequestBody，直接用postman做测试会报错，
     * Required request body is missing: public org.example.entities.CommonResult org.example.controller.PaymentController.create(org.example.entities.Payment)",
     * 消费者rest调用此方法正常
     * @param payment
     * @return
     */
    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入数据的ID:\t" + payment.getId());
        log.info("插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功,serverport:" + SERVER_PORT, result);
        } else {
            return new CommonResult(444, "插入数据失败", null);
        }
    }

    /**
     * 1.方法参数没有加@RequestBody，直接用postman做测试是可以直接插入数据库的，
     * 但是消费者rest调用此方法时会出现问题，数据插入数据库了，字段是null的问题
     * 2.方法参数加@RequestBody，直接用postman做测试会报错，
     * Required request body is missing: public org.example.entities.CommonResult org.example.controller.PaymentController.create(org.example.entities.Payment)",
     * 消费者rest调用此方法正常
     * @param payment
     * @return
     */
    @PostMapping(value = "/createPayment")
    public CommonResult createPayment(Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入数据的ID:\t" + payment.getId());
        log.info("插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功,serverport:" + SERVER_PORT, result);
        } else {
            return new CommonResult(444, "插入数据失败", null);
        }
    }

    @GetMapping(value = "/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("***查询结果：" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询数据成功,serverport:" + SERVER_PORT + " O(∩_∩)O哈哈~", payment);
        } else {
            return new CommonResult(444, "没有对应记录", null);
        }
    }

    @GetMapping("/discovery")
    public EurekaDiscoveryClient discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("element:\t" + element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("PROVIDER-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return discoveryClient;
    }

    @GetMapping("/lb")
    public String getPaymentLB() {
        return SERVER_PORT;
    }

    @GetMapping(value = "/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            // 暂停3秒钟
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return SERVER_PORT;
    }

    @GetMapping("/zipkin")
    public String paymentZipkin() {
        return "hi，i'am paymentzipkin server fall back，welcome to example，O(∩_∩)O";
    }
}
