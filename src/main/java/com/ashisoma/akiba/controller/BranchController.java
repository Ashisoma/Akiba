package com.ashisoma.akiba.controller;

import com.ashisoma.akiba.entity.Account;
import com.ashisoma.akiba.entity.Branch;
import com.ashisoma.akiba.repository.AccountRepository;
import com.ashisoma.akiba.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class BranchController {

    @Autowired
    private final BranchRepository repository;


    public BranchController(BranchRepository repository) {
        this.repository = repository;
    }

    // GETTING ALL BRANCH
    public List<Branch> getAllBranches(){
        return repository.findAll();
    }

    // GETTING AN BRANCH BY ID
    public Optional<Branch> getByID(Long id){
        return  repository.findById(id);
    }

    // ADD AN BRANCH
    public  void addNewAccount(Branch branch){
        Optional<Branch> branches = repository.findById(branch.getId());
        if(branches.isPresent()) {
            throw new IllegalStateException("The branch exists");
        } else {
            repository.save(branch);
        }
    }

    // UPDATE
    @Transactional
    public void updateBranch(Long id, String branch_name) {
        Branch branch = repository.findById(id).orElseThrow(() ->
                new IllegalStateException("Customer with id: " + id + " does not exist"));
        if (branch_name != null && branch_name.length() > 0 && !Objects.equals(branch.getBranch_name(), branch_name)) {
            branch.setBranch_name(branch_name);
        }
    }
    //DELETE BY ID
    public void  deleteBranchById(Long id){
        boolean exists = repository.existsById(id);
        if (!exists){
            throw new IllegalStateException("Student id: " + id + "does not exist!");
        }
        else
            repository.deleteById(id);
    }
}
