package com.siwoo.classes.pizza;

abstract class Olives implements Topping {
    private int amount;

    public Olives(int amount){
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

}
