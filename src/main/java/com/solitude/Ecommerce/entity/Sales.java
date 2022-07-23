package com.solitude.Ecommerce.entity;

import java.io.Serializable;

public class Sales implements Serializable {

    private String name;

    private Integer number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "List{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
