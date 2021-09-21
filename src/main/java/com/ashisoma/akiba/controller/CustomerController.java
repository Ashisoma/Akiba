package com.ashisoma.akiba.controller;

import com.ashisoma.akiba.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/akiba")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

//    @RequestMapping(value = "/customer", method = RequestMethod.POST)
//    public Customer saveCustomer(Customer customer){
//        return customerRepository.save(customer);
//    }
//
//    @RequestMapping(value = "/customer/{nationalId}", method = RequestMethod.GET)
//    public void findCustomerById(@PathVariable int nationalId){
//        Optional<Customer> s_customer = customerRepository.findCustomerByNationalId(nationalId);
//
//    }
}
