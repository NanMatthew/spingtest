package com.atguigu.spingtest.service.impl;

import com.atguigu.spingtest.bean.Customer;
import com.atguigu.spingtest.mapper.CustomerMapper;
import com.atguigu.spingtest.service.CustomerService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 李杭勇
 * @version 1.0
 * @className CustomerServiceImpl
 * @description
 * @date 2023/6/29 8:40
 */

@Service
@DS("demo")
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper , Customer> implements CustomerService {
    @Autowired
    CustomerMapper customerMapper;

    @Override
    @DS("test")
    public void saveCustomer(Customer customer) {

        customerMapper.saveCustomer(customer);
    }

    @Override
    public Customer getCustomerByName(String name) {
        Customer customer = customerMapper.selectCustomerByName(name);
        return customer;
    }


    @Override
    @DS("test")
    public Customer getCustomerById(Integer id) {
        Customer customer = customerMapper.selectCustomerById(id);
        return customer;
    }


}
