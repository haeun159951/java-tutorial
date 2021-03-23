package com.siwoo.classes.pizza;

public class Potato implements Topping{
    private int amount;

    public Potato(int amount) {
        this.amount = amount;
    }

    @Override
    public int amount() {
        return this.amount;
    }

    @Override
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public int unitPrice() {
        return 1;
    }

    @Override
    public String name() {
        return "potato";
    }
}
