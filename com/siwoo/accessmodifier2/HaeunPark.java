package com.siwoo.accessmodifier2;

import com.siwoo.accessmodifier.HousePark;

//protected - 상속  - 다른 패키지에서 접근 가능 상속 사용해서!!
public class HaeunPark extends HousePark {
    public static void main(String[] args) {
        HaeunPark hp = new HaeunPark();
        System.out.println(hp.firstName);
    }
}