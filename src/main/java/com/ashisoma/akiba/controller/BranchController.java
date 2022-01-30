package com.ashisoma.akiba.controller;

import com.ashisoma.akiba.entity.Branch;
import com.ashisoma.akiba.services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "ap1/v1/akiba/branch")
public class BranchController {

    @Autowired
    private final BranchService service;

    public BranchController(BranchService service) {
        this.service = service;
    }

    // get methods
    @GetMapping(path = "/get")
    public List<Branch> getAllBranches(){
        return  service.getAllBranches();
    }

    @GetMapping(path = "/getByName/{b_name}")
    public List<Branch> getBranchesByName(@PathVariable("b_name") String b_name){
        return  service.getByName(b_name);
    }

    @GetMapping(path = "/getById/{id}")
    public Optional<Branch> getById(@PathVariable("id")Long id){
        return  service.getByID(id);
    }
    //post methods
    @PostMapping(path = "/post")
    public void addNewBranch(@RequestBody Branch branch){
        service.addNewBranch(branch);
    }

    // put methods
    @PutMapping(path = "put/{id}")
    public  void  updateBranch(@PathVariable(value = "id")Long id,
                                  @RequestParam(required = false) String branch_name){
        service.updateBranch(id, branch_name);
    }

    //delete method
    @DeleteMapping(path = "delete/{id}")
    public  void deleteAnAccountById(Long id){
        service.deleteBranchById(id);
    }
}
