package com.siwoo.types;

import com.siwoo.Quiz;

public class TypesQuiz2 {

    private static Dog[] d = {new Dog("haeun"),new Dog("siwoo"),new Dog("kim")};
    
    private static class Q1 implements Quiz<Integer> {
        private int[] nums;

        public Q1(int[] nums) {
            this.nums = nums;
        }

        public Integer answer() {
            return -1;
        }
    }
    
    private static class Q2 implements Quiz<Integer> {
        private int[] nums;

        public Q2(int[] nums) {
            this.nums = nums;
        }
        
        public Integer answer() {
            return -1;
        }
    }
    
    private static class Q3 implements Quiz<Dog[]> {
        Dog[] d = {new Dog("haeun"),new Dog("siwoo"),new Dog("kim")};
        public Dog[] answer() {
            return d;
        }
    }

    private static class Q4 implements Quiz<int[]> {
        private int[] nums;

        public Q4(int[] nums) {
            this.nums = nums;
        }

        public int[] answer() {
            return null;
        }
    }

    private static class Q5 implements Quiz<int[]> {
        private int[] nums;

        public Q5(int[] nums) {
            this.nums = nums;
        }

        public int[] answer() {
            return null;
        }
    }


    private static class Q6 implements Quiz<Void> {
        Dog[] d;

        public Q6(Dog[] d) {
            this.d = d;
        }

        public Void answer() {
            int index=0;
            while(index < d.length){
                System.out.println(d[index++].getName());
            }

            return null;
        }
    }

    public static void main(String[] args) {
        Q6 q6 = new Q6(d);
        q6.answer();
    }
    
    private static class Q7 implements Quiz<Void>  {
        private int[] nums;

        public Q7(int[] nums) {
            this.nums = nums;
        }

        public Void answer() {
            return null;
        }
    }
    
    // 문서에 나온대로 Dog 구현해보기.
    private static class Dog {
        private String name;

        public Dog(String n){
            name = n;
        }

        public String getName(){
            return name;
        }
    }
}
