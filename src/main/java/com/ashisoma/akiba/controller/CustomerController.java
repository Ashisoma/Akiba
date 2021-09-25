package com.ashisoma.akiba.controller;

import com.ashisoma.akiba.entity.Customer;
import com.ashisoma.akiba.repository.CustomerRepository;
import com.ashisoma.akiba.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/akiba/customers")
public class CustomerController {

    // todo : test all the endpoints using the postman app
    @Autowired
    CustomerRepository customerRepository;

    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // GET METHODS
    @GetMapping
    public List<Customer> findAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("search/byNationalId/{nationalId}")
    public Optional<Customer> findByNationalId(@PathVariable(value = "nationalId") int nationalId){
        return customerService.findByNationalId(nationalId);
    }

    @GetMapping("/search/byFirstName/{firstName}")
    public List<Customer> findByFirstName(@PathVariable(value = "firstName") String firstName){
        return customerService.findCustomerByFirstName(firstName);
    }

    @GetMapping("/search/bySecondName/{secondName}")
    public List<Customer> findBySecondName(@PathVariable(value = "secondName") String secondName){
        return customerService.findCustomerBySecondName(secondName);
    }

    @PostMapping(value = "/save")
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }

}
