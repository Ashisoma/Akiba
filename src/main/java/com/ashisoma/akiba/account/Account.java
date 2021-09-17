package com.ashisoma.akiba.account;

public class Account {
    Long account_number;
    Float balance;
    String branch;

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
