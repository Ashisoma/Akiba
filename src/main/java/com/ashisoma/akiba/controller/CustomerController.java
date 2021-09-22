package com.ashisoma.akiba.controller;

import com.ashisoma.akiba.entity.Customer;
import com.ashisoma.akiba.repository.CustomerRepository;
import com.ashisoma.akiba.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/akiba")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/Customers")
    public List<Customer> findAllCustomers(){
        return customerService.getAllCustomers();
    }

    @RequestMapping("/search/byFirstName/{firstName}")
    public List<Customer> findByFirstName(@PathVariable(value = "firstName") String firstName){
        return customerService.findCustomerByFirstName(firstName);
    }

    @RequestMapping("/search/bySecondName/{secondName}")
    public List<Customer> findBySecondName(@PathVariable(value = "secondName") String secondName){
        return customerService.findCustomerBySecondName(secondName);
    }

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
