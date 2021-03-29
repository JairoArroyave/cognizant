package com.company.products;

public enum Drink {

        COFFE_SMALL(2.50),COFFE_BIG(3.50),COFFE_MEDIUM(3.0),ORANGE_JUICE(3.95);;

    private double value;

    Drink(double value) {
        this.value =value;
    }

    public double getValue(){
        return value;
    }

}
