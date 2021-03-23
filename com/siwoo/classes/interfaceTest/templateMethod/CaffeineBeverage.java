package com.siwoo.classes.interfaceTest.templateMethod;

abstract class CaffeineBeverage {
    final void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    abstract void brew();
    abstract void addCondiments();

    void boilWater(){
        System.out.println("물끓이는중");
    }
    void pourInCup(){
        System.out.println("컵에 따르는 중");
    }

    void hook(){}
}

