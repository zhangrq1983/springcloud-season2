package org.example.controller;

import org.example.domain.CommonResult;
import org.example.domain.Order;
import org.example.service.IdGeneratorSnowflake;
import org.example.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @auther zzyy
 * @create 2020-02-26 15:24
 */
@RestController
public class OrderController
{
    @Resource
    private OrderService orderService;

    @Resource
    private IdGeneratorSnowflake idGeneratorSnowflake;

    @GetMapping("/order/create")
    public CommonResult create(Order order)
    {
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }

    /**
     * 生成id,通过雪花算法
     * @return
     */
    @GetMapping("snowflake")
    public List getIDBySnowflake() {
       List arrayList = new ArrayList();
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20; i++) {
            threadPool.submit(() -> {
//                System.out.println(idGeneratorSnowflake.snowflakeId());
                arrayList.add(idGeneratorSnowflake.snowflakeId());
            });
        }
        threadPool.shutdown();
        return arrayList;
    }
}
