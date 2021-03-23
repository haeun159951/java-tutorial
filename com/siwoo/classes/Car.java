package com.siwoo.classes;

import java.util.Objects;

public class Car {
    private String model;
    private String color;
    private int speed;

    public Car(String model, String color, int speed) {
        this.model = model;
        this.color = color;
        this.speed = speed;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void go(){
        System.out.println("goo");
    }

    public void stop(){
        System.out.println("stop");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return speed == car.speed && Objects.equals(model, car.model) && Objects.equals(color, car.color);
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", speed=" + speed +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, color, speed);
    }

    // 새로운 객체를 생성한 후 , 현재 객체의 값을 복사해서 리턴하는 메서드.
    // deep copy, shallow copy - homework
    //
    @Override
    protected Car clone()  {
        return this;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Car car = new Car("hyundai", "red", 250);
        Car car2 = new Car("hyundai", "red", 250);
        System.out.println(car);
        System.out.println(car.toString()); // 객체의 정보를 문자열로 나타냄 / 렌더 ->디버깅
        System.out.println(car.equals(car2)); // 두 객체의 동일 객체가 메모리에서 같은 주소를 갖는것링
        // == (메모리의 위치 주소값 )보다는 equals (실제 텍스트 같은지)사용해야함
        Car car3 = (Car)car.clone();
        System.out.println(car3);

        System.out.println("Car model " + car.model);
        System.out.println("Car color " + car.color);
        System.out.println("Car speed: " + car.speed);
        car.go();
        car.stop();
    }
}
