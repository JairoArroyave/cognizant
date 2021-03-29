package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> items = Arrays.asList(args);
        if(!items.isEmpty()){
            Controller controller = new Controller();
            controller.calculate(items);
        }
    }

}
