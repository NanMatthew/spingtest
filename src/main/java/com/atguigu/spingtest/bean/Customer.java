package com.atguigu.spingtest.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 李杭勇
 * @version 1.0
 * @className Customer
 * @description
 * @date 2023/6/27 16:46
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "customer")
public class Customer {
    private Integer id;
    private String name;
    private Integer age;
}
