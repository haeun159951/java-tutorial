package com.siwoo.classes.pizza;

public class GreenOlives extends Olives{

    public GreenOlives(int amount) {
        super(amount);
    }

    @Override
    public int unitPrice() {
        return 3;
    }

    @Override
    public String name() {
        return "green olives";
    }
}
