package com.siwoo.classes;

public class StaticClass {
    public static int HEIGHT, WIDTH =10;
    public int number;
    public String suit;

    public StaticClass(int number, String suit) {
        this.number = number;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "StaticClass{" +
                "number=" + number +
                ", suit='" + suit + '\'' +
                '}';
    }

    public static void main(String[] args) {

    }
}
