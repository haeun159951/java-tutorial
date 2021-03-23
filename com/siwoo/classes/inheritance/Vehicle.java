package com.siwoo.classes.inheritance;

public class Vehicle {
    protected int maxSpeed; // 최대 속도
    protected int capacity; // 태울수 있는 최대 손님의 수
    protected int gas = 100; //
    protected String name; // 이름

    public Vehicle(String name, int maxSpeed, int capacity){
        this(name, maxSpeed, capacity, 100);
    }

    public Vehicle(String name,int maxSpeed, int capacity, int gas) {
    if(capacity < 0 && maxSpeed < 0) throw new IllegalArgumentException();
    if(name == null || name.isEmpty()) throw new IllegalArgumentException();
        this.maxSpeed = maxSpeed;
        this.capacity = capacity;
        this.name = name;
        this.gas = gas;
    }

    public void run() {
        if (gas <= 0) {
            System.out.println("give me gas");
        } else {
            System.out.println("Running...");
            gas -= 10;
        }
    }

    public void fuel(int gas){
        if(gas %10 !=0){
            throw new IllegalArgumentException("The amount of gas should be units of 10");
        }
        this.gas+=gas;
    }

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle("NONAME", 100, 5);
        for(int i =0; i<12; i++){
            vehicle.run();
        }
        vehicle.fuel(10);
        vehicle.run();
    }
}

class Car extends Vehicle {// vehicle 의 속성 행동 상
    public Car(String name, int maxSpeed, int capacity) {
        super(name, maxSpeed, capacity);
    }
}

class Bus extends Vehicle{
    private String[] stations = {"Harbour", "Bloor","York", "Finch"};
    private int index = 0;

    public Bus(String name, int maxSpeed, int capacity) {
        super(name, maxSpeed, capacity);
    }

    @Override
    public void fuel(int gas) { //부모의 행동을 덮어 쓴다
        if (gas %100 !=0){
            throw new IllegalArgumentException("The amount of gas should be units of 10");
        }
        this.gas+=gas;
    }

    public void openDoor(){ //추기
        System.out.println("Open door to take customers");
    }

    @Override
    public void run(){
        int next = (this.index + 1) % stations.length;
        System.out.printf("Current station is %s, next station will be %s%n", stations[index], stations[next]);
        if (this.index == stations.length -1){
            System.out.println("this is the last station");
        }
        this.index = next;
    }

    public static void main(String[] args) {
        Bus bus = new Bus("max-809",120,40);
        for(int i =0; i<10; i++){
            bus.run();
        }
    }
}

/**
 * 연습문제.
 *  Car 을 상속받는 전기차 클래스를 만들어보자.
 *
 *  전기 자동차는 자동 주행 기능이 존재한다.
 *
 *  이에따라, autoPilot (자동 주행) 이란 메서드를 만들어 자동 주행 기능... 키고 끄고,
 *  자동 주행일 경우에는 run 메서드를 변경하여 "Auto piloting.." 을 보여주고
 *  아니라면 부모 클래스의 행동을 그대로 유지해보자.
 *
 */


class EV extends Car {

    public EV(String name, int maxSpeed, int capacity, boolean autoPilotMode) {
        super(name, maxSpeed, capacity);
        this.autoPilotMode = autoPilotMode;
    }

    private boolean autoPilotMode;

    @Override
    public void run(){
        if (!autoPilotMode) {
            super.run();
        } else {
            System.out.println("Auto piloting..");
            gas -= 10;
        }
    }

    public void setAutoPilotMode(boolean autoPilotMode) {
        this.autoPilotMode = autoPilotMode;
    }
}