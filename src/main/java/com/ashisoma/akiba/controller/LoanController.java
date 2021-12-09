package com.ashisoma.akiba.controller;

import com.ashisoma.akiba.entity.Branch;
import com.ashisoma.akiba.entity.Loan;
import com.ashisoma.akiba.services.BranchService;
import com.ashisoma.akiba.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class LoanController {

    @Autowired
    private final LoanService service;

    public LoanController(LoanService service) {
        this.service = service;
    }

    // get methods
    @GetMapping(path = "/get")
    public List<Loan> getAll(){
        return  service.getAllLoans();
    }

    @GetMapping(path = "/get/{id}")
    public Optional<Loan> getById(@PathVariable(value = "id")Long id){
        return  service.getById(id);
    }
    //post methods
    @PostMapping(path = "/post")
    public void addNew(@RequestBody Loan loan){
        service.addNewLoan(loan);
    }

    // put methods
    @PutMapping(path = "put/{id}")
    public  void  updateBranch(@PathVariable(value = "id")Long id,
                               @RequestParam(required = false) int loan_number,
                               @RequestParam(required = false) Float loan_balance){
        service.updateLoan(id,  loan_number, loan_balance);
    }

    //delete method
    @DeleteMapping(path = "delete/{id}")
    public  void deleteAnAccountById(Long id){
        service.deleteLoanById(id);
    }
}
