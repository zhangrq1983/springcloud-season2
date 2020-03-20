package org.example.service.impl;

import org.example.dao.PaymentDao;
import org.example.entities.Dept;
import org.example.entities.Payment;
import org.example.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: PaymentServiceImpl
 * @description:
 * @author: XZQ
 * @create: 2020/3/5 18:19
 **/
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public int create(Dept dept) {
        return paymentDao.create(dept);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
