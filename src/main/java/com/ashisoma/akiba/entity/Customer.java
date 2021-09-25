package com.ashisoma.akiba.entity;

import javax.persistence.*;

@Table(name = "Customer")
@Entity(name = "customer")
public class Customer {

    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 16
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    @Id
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;

    @Column(length = 16, name = "account_number", nullable = false, unique = true)
    private Integer account_number;

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


    public Customer() {
    }

    public Customer(Long id, Integer account_number, Integer nationalId, String firstName, String secondName, String city, String street) {
        this.id = id;
        this.account_number = account_number;
        this.nationalId = nationalId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.city = city;
        this.street = street;
    }

    public Customer(Integer account_number, Integer nationalId, String first_name, String second_name, String city, String street) {
        this.account_number = account_number;
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
                "account_number=" + account_number +
                ", nationalId=" + nationalId +
                ", first_name='" + firstName + '\'' +
                ", second_name='" + secondName + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }

    public Integer getAccount_number() {
        return account_number;
    }

    public void setAccount_number(Integer account_number) {
        this.account_number = account_number;
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
}
