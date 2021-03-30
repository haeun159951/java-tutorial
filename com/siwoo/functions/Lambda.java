package com.siwoo.functions;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Predicate;

/*
* 람다
* 전달할 수 있는 코드 블럭
* 익명 함수 (anonymous functions)
* () -> {}
* 괄호 (파라미터) 중괄호 (바디)
*
* 메서드 참조
* 1. 클래스::스태특메서드
* 2. 클래스::인스턴스 메서드
* 3. 객체::인스턴스메서
* */
public class Lambda {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static void main(String[] args) throws InterruptedException {
        //객체의 순서를 정리
        // Comparable - default / 추가 정렬
        final String[] strings = {"python", "perl", "c", "c++", "java", "javascript", "php", "go"};

        Comparator<String> cmp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int diff = o1.length() - o2.length();
                if(diff < 0) return -1;
                else if (diff > 0) return 1;
                return 0;
            }
        };

        String [] copy = copyOf(String.class, strings, s -> true);
        Arrays.sort(copy, cmp);
        System.out.println(Arrays.toString(copy));

        System.out.println("===========================================");
        Comparator<String> lambda = (o1, o2) ->{
            int diff = o1.length() - o2.length();
            if(diff < 0) return -1;
            else if (diff > 0) return 1;
            return 0;
        };

        Comparator<String> lambda2 = String::compareToIgnoreCase; //클래스-인스턴스 메서

        copy = copyOf(String.class, strings, s -> true);
        Arrays.sort(copy, lambda);
        System.out.println(Arrays.toString(copy));

        Runnable task = () -> System.out.println("run a task in thread");
        new Thread(task).start();
        TimeUnit.SECONDS.sleep(2);

        Consumer<String> consumer = color -> {
            Runnable runnable = () -> System.out.println(color + "run a task");
            new Thread(runnable).start();
        };

        for(String color: Arrays.asList(ANSI_CYAN, ANSI_YELLOW, ANSI_RED)){
            consumer.accept(color);
        }
        TimeUnit.SECONDS.sleep(2);

        HauenInterface hauenInterface = s -> s.toUpperCase();

        List<String> result = new ArrayList<>();
        Predicate<String> predicate = s -> s.length() >= 3;
        //문자열이 3글자 이상인 것만 저장하는
         for(int i =0; i<strings.length; i++){
             if (predicate.test(strings[i])){
                 String s = strings[i];
                 result.add(s);
             }
         }

         for (int i =0; i< result.size(); i++){
             System.out.println(result.get(i)); //arraylist 는 겟 이용한
         }

         //메서드 참조
        result.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        System.out.println(Arrays.toString(copyOf(String.class, strings, s -> s.length()>=3)));
        System.out.println(Arrays.toString(copyOf(String.class, strings, s -> s.contains("java"))));
    }

    @FunctionalInterface
    public interface HauenInterface {
        String map(String string);
    }

    public static <T> T[] copyOf(Class<T> clazz, T[] source, Predicate<T> predicate) {
        T[] array = (T[]) Array.newInstance(clazz, source.length);
        int i = 0;
        for (T t: source)
            if (predicate.test(t))
                array[i++] = t;
        return array;
    }
}
