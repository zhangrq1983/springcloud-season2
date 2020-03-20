package org.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.entities.Dept;
import org.example.entities.Payment;

/**
 * @ClassName: PaymentDao
 * @description: 支付持久层
 * @author: XZQ
 * @create: 2020/3/5 17:58
 **/
@Mapper
public interface PaymentDao {

    int create(Payment payment);

    int create(Dept dept);

    Payment getPaymentById(@Param("id") Long id);
}
