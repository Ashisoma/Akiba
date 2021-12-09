package com.ashisoma.akiba.services;

import com.ashisoma.akiba.entity.Branch;
import com.ashisoma.akiba.entity.Loan;
import com.ashisoma.akiba.repository.BranchRepository;
import com.ashisoma.akiba.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LoanService {
    @Autowired
    private final LoanRepository repository;


    public LoanService(LoanRepository repository) {
        this.repository = repository;
    }

    // GETTING ALL BRANCH
    public List<Loan> getAllLoans(){
        return repository.findAll();
    }

    // GETTING AN BRANCH BY ID
    public Optional<Loan> getById(Long id){
        return  repository.findById(id);
    }

    // ADD AN BRANCH
    public  void addNewLoan(Loan loan){
        Optional<Loan> loan1 = repository.findById(loan.getId());
        if(loan1.isPresent()) {
            throw new IllegalStateException("The branch exists");
        } else {
            repository.save(loan);
        }
    }

    // UPDATE
    @Transactional
    public void updateLoan(Long id,  int loan_number, Float loan_balance) {
        Loan loan = repository.findById(id).orElseThrow(() ->
                new IllegalStateException("Loan with id: " + id + " does not exist"));
        if (!Objects.equals(loan.getLoan_number(), loan_number)) {
            loan.setLoan_number(loan_number);
        }
        if (loan_balance != null && loan_balance>0 && !Objects.deepEquals(loan.getLoan_number(), loan_balance)) {
            loan.setLoan_balance(loan_balance);
        }
    }
    //DELETE BY ID
    public void  deleteLoanById(Long id){
        boolean exists = repository.existsById(id);
        if (!exists){
            throw new IllegalStateException("Loan with id: " + id + "does not exist!");
        }
        else
            repository.deleteById(id);
    }
}
