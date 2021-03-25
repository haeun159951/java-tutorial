package com.siwoo.Generic;

/*
* 제네릭 프로그래밍
* 데이터 타입에 의존하지 않고 여러 다른 데이터 타입을 가질 수 있게 허용하는 프로그래밍 방식
*
* 제네릭 클래스  : 어레이 리스트
* -> 제네릭 문법을 이용해 정의한 클래스
* 변수 : 데이터를 담는 공간
* 타입만 만족하면 어떤 데이터든 넣을 수 있다
*
* 타입 매개변수 (type parameter)
*  parameter - 함수 대가리 에 전달되는 파라미터 argument 인자값 는 메서드로 호출할때 생성되는
*
* 제너릭 메서드
* -> 제너릭 문법을 이용해 정의한 메서드
*
* 타입 경계 (type bound)
* -> 타입 매개변수에 할당할수 있는 타입을 제한 -> 범위를 줄이는것
*
* */


import java.util.ArrayList;
import java.util.List;

public class GenericTest {

    //제너릭 메서드는 다이아몬드 + 매개변수가 꼭 필요하다
    //run time 시 타입이 결정된
    public static <E extends Number> void swap(int i, int j, E[] elements){
        E e = elements[i];
        elements[i] =elements[j];
        elements[j] = e;
    }

    public static <E extends AutoCloseable & Runnable> void closeall(E[] resources) throws Exception{
        for(E e:resources){
            e.close();
        }
    }
    public static class Entry<K, V>{

        private K key;
        private V value;


        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public static void main(String[] args) {

        Entry<String, Integer> entry = new Entry<>("hello", 1);
        System.out.println(entry.key);
        System.out.println(entry.value);


        System.out.println("================================================");
        Entry<Object, Object> entry2 = new Entry<>(new Object(), new Object());
        System.out.println(entry2.key);
        System.out.println(entry2.value);

        Integer[] e = {1,2};
        swap(0,1,e);

       Number[] parent = e;
       swap(0,1, parent);

       Integer child = 1;
       Number p = child; //다형성

       Integer[] children = {1,2,3};
       Integer[] parent2 = children;  //다형성을 배열에 이용한다
        //공변성
        List<Integer> cc = new ArrayList<>();
        List<? extends Number> pp = cc;
    }



    private static class Employee implements Comparable<Employee> {
        private String name;
        private int salary;

        public Employee(String name, int salary) {
            this.name = name;
            this.salary = salary;
        }

        @Override
        public int compareTo(Employee o) {
            return Integer.compare(salary, o.salary);
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }

    private static class Manager extends Employee {

        public Manager(String name, int salary) {
            super(name, salary);
        }

    }

    /**
     * 제네릭으로 바꿔보자.
     */
    static class Sort<E extends Comparable<E>> {

        public void sort(List<E> list) {
            final int n = list.size();
            for (int i = 0; i < n; i++) {
                int min = i;
                for (int j = i + 1; j < n; j++) {
                    if (list.get(j).compareTo(list.get(min)) < 0)
                        min = j;
                }
                swap(i, min, list);
            }
            assert isSort(list);
        }

        private boolean isSort(List<E> list) {
            final int n = list.size();
            for (int i = 1; i < n; i++)
                if (list.get(i).compareTo(list.get(i - 1)) < 0)
                    return false;
            return true;
        }

        private void swap(int i, int j, List<E> list) {
            E tmp =list.get(i);
            //Employee tmp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, tmp);
        }
    }
}
