package com.ashisoma.akiba.controller;

import com.ashisoma.akiba.entity.Account;
import com.ashisoma.akiba.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1/akiba/accounts")
public class AccountController {

    @Autowired
    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    // get methods
    @GetMapping(path = "/get")
    public List<Account> getAllAccounts(){
        return  service.getAllAccounts();
    }

    @GetMapping(path = "/get/{id}")
    public Optional<Account> getById(@PathVariable("id")Long id){
        return  service.getByID(id);
    }
    //post methods
    @PostMapping(path = "/post")
    public void addNewAccount(@RequestBody Account account){
        service.addNewAccount(account);
    }

    // put methods
    @PutMapping(path = "put/{id}")
    public  void  updateAnAccount(@PathVariable(value = "id")Long id,
                                  @RequestParam(required = false) String branch,
                                  @RequestParam (required = false)Float balance){
        service.updateAccount(id, branch, balance);
    }

    //delete method
    @DeleteMapping(path = "delete/{id}")
    public  void deleteAnAccountById(Long id){
        service.deleteAccountById(id);
    }


    @PutMapping(path = "/enrollAccount/{accountId}/customer/{customerId}")
    public Account assignAccountToCustomer(@PathVariable("accountId")Long accountId,
                                  @PathVariable("customerId")Long customerId){
        Account account = service.getByID(accountId).get();
        service.assignAccountToCustomer(accountId,customerId);
        return service.addNewAccount(account);

    }
}
