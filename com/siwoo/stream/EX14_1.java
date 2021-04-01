package com.siwoo.stream;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EX14_1 {
    public static void main(String[] args) {
        //무한 스트
        IntStream intStream = new Random().ints(5,10); //무한 스트림
        intStream.
                limit(10). //5개만 자
                forEach(System.out::println);

        System.out.println("=========================");
        //람다식 무한 스트림
        // iterate(T seed, UnaryOperator f) 단항연산 : 결과가 하나 나옴
        Stream<Integer> integerStream = Stream.iterate(1, n->n+2); //1,3,5,7,9
        integerStream.limit(10).forEach(System.out::println);

        System.out.println("=========================");
        //generate - > supplier no input, only output
        Stream<Integer> oneStream = Stream.generate(()->1);
        oneStream.limit(10).forEach(System.out::println);



    }
}
