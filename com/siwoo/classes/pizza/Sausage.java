package com.siwoo.classes.pizza;

public class Sausage implements Topping {
    private int amount;

    public Sausage(int amount){
        this.amount = amount;
    }

    @Override
    public int amount() {
        return amount;
    }

    @Override
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public int unitPrice() {
        return 5;
    }


    @Override
    public String name() {
        return "sausage";
    }
}
