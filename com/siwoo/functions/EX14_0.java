package com.siwoo.functions;

import java.util.function.Function;
import java.util.function.Supplier;

public class EX14_0 {
    public static void main(String[] args) {
        //Function<String, Integer> f = (String s) -> Integer.parseInt(s);
        Function<String, Integer> f = Integer::parseInt; //메서드 참조
        System.out.println(f.apply("100") + 200);


        System.out.println("=================supplier+const=====================");

        //입력은 없고 출력만 있음: void
        //Supplier<MyClass2> s = () -> new MyClass2();
        Supplier<MyClass2> s = MyClass2::new;  //메서드 참조

        MyClass2 mc = s.get(); //객체 반환
        System.out.println(mc);
        System.out.println(s.get());


        System.out.println("================Const======================");

//        Function<Integer, MyClass> k = (i) -> new MyClass(i);
        Function<Integer, MyClass> k = MyClass::new; //메서드 참조
//        Function<Integer, MyClass> f = MyClass::new;  //메서드 참

        MyClass m = k.apply(100);
        System.out.println(m.iv);
        System.out.println(k.apply(100).iv);


        System.out.println("=================Array=====================");


        Function<Integer, int[]> a = (i) -> new int[i];
        int[] arr = a.apply(100);
        System.out.println("arr length= " + arr.length);

        //메서드 참조
        Function<Integer, int[]> a2 = int[]::new;
        int[] arr2 = a2.apply(100);
        System.out.println("arr length = " + arr.length);

    }
}


class MyClass2{

}
class MyClass{
    int iv;

    MyClass(int iv){
        this.iv = iv;
    }
}