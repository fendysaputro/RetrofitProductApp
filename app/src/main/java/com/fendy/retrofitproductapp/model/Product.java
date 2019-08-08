package com.fendy.retrofitproductapp.model;

import com.google.gson.annotations.SerializedName;

public class Product {
    @SerializedName("name")
    private String name;
    @SerializedName("price")
    private String price;

    public Product (String name, String price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
