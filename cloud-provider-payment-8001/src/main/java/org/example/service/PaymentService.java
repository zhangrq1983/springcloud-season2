package org.example.service;

import org.apache.ibatis.annotations.Param;
import org.example.entities.Payment;

/**
 * @InterfaceName: PaymentService
 * @description:
 * @author: zrq
 * @create: 2020/3/5 18:18
 **/
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
