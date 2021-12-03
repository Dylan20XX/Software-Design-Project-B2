package com.example.fileioexample.store;

import java.util.ArrayList;
import java.util.Objects;

public class Store {

    private String name;
    private String address;
    private ArrayList<Product> availableProducts;
    private ArrayList<Order> ordersList;

    public Store() {
        this.availableProducts = new ArrayList<Product>();
        this.ordersList = new ArrayList<Order>();
    }

    public Store(String name, String address) {
        this.name = name;
        this.address = address;
        this.availableProducts = new ArrayList<Product>();
        this.ordersList = new ArrayList<Order>();
    }

    public Store(String name, String address, ArrayList<Product> availableProducts, ArrayList<Order> ordersList) {
        this.name = name;
        this.address = address;
        this.availableProducts = availableProducts;
        this.ordersList = ordersList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Product> getAvailableProducts() {
        return availableProducts;
    }

    public void setAvailableProducts(ArrayList<Product> availableProducts) {
        this.availableProducts = availableProducts;
    }

    public ArrayList<Order> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(ArrayList<Order> ordersList) {
        this.ordersList = ordersList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return name.equals(store.name) && address.equals(store.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }

    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}