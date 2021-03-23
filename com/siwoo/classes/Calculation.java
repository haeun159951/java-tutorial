package com.siwoo.classes;

public class Calculation {

    public int calc(int a, int b){
        return a+b;
    }
    public int calc(int a, int b, int c){
        return a+b+c;
    }
    public int calc(int a, double b){
        return a + (int)b;
    }
    public double calc(double a, double b){
        return a+b;
    }
//    public int calc(double a, double b){
//        return (int)a + (int)b;
//    }
}


