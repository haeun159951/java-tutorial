package com.siwoo.classes.pizza;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private final int BASE_PRICE = 10;
    private final int SAUCE_PRICE = 2;
    private final String BASIC_SAUCE = "Tomato Sauce";
    private List<Topping> toppings = new ArrayList<>();
    private String sauce = BASIC_SAUCE;
    public void addTopping(Topping topping){
        if(topping!=null){
            for(Topping t: toppings){
                if(t.getClass() == topping.getClass()){
                    t.setAmount(t.amount() + topping.amount());
                }
            }
        }
        this.toppings.add(topping);
    }


    public void addTopping(Potato potato){
        this.addTopping((Topping) potato);
    }

    public void addTopping(Sausage sausage){
        this.addTopping((Topping) sausage);
    }

    public void addTopping(Olives olives){
        this.addTopping((Topping) olives);
    }

    public void addTopping(Topping topping, String sauce){
        this.addTopping(topping);
        this.setSauce(sauce);
    }

    private void setSauce(String sauce){
        this.sauce = sauce;
    }

    public int price(){
        int price = BASE_PRICE + (BASIC_SAUCE.equals(this.sauce)? 0 : 2);
        for(Topping t: toppings){
            price+=t.totalPrice();
        }
        return price;
    }

    public String information(){
        StringBuilder sb = new StringBuilder("Your Pizza: \n");
        sb.append("sauce: ").append(sauce).append("\n").append("Toppings: ").append("\n");
        for(Topping topping:toppings){
            sb.append(topping.name()).append(",").append(topping.amount()).append("\n");
        }
        sb.append("[Total price: ").append(this.price()).append(",").append("Enjoy!]");

        return sb.toString();
    }

    public static void main(String[] args) {
        Pizza pizza = new Pizza();
        pizza.addTopping(new BlackOlives(2));
        pizza.addTopping(new Sausage(3));
        pizza.addTopping(new Potato(1));
        System.out.println(pizza.price());
        System.out.println();
        System.out.println(pizza.information());

        pizza.addTopping(new Potato(3), "sambal");
        System.out.println(pizza.price());
        System.out.println();
        System.out.println(pizza.information());
        System.out.println();

        pizza.addTopping(new GreenOlives(3));
        System.out.println(pizza.price());
        System.out.println();
        System.out.println(pizza.information());
        System.out.println();
    }
}


