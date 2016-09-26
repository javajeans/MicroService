package com.lzh.firstboot.web;

import com.lzh.firstboot.domain.Customer;
import com.lzh.firstboot.mongo.CustomerRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 作者： Jonathan
 * 创建时间： 2016/9/26 ${Time}.
 * CustomerController的描述：${DESCRIPTION}
 */
@RestController
@RequestMapping("/customer")
@Api("customer相关的API，用于测试mongodb")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @ApiOperation("增加一个Customer")
    @RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
    public Customer addCustomer(@RequestParam("firstname") String firstname,
                                @RequestParam("secondname") String secondname) {
        Customer customer = new Customer();
        customer.setFirstname(firstname);
        customer.setSecondname(secondname);
        return customerRepository.save(customer);
    }

    @ApiOperation("获取所有的Customer")
    @RequestMapping(value = "/getAllCustomer", method = RequestMethod.GET)
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @ApiOperation("根据firstname获取Customer")
    @RequestMapping(value = "/getCustomerByFirstname", method = RequestMethod.GET)
    public Customer getCustomerByFirstname(@RequestParam("firstname") String firstname) {
        return customerRepository.findByFirstname(firstname);
    }

    @ApiOperation("根据secondname获取多个Customer")
    @RequestMapping(value = "/getCustomerBySecondname", method = RequestMethod.GET)
    public List<Customer> getCustomerBySecondname(@RequestParam("secondname") String secondname) {
        return customerRepository.findBySecondname(secondname);
    }

    @ApiOperation("根据id删除Customer")
    @RequestMapping(value = "/deleteCustomerById", method = RequestMethod.GET)
    public boolean deleteCustomerById(@RequestParam("cid") String cid) {
        customerRepository.delete(cid);
        return true;
    }

}
