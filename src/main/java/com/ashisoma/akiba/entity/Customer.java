package com.ashisoma.akiba.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name = "Customer")
@Entity(name = "customer")
public class Customer {

    // todo customer to borrower
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    @Id
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;

    @Column(nullable = false, length = 8, unique = true)
    private Integer nationalId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "second_name", nullable = false)
    private String secondName;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "street")
    private String street;

    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "account_id",
                referencedColumnName = "id")
    private Account account;

    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "borrower_loan_number",
    referencedColumnName = "id")
    private Loan borrower;

    @JsonIgnore
    @OneToMany(mappedBy = "customerPayment",
               orphanRemoval = true,
               cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
               fetch = FetchType.LAZY
                )
    private List<Payments> payments = new ArrayList<>();


    public Customer() {
    }

    public Customer(Long id, Integer nationalId, String firstName, String secondName, String city, String street) {
        this.id = id;
        this.nationalId = nationalId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.city = city;
        this.street = street;
    }

    public Customer(Integer nationalId, String first_name, String second_name, String city, String street) {
        this.nationalId = nationalId;
        this.firstName = first_name;
        this.secondName = second_name;
        this.city = city;
        this.street = street;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id"+ id +
                ", nationalId=" + nationalId +
                ", first_name='" + firstName + '\'' +
                ", second_name='" + secondName + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }

    public List<Payments> getPayments() {
        return payments;
    }
    public Loan getBorrower() {
        return borrower;
    }

    public Integer getNationalId() {
        return nationalId;
    }

    public void setNationalId(Integer nationalId) {
        this.nationalId = nationalId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
