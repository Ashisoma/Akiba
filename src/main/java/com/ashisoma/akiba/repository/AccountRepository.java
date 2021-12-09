package com.ashisoma.akiba.repository;

import com.ashisoma.akiba.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("select a from account a where a.accountNumber = ?1")
    Optional<Account> findByAccountNumber(String accountNumber);

}