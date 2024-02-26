package com.mziuri.request.service;


public class GetProductInfoRequest {
    private String name;

    public GetProductInfoRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
