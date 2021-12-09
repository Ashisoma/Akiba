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
    private Long id;

    @Column
    private int loan_number;

    @Column
    private Float loan_balance;

//    @ManyToOne(cascade = @JoinColumn(name = "branch_name"))
//    private Branch branch;


    public Loan() {
    }

    public Loan(Long id, int loan_number, Float loan_balance) {
        this.id = id;
        this.loan_number = loan_number;
        this.loan_balance = loan_balance;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", loan_number=" + loan_number +
                ", loan_balance=" + loan_balance +
                '}';
    }

    public int getLoan_number() {
        return loan_number;
    }

    public void setLoan_number(int loan_number) {
        this.loan_number = loan_number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Float getLoan_balance() {
        return loan_balance;
    }

    public void setLoan_balance(Float loan_balance) {
        this.loan_balance = loan_balance;
    }

}