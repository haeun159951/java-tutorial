package com.siwoo.stream;

import java.io.*;
import java.util.stream.*;

class StreamEx2 {

    public static void main(String[] args) {
        //file array
        File[] fileArr = { new File("Ex1.java"), new File("Ex1.bak"),
                new File("Ex2.java"), new File("Ex1"), new File("Ex1.txt")
        };

        //file -> 파일스트림을 만듦
        Stream<File> fileStream = Stream.of(fileArr);

        // map() 으로 Stream<File> -> Stream<String>
        // Stream<String> fileStream= fileStream.map((f) -> f.getName()); 람다
        Stream<String> filenameStream = fileStream.map(File::getName);
        filenameStream.forEach(System.out::println); // 최종연산 스트림 닫힘

        fileStream = Stream.of(fileArr);  // 스트림 다시 생

        fileStream.map(File::getName)			 // Stream<File> -> Stream<String>
                .filter(s -> s.indexOf('.')!=-1)   // 확장자가 없는 것은 제외
                .peek(s-> System.out.printf("filename=%s%n", s))
                .map(s -> s.substring(s.indexOf('.')+1)) // 확장자만 추출
                .peek(s-> System.out.printf("extension=%s%n", s))
                .map(String::toUpperCase)    // 대문자 변환
                .distinct()			       // 중복제
                .forEach(System.out::println); // 최종연산

        System.out.println();
    }
}
