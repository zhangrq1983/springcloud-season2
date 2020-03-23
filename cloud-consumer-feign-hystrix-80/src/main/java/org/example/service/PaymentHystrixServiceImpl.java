package org.example.service;

import org.springframework.stereotype.Component;

/**
 * @author zhangrq
 * @version V1.0
 * @Title: PaymentHystrixServiceImpl
 * @Package org.example.service
 * @Description:
 * @date 2020-03-23 22:09
 */
@Component
public class PaymentHystrixServiceImpl implements PaymentHystrixService {

    @Override
    public String paymentInfo_OK(int id) {
        return "--------PaymentHystrixService fall back，/(ㄒoㄒ)/~~";
    }

    @Override
    public String paymentInfo_TimeOut(int id) {
        return "--------PaymentHystrixService fall back，/(ㄒoㄒ)/~~";
    }
}
