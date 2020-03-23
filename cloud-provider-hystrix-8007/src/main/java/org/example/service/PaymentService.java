package org.example.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangrq
 * @version V1.0
 * @Title null.java
 * @Package org.example.service
 * @Description
 * @date 2020-03-23 15:01
 */
@Service
public class PaymentService {
    /**
     * 正常访问，肯定OK
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id){
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_OK,id: " + id + "\t" + "O(∩_∩)O😄";
    }

    /**
     * 超时访问
     * * HystrixCommand:一旦调用服务方法失败并抛出了错误信息后,会自动调用@HystrixCommand标注好的fallbckMethod调用类中的指定方法
     * * execution.isolation.thread.timeoutInMilliseconds:线程超时时间3秒钟
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_TimeOut(Integer id){
//        Integer timeNumber = 3;
//        Integer timeNumber = 5;
            int age = 10/0; //模拟系统运行异常

//        Integer timeNumber = 5000;
        Integer timeNumber = 3000;
//        Integer timeNumber = 13000;

        try {
//            TimeUnit.SECONDS.sleep(timeNumber);
            TimeUnit.MILLISECONDS.sleep(timeNumber);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
//        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_TimeOut,id: " + id + "\t" + "O(∩_∩)O😄 耗时3秒钟";
        return "线程池：" + Thread.currentThread().getName() + " id: " + id + "\t" + "O(∩_∩)O😄 耗时3秒钟";
    }
    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池：" + Thread.currentThread().getName() + " 8007系统繁忙或者运行报错，请稍后再试,id: " + id + "\t" + "/(ㄒoㄒ)/~~ 耗时5秒钟";
    }

    //====服务熔断
    /**
     * 在10秒窗口期中10次请求有6次是请求失败的,断路器将起作用
     * @param id
     * @return
     */
    @HystrixCommand(
        fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
        @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 是否开启断路器
        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),// 时间窗口期/时间范文
        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")// 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("*****id不能是负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功,流水号:" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id 不能负数,请稍后重试,o(╥﹏╥)o id:" + id;
    }

}
