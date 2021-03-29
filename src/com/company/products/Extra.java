package com.company.products;

public enum Extra {

    EXTRA_MILK(0.30),FOAMED_MILK(0.50),SPECIAL_ROAST(0.90);

    private double value;

    Extra(double value) {
        this.value =value;
    }

    public double getValue(){
        return value;
    }
}
