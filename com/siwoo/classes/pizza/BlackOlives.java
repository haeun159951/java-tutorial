package com.siwoo.classes.pizza;

public class BlackOlives extends Olives {
    public BlackOlives(int amount) {
        super(amount);
    }

    @Override
    public int unitPrice() {
        return 2;
    }

    @Override
    public String name() {
        return "black olives";
    }
}
