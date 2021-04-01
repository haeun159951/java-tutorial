package com.siwoo.stream;

import java.util.*;
import java.util.stream.*;

class StreamEx1 {
    public static void main(String[] args) {
        Stream<Student> studentStream = Stream.of(
                new Student("kim", 3, 300),
                new Student("lee", 1, 200),
                new Student("json", 2, 100),
                new Student("park", 2, 150),
                new Student("sol", 1, 200),
                new Student("ji", 3, 290),
                new Student("art", 3, 180)
        );

        // lambda -> studentStream.sorted(Comparator.comparing(Student s) -> s.getBan)
        studentStream.sorted(Comparator.comparing(Student::getBan).reversed() //1. 반별
                .thenComparing(Comparator.naturalOrder())) // 기본정렬
                .forEach(System.out::println);
    }
}

class Student implements Comparable<Student> {  //comparable -기본정렬
    String name;
    int ban;
    int totalScore;

    Student(String name, int ban, int totalScore) {
        this.name =name;
        this.ban =ban;
        this.totalScore =totalScore;
    }

    public String toString() {
        return String.format("[%s, %d, %d]", name, ban, totalScore);
    }

    String getName()     { return name;}
    int getBan()         { return ban;}
    int getTotalScore()  { return totalScore;}

    //총점 내림차순 기본 정렬 : 높은거 - 낮은거
    public int compareTo(Student s) {
        return s.totalScore - this.totalScore;
    }
}
