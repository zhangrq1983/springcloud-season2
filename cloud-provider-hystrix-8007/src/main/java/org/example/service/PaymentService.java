package org.example.service;

import org.springframework.stereotype.Service;

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

    public String paymentInfo_TimeOut(Integer id){
        Integer timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_TimeOut,id: " + id + "\t" + "O(∩_∩)O😄 耗时3秒钟";
    }
}
