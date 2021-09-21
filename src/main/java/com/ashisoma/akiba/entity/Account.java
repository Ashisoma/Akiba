package com.ashisoma.akiba.entity;

import javax.persistence.*;

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
    private Long account_number;

    @Column(nullable = false)
    private Float balance;

    @Column(nullable = false)
    private String branch;

    public Account() {
    }

    public Account(Long account_number, Float balance, String branch) {
        this.account_number = account_number;
        this.balance = balance;
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "Account{" +
                "account_number=" + account_number +
                ", balance=" + balance +
                ", branch='" + branch + '\'' +
                '}';
    }

    public Long getAccount_number() {
        return account_number;
    }

    public void setAccount_number(Long account_number) {
        this.account_number = account_number;
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
