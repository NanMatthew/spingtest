package com.atguigu.spingtest.service;

import com.atguigu.spingtest.bean.Customer;
import com.atguigu.spingtest.mapper.CustomerMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 李杭勇
 * @version 1.0
 * @className CustomerService
 * @description
 * @date 2023/6/29 8:40
 */
public interface CustomerService extends IService<Customer> {
    public void saveCustomer(Customer customer);

    public Customer getCustomerByName(String name);

    public Customer getCustomerById(Integer id);


}
