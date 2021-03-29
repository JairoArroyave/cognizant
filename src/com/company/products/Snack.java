package com.company.products;

public enum Snack {

    BAKON(4.50);

    private double value;

    Snack(double value) {
        this.value =value;
    }

    public double getValue(){
        return value;
    }
}
