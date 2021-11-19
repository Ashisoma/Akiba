package com.ashisoma.akiba.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name = "payments")
@Entity
public class Payments {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "payment_number", nullable = false)
    private Integer payment_number;

    @Column(name = "payment_amount", nullable = false)
    private Float payment_amount;

    @Column(name = "payment_date", nullable = false)
    private LocalDate payment_date;

    // TODO: 13/10/2021 to review this place again
//    @ManyToOne
//    @JoinTable(
//            name = "customer_payments",
//            joinColumns = @JoinColumn(name = "payment_id"),
//            inverseJoinColumns = @JoinColumn(name = "customer_id")
//    )
//    private Customer customerPayment;

//    @ManyToOne
//    @JoinTable(
//            name = "loan_payments",
//            joinColumns = @JoinColumn(name = "payment_id"),
//            inverseJoinColumns = @JoinColumn(name = "loan_id")
//    )
//    private List<Loan> loanPayment = new ArrayList<>();
    public Payments() {
    }

    public Payments(Long id, Integer payment_number, Float payment_amount, LocalDate payment_date) {
        this.id = id;
        this.payment_number = payment_number;
        this.payment_amount = payment_amount;
        this.payment_date = payment_date;
    }

    public Payments(Integer payment_number, Float payment_amount, LocalDate payment_date) {
        this.payment_number = payment_number;
        this.payment_amount = payment_amount;
        this.payment_date = payment_date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPayment_number() {
        return payment_number;
    }

    public void setPayment_number(Integer payment_number) {
        this.payment_number = payment_number;
    }

    public Float getPayment_amount() {
        return payment_amount;
    }

    public void setPayment_amount(Float payment_amount) {
        this.payment_amount = payment_amount;
    }

    public LocalDate getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(LocalDate payment_date) {
        this.payment_date = payment_date;
    }
}