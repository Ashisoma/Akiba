package com.ashisoma.akiba.entity;

import javax.persistence.*;

@Table(name = "loan")
@Entity
public class Loan {

    // TODO: 13/10/2021 loan  to payment (loan_payment)
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

    @Column
    private Float loan_balance;

    @Column(nullable = false)
    private String branch;

    public Loan() {
    }

    public Loan(Long loan_number,Float loan_balance, String branch) {
        this.loan_number = loan_number;
        this.loan_balance = loan_balance;
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loan_number=" + loan_number +
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