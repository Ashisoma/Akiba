package com.ashisoma.akiba.loan;

import javax.persistence.*;

@Table(name = "loan")
@Entity
public class Loan {

    @SequenceGenerator(
            name = "loan_sequence",
            sequenceName = "loan_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "loan_sequence"
    )

    @Id
    @Column(nullable = false, updatable = false, unique = true)
    private Long loan_number;

    @Column(nullable = false, unique = true)
    private Long account_number;

    @Column
    private Float loan_balance;

    @Column(nullable = false)
    private String branch;

    public Loan() {
    }

    public Loan(Long loan_number, Long account_number, Float loan_balance, String branch) {
        this.loan_number = loan_number;
        this.account_number = account_number;
        this.loan_balance = loan_balance;
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loan_number=" + loan_number +
                ", account_number=" + account_number +
                ", loan_balance=" + loan_balance +
                ", branch='" + branch + '\'' +
                '}';
    }

    public Long getLoan_number() {
        return loan_number;
    }

    public void setLoan_number(Long loan_number) {
        this.loan_number = loan_number;
    }

    public Long getAccount_number() {
        return account_number;
    }

    public void setAccount_number(Long account_number) {
        this.account_number = account_number;
    }

    public Float getLoan_balance() {
        return loan_balance;
    }

    public void setLoan_balance(Float loan_balance) {
        this.loan_balance = loan_balance;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}