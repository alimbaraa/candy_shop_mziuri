package com.mziuri.request.service;

public class PurchaseRequest {
    private String name;
    private Integer amount;

    public PurchaseRequest(String name, Integer amount) {
        this.name = name;
        this.amount = amount;
    }

    public PurchaseRequest() {

    }

    public String getName() {
        return name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
