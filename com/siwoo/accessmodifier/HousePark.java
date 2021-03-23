package com.siwoo.accessmodifier;

public class HousePark {
    String lastname = "park";  //default
    protected String firstName = "KIM";  // 같은 클래스, 패키지, 상속받은 외부 패키지 클래스 가능.
    public String info = "this is public message.";  //public - 모든 클래스 에게서 접근 가능하다

    public static void main(String[] args) {
        HouseKim kim = new HouseKim();
        System.out.println(kim.lastname);
    }
}

// 코딩실수 방지,  정보 은닉