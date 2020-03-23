package org.example.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") int id){
        String result = paymentHystrixService.paymentInfo_OK(id);
        return result;
    }

//    @GetMapping("/payment/hystrix/timeout/{id}")
//    public String paymentInfo_TimeOut(@PathVariable("id") int id){
//        String result = paymentHystrixService.paymentInfo_TimeOut(id);
//        return result;
//    }

    @GetMapping("/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
    @HystrixCommand
    public String paymentInfo_TimeOut(Integer id){
        int age = 10/0;
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        return result;
    }

    public String paymentInfo_TimeOutHandler(Integer id){
        return "我是消费者80，对方支付系统繁忙请10秒钟后再试或者运行出错，请检查自己/(ㄒoㄒ)/~~";
    }

    //下面是全局fallback
    public String payment_Global_FallbackMethod(){
        return "Global异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
    }
}
