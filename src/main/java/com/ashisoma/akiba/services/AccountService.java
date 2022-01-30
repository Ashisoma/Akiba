package com.ashisoma.akiba.services;

import com.ashisoma.akiba.entity.Account;
import com.ashisoma.akiba.entity.Customer;
import com.ashisoma.akiba.repository.AccountRepository;
import com.ashisoma.akiba.repository.CustomerRepository;
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
    private final CustomerRepository customerRepository;

    public AccountService(AccountRepository repository, CustomerRepository customerRepository) {
        this.repository = repository;
        this.customerRepository = customerRepository;
    }

    // GETTING ALL ACCOUNTS
    public List<Account> getAllAccounts(){
        return repository.findAll();
    }

    // GETTING AN ACCOUNT BY ID
    public Optional<Account> getByID(Long id){
        return  repository.findById(id);
    }

    // ADD AN ACCOUNT
    // TODO: 21/11/2021  RELATIONSHIP IS RQ TO CREATE A NEW ACCOUNT
    public  Account addNewAccount(Account account){
//        Optional<Account> account1 = repository.findByAccountNumber(account.getAccountNumber());
//        if(account1.isPresent()) {
//            throw new IllegalStateException("The account exists");
//        } else {
           return repository.save(account);

    }

    // UPDATE ACCOUNT
    // TODO: 21/11/2021  BRANCH TO BE EDITED BY THE ONE TO MANY RELATIONSHIP
    @Transactional
    public void updateAccount(Long Id, String branch, Float balance) {
        Account account = repository.findById(Id).orElseThrow(() ->
                new IllegalStateException("Customer with id: " + Id + " does not exist"));
//        if (branch != null && branch.length() > 0 && !Objects.equals(account.getAccountNumber(), branch)) {
//            account.setAccountNumber(branch);
//        }

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

    @Transactional
    public void assignAccountToCustomer(Long accountId, Long customerId){
        Account account = repository.findById(accountId).get();
        Customer customer = customerRepository.findById(customerId).get();
        boolean accountExists = repository.existsById(accountId);
        boolean customerExists = customerRepository.existsById(customerId);
        if (!accountExists && !customerExists){
            throw  new IllegalStateException("Admin with id :"+ accountExists +" and house id:"+ customerExists +" cant be enrolled. Error enrolling admin");
        }else {
            account.registerAccount(customer);
        }
    }
}
