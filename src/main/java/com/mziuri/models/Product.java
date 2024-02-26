package com.mziuri.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "prod_id")
    private int prod_id;
    @Column(name = "prod_name")
    private String name;
    @Column(name = "price")
    private float price;
    @Column(name = "prod_amount")
    private int amount;

    public Product(int prod_id, String name, float price, int amount) {
        this.prod_id = prod_id;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public int getProd_id() {
        return prod_id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
