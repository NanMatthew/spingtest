package com.atguigu.spingtest.controller;

import com.atguigu.spingtest.bean.Customer;
import com.atguigu.spingtest.service.CustomerService;
import com.atguigu.spingtest.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 李杭勇
 * @version 1.0
 * @className CustomerController
 * @description
 * @date 2023/6/27 15:03
 */

//该注解指定该类为controller层的类，指定后运行SpringtestApplication是才会辨别到controller层是哪个类
@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService; //= new CustomerServiceImpl();



    //指定网页请求发出后，使用哪个方法进行处理。
    //RequestMapping可以只传一个参数，只传一个参数时，默认接收所有请求，但是优先级会比专门接收对应请求的注解低(如GetMapping等)，即RequestMapping不会处理对应的请求。
    //当传入第二个参数时，指定请求的方式。当
    @RequestMapping(value = "customerByName")
    public String sayHello(
            //
            @RequestParam("name") String n){
        System.out.println("33333333333");
        return "hello" + n;
    }

    @GetMapping("customerByName")
    public String customerByName1(@RequestParam("name") String n){
        Customer customer = customerService.getCustomerByName(n);
//        Customer customer = customerService.getCustomerName(n);
//        System.out.println("11111111111");
        return "Customer:"+ customer;
    }

    @GetMapping("customerById/{Id}")
    public String customerById(@PathVariable("Id") Integer id){
        Customer customer = customerService.getCustomerById(id);
//        System.out.println("222222222222");
        return "customer:" + customer;
    }

    @PostMapping("/save")
    public String save(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
//        customerService.saveOrUpdate(customer);
        return "success";
    }

}
