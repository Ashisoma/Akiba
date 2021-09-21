package com.ashisoma.akiba.repository;

import com.ashisoma.akiba.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT c FROM customer c WHERE c.nationalId=?1" )
    Optional<Customer> findCustomerByNationalId(Integer nationalId);


}
