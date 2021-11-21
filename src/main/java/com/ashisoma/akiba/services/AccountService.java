package com.ashisoma.akiba.services;

import com.ashisoma.akiba.entity.Account;
import com.ashisoma.akiba.entity.Customer;
import com.ashisoma.akiba.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    // GETTING ALL ACCOUNTS
    public List<Account> getAllAccounts(){
        return repository.findAll();
    }

    // GETTING AN ACCOUNT BY ID
    public Account getByID(Long id){
        return  repository.getById(id);
    }

    // ADD AN ACCOUNT
    // TODO: 21/11/2021  RELATIONSHIP IS RQ TO CREATE A NEW ACCOUNT
    public  void addNewAccount(Account account){
        Optional<Account> account1 = repository.findById(account.getId());
        if(account1.isPresent()) {
            throw new IllegalStateException("The account exists");
        } else {
            repository.save(account);
        }
    }

    // UPDATE ACCOUNT
    // TODO: 21/11/2021  BRANCH TO BE EDITED BY THE ONE TO MANY RELATIONSHIP
    @Transactional
    public void updateAccount(Long Id, String branch, Float balance) {
        Account account = repository.findById(Id).orElseThrow(() ->
                new IllegalStateException("Customer with id: " + Id + " does not exist"));
        if (branch != null && branch.length() > 0 && !Objects.equals(account.getBranch(), branch)) {
            account.setBranch(branch);
        }

        if (balance != null && balance > 0 && !Objects.equals(account.getBalance(), balance)) {
            account.setBalance(balance);
        }
    }
    //DELETE BY ID
    public void  deleteAccountById(Long id){
        boolean exists = repository.existsById(id);
        if (!exists){
            throw new IllegalStateException("Student id: " + id + "does not exist!");
        }
        else
        repository.deleteById(id);
    }
}
