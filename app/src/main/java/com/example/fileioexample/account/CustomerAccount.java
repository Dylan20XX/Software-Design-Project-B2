package com.example.fileioexample.account;

import com.example.fileioexample.store.Order;

import java.util.ArrayList;
import java.util.Objects;

public class CustomerAccount extends Account {

    private ArrayList<Order> orders;

    //Optional fields (these may not be used in final product)
    private String firstName;
    private String lastName;
    private String email;

    public CustomerAccount(String username, String password) {
        super(username, password);
        this.orders = new ArrayList<Order>();
    }

    public CustomerAccount(String username, String password, ArrayList<Order> orders) {
        super(username, password);
        this.orders = orders;
    }

    public CustomerAccount(String username, String password, String firstName, String lastName, String email) {
        super(username, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.orders = new ArrayList<Order>();
    }

    public CustomerAccount(String username, String password, ArrayList<Order> orders, String firstName, String lastName, String email) {
        super(username, password);
        this.orders = orders;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
