package com.siwoo.classes.interfaceTest.templateMethod;

public abstract class CaffeineBeverageWithHook {
     void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        if(customerWantsCondiments()) {
            addCondiments();
        }
    }

    abstract void brew();
     abstract void addCondiments();

    void boilWater(){
        System.out.println("물끓이는중");
    }
    void pourInCup(){
        System.out.println("컵에 따르는 중");
    }
    //hook
     boolean customerWantsCondiments(){
         return true;
     }
}
