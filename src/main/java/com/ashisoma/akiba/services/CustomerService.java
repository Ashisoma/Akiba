package com.ashisoma.akiba.services;

import com.ashisoma.akiba.repository.CustomerRepository;
import com.ashisoma.akiba.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // functions run in here

    // get all customers and their details
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    //add new customer
    public void addNewCustomer(Customer customer){
        // add exception and error handling

        Optional<Customer> customerById = customerRepository.
                findCustomerByNationalId(customer.getNationalId());

        if(customerById.isPresent()){
            throw new IllegalStateException("The national ID number is already in use.");
        }
        customerRepository.save(customer);
    }

    //delete a customer
    public void deleteStudent(Long accountNum) {
//        todo impliment cascading when a user is deleted
        // use custom query to do a cascading
        boolean exists = customerRepository.existsById(accountNum);
        if (!exists){
            throw new IllegalStateException("Student id: " + accountNum + "does not exist!");
        }
        customerRepository.deleteById(accountNum);
    }

    // todo finish on doing an update
    @Transactional
    public void updateCustomer(Long accountNUmber, String f_name, String s_name, Integer nationalId, String city, String street){
        Customer customer = customerRepository.findCustomerByNationalId(nationalId).orElseThrow(()->
                new IllegalStateException("Customer with "+ nationalId+" does not exist"));
        if (f_name != null && f_name.length()>0 && !Objects.equals(customer.getFirst_name(),f_name))
        {
            customer.setFirst_name(f_name);
        }

        if (s_name != null && s_name.length()>0 && !Objects.equals(customer.getSecond_name(),s_name))
        {
            customer.setSecond_name(s_name);
        }
        if (city != null && city.length()>0 && !Objects.equals(customer.getCity(),city))
        {
            customer.setCity(city);
        }
        if (street != null && street.length()>0 && !Objects.equals(customer.getStreet(),street))
        {
            customer.setStreet(street);
        }
    }

}
