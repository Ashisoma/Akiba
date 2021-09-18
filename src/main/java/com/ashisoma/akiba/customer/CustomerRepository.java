package com.ashisoma.akiba.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT s FROM Student s WHERE c.nationalId=?1" )
    Optional<Customer> findCustomerByNationalId(Integer nationalId);
}