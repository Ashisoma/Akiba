package com.ashisoma.akiba.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "account")
@Entity(name = "account")
public class Account {

    @SequenceGenerator(
            name = "account_sequence",
            sequenceName = "account_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "account_sequence"
    )

    @Id
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = false)
    private Float balance;

    @Column(nullable = false)
    private String branch;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "customer_id",
            referencedColumnName = "id")
    private Customer customer;

    public Account() {
    }

    public Account(Long id, Float balance, String branch) {
        this.id = id;
        this.balance = balance;
        this.branch = branch;
    }

    public Account(Float balance, String branch) {
        this.balance = balance;
        this.branch = branch;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
