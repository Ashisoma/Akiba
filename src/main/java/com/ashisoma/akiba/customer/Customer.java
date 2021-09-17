package com.ashisoma.akiba.customer;

public class Customer {
    Long customer_id;
    String first_name;
    String second_name;
    String city;
    String street;

    public Customer() {
    }

    public Customer(Long customer_id, String first_name, String second_name, String city, String street) {
        this.customer_id = customer_id;
        this.first_name = first_name;
        this.second_name = second_name;
        this.city = city;
        this.street = street;
    }

    public Customer(String first_name, String second_name, String city, String street) {
        this.first_name = first_name;
        this.second_name = second_name;
        this.city = city;
        this.street = street;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", first_name='" + first_name + '\'' +
                ", second_name='" + second_name + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
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
