package com.siwoo.classes.inheritance;

public class Animal {
    protected String name;
    protected String age;

    public Animal(String name) {
        this(name, "0");
    }

    public Animal(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public void makeSound() {
        System.out.println("ww");
    }

}

class Dog extends Animal{
    String fur;

    public Dog(String name) {
        super(name);
    }

    public Dog(String name, String age, String fur) {
        super(name, age);
        this.fur = fur;
    }

    @Override
    public void makeSound() {
        super.makeSound();
        System.out.println(name);
    }

    public static void main(String[] args) {
        Dog dog = new Dog("coco");
        dog.makeSound();
    }
}
