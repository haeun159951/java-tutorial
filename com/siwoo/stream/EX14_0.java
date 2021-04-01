package com.siwoo.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EX14_0 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Stream<Integer> intStream = list.stream();
        intStream.forEach(System.out::print); //forEach 최종연

        // stream은 1회용 stream에 대해 최종연산을 하면
        // integer
        intStream = list.stream(); //list 로부터 stream을 생성
        intStream.forEach(System.out::print);

        //string
        String[] strArr = new String[]  {"a", "b", "c", "d"};
//        Stream<String> strStream = Stream.of(strArr);
        Stream<String> strStream = Arrays.stream(strArr);
        strStream.forEach(System.out::println);


        //int  stream
        int[] intArr2 = {1,2,3,4,5};
        IntStream intStream2 = Arrays.stream(intArr2);
        intStream2.forEach(System.out::println);
        System.out.println("sum = " + intStream2.sum()); //최종연산

        // int object stream
        Integer[] intArr = {1,2,3,4,5}; // autoboxing
        Stream<Integer> iStream = Arrays.stream(intArr);
        //iStream.forEach(System.out::println); //
        System.out.println("count = " + intStream.count());
    }
}
