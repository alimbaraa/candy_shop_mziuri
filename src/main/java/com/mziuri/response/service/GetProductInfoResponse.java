package com.mziuri.response.service;

public class GetProductInfoResponse {
    private  String name;
    private float price;
    private Integer amount;

    public GetProductInfoResponse(String name, float price, Integer amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
