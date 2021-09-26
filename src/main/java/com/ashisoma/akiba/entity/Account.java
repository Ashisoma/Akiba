package com.ashisoma.akiba.entity;

import javax.persistence.*;

@Table(name = "account")
@Entity(name = "account")
public class Account extends Customer{

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

    public Account() {
    }

    public Account(Long id, Float balance, String branch) {
        this.id = id;
        this.balance = balance;
        this.branch = branch;
    }

    public Account(Long id, Integer account_number, Integer nationalId, String firstName, String secondName, String city, String street, Float balance, String branch) {
        super(id, account_number, nationalId, firstName, secondName, city, street);
        this.balance = balance;
        this.branch = branch;
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
