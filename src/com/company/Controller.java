package com.company;

import com.company.products.Drink;
import com.company.products.Extra;
import com.company.products.Snack;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {

    public void calculate(List<String> items){

        List<String> discountsList = new ArrayList<>();
        discountsList = validateDrinks(items);
        int extraDiscount = validateSnackAndDrink(items);
        discountsList.addAll(getDiscountExtra(items, extraDiscount));
        calculateBill(items, discountsList);

    }

    private List<String> validateDrinks(List<String> drinkList) {
        int countDrink=0;
        List<String> drinksFree = new ArrayList<>();

        for(String drink: drinkList){
            if (drink.equals(Drink.COFFE_BIG.name()) || drink.equals(Drink.COFFE_MEDIUM.name()) ||
                    drink.equals(Drink.COFFE_SMALL.name()) || drink.equals(Drink.ORANGE_JUICE.name())) {
                countDrink++;
                if(countDrink%5==0){
                    drinksFree.add(drink);
                }
            }
        }
        return drinksFree;
    }

    private int validateSnackAndDrink(List<String> list){

        int drinks = countDrink(list);
        int snack = countSnack(list);
        int extra = countExtra(list);
        int countFree =0;

        while (drinks!= 0 && snack!=0 && extra>0){

            drinks--;
            snack--;
            extra--;
            countFree++;
        }
        return countFree;
    }

    private int countDrink(List<String> list){

        int countDrink=0;
        for(String drink: list){
            if (drink.equals(Drink.COFFE_BIG.name()) || drink.equals(Drink.COFFE_MEDIUM.name()) ||
                    drink.equals(Drink.COFFE_SMALL.name()) || drink.equals(Drink.ORANGE_JUICE.name())) {
                countDrink++;
            }
        }
        return countDrink;
    }

    private int countExtra(List<String> list){

        int countExtra=0;
        for(String extra: list){
            if (extra.equals(Extra.EXTRA_MILK.name()) || extra.equals(Extra.FOAMED_MILK.name()) ||
                    extra.equals(Extra.SPECIAL_ROAST.name())) {
                countExtra++;
            }
        }
        return countExtra;
    }

    private int countSnack(List<String> list){

        int countBacon=0;
        for(String extra: list){
            if (extra.equals(Snack.BAKON.name())) {
                countBacon++;
            }
        }
        return countBacon;
    }

    private List<String> getDiscountExtra(List<String> list, int discount){

        List<Extra> listExtra=new ArrayList<>();
        for (String item: list) {
            if(item.equals(Extra.EXTRA_MILK.name()) || item.equals(Extra.SPECIAL_ROAST.name()) || item.equals(Extra.FOAMED_MILK.name())){
                listExtra.add(Extra.valueOf(item));
            }
        }

        Comparator<Extra> comparator =( Extra a, Extra b) ->a.compareTo(b);
        return listExtra.stream().sorted(comparator).map(x->x.name() ).limit(discount).collect(Collectors.toList());
     }

     private void calculateBill(List<String> original, List<String> discount){

        List<String> finalBill = original.stream().filter( x->!discount.contains(x)).collect(Collectors.toList());

        double sum =0;
        for (String element : finalBill){

            if (element.equals(Drink.COFFE_BIG.name()) || element.equals(Drink.COFFE_MEDIUM.name()) ||
                    element.equals(Drink.COFFE_SMALL.name()) || element.equals(Drink.ORANGE_JUICE.name())) {
                sum += Drink.valueOf(element).getValue();
                System.out.println(Drink.valueOf(element).name() + " " + Drink.valueOf(element).getValue());
            }

            if (element.equals(Extra.EXTRA_MILK.name()) || element.equals(Extra.FOAMED_MILK.name()) ||
                    element.equals(Extra.SPECIAL_ROAST.name())) {
                sum += Extra.valueOf(element).getValue();
                System.out.println(Extra.valueOf(element).name() + " " + Extra.valueOf(element).getValue());
            }

            if (element.equals(Snack.BAKON.name())) {
                sum += Snack.valueOf(element).getValue();
                System.out.println(Snack.valueOf(element).name() + " " + Snack.valueOf(element).getValue());
            }
        }

        for(String discountElement: discount){
            System.out.println(discountElement + " FREE " );

        }

         System.out.println("Total "+sum);

     }
}
