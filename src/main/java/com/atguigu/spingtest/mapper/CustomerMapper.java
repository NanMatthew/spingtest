package com.atguigu.spingtest.mapper;

import com.atguigu.spingtest.bean.Customer;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author 李杭勇
 * @version 1.0
 * @className CustomerMapper
 * @description
 * @date 2023/6/29 11:12
 */

@Mapper
@DS("test")
public interface CustomerMapper extends BaseMapper<Customer> {

    @Select("select id,name,age from customer where name=#{name}")
    public Customer selectCustomerByName(@Param("name") String n);


    @Select("select id,name,age from customer where id=#{id}")
    @DS("demo")
    public Customer selectCustomerById(@Param("id") Integer id);

    @Insert("insert into customer values(#{customer.id},#{customer.name},#{customer.age})")
    public void saveCustomer(@Param("customer") Customer customer);

}
