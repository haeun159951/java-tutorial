package com.siwoo.classes.polymorphism;
class Car{
    String car;
    int door;

    void drive(){
        System.out.println("drive !!");
    }

    void stop(){
        System.out.println("stop !!");
    }
}


class FireEngine extends Car{
    void water(){
        System.out.println("water!!");
    }
}


public class ReferenceVar_ex {
    public static void main(String[] args) {
        Car car = null;
        FireEngine fe = new FireEngine();
        FireEngine fe2 = null;

        fe.water();
        car = fe;  // car = (Car)fe;  형변환 생략 가능
        //car.water();  // error
        car.drive();
        car.stop();

        fe.water();
        fe.drive();
        fe.stop();

        fe2 = (FireEngine)car; // 4개 쓸수 있었는데 5개 쓰게 되면 안전하지 않음 꼭 형변화 쓰기
        fe2.water();
        fe2.drive();
        fe2.stop();
    }
}
