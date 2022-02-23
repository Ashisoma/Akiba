package com.ashisoma.akiba.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "branch")
@Entity
public class Branch {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "branch_name", nullable = false)
    private String branch_name;

    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonIgnore
    @JoinColumn(name = "customer_account_id",
    referencedColumnName = "id")
    private Account customerAccount;

//    @ManyToOne
//    private List<Loan> loanList= new ArrayList<>();


    public Branch() {
    }

    public Branch(Long id, String branch_name, Account customerAccount) {
        this.id = id;
        this.branch_name = branch_name;
        this.customerAccount = customerAccount;
    }

    public Branch(String branch_name, Account customerAccount) {
        this.branch_name = branch_name;
        this.customerAccount = customerAccount;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getCustomerAccount() {
        return customerAccount;
    }

    public void setCustomerAccount(Account customerAccount) {
        this.customerAccount = customerAccount;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "id=" + id +
                ", branch_name='" + branch_name + '\'' +
                '}';
    }
}