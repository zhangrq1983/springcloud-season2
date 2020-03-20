package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ClassName: Payment
 * @description: 订单实体类
 * @author: XZQ
 * @create: 2020/3/5 17:53
 **/
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Dept implements Serializable {
    private Long id;
    private String dept_name;
}
