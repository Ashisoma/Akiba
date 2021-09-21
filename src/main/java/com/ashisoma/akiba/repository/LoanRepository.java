package com.ashisoma.akiba.repository;

import com.ashisoma.akiba.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {

}