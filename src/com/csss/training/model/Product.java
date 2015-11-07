package com.csss.training.model;

import java.math.BigDecimal;

/**
 * Created by larry on 11/7/15.
 */
public class Product {

    private int number;
    private String name;
    private int quantity;
    private BigDecimal price;

    public Product(){
        super();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
