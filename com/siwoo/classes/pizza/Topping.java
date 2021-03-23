package com.siwoo.classes.pizza;

public interface Topping {
    int amount();
    void setAmount(int amount);
    int unitPrice();

    default int totalPrice(){
        return amount() * unitPrice();
    }
    String name();
}
