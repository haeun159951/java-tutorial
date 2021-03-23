package com.siwoo.types;

import com.siwoo.entity.Student;

public class ArrayTest {
    
    public static void main(String[] args) {

//            [0] [1] [2] [3] [4]
//         [0] 1   2   3   4   5
//         [1] 8   9   3   2   6
//         [2] 2   2   2   3   4
//         [3] 5   6   7   8   9


        int[][] array = new int[4][5];
        array[0][0] = 1;
        array[0][1] = 2;
        array[0][2] = 3;
        array[0][3] = 4;
        array[0][4] = 5;

        array[1][0] = 8;
        array[1][1] = 9;
        array[1][2] = 3;
        array[1][3] = 2;
        array[1][4] = 6;

        array[2][0] = 5;
        array[2][1] = 6;
        array[2][2] = 7;
        array[2][3] = 8;
        array[2][4] = 9;

        array[3][0] = 1;
        array[3][1] = 2;
        array[3][2] = 3;
        array[3][3] = 4;
        array[3][4] = 5;


        for(int i =0; i<array.length; i++){
            for(int j = 0; j< array[i].length; j++){
                System.out.print(array[i][j]);
            }
            System.out.println();
        }




//        Student 학생 배열을 선언해보자.
//
//        Student 학생 배열을 초기화해보자.

//          0      1     2
//         [null, null, null]
        Student[] s = new Student[3];

        s[0] = new Student("seneca", "haeun", "CPA", false);
        s[1] = new Student("seneca", "siwoo", "CPA", true);
        s[2] = new Student("seneca", "kim", "IFS", true);
//
//         0 1 2
//         [Student(name=haeun), Student(name=siwoo), Student(name=kim)]

//        Student[] s = { new Student("seneca", "haeun", "CPA", false),
//                        new Student("seneca", "siwoo", "CPA", true),
//                        new Student("seneca", "kim", "IFS", true)
//                       };

        //Student 학생 배열을 앞에서 순회해보자.
        for(int i =0; i< s.length; i++){
            System.out.println(s[i].getClass());   //student
        }

        for(Student student : s){
            System.out.println(student);
        }

        System.out.println("");
        //Student 학생 배열을 뒤에서 순회해보자.
        for(int i = s.length-1; i >=0; i--){
            System.out.println(s[i]);
        }

        System.out.println("");
        //Student 학생 배열을 한칸씩 뛰어서 순회해보자.
        for(int i = 0; i < s.length; i++){
            if(i % 2 == 0){
                System.out.println(s[i]);
            }
        }
        
        final int[][] pascal = createPascalTriangle(5);

        int size = 5;
        int[][] x = new int[size][size];
        for (int i=1; i<=size; i++) {
            System.out.printf("i (%d): ", i);
            for (int j = 0; j < i; j++) {
                if (j == 0) {
                    x[i - 1][j] = 1;
                } else if (j == i - 1) {
                    x[i - 1][j] = 1;
                } else {
                    x[i - 1][j] = x[i - 2][j - 1] + x[i - 2][j];
                }
                System.out.print(x[i-1][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < i+1; j++)
                System.out.print(x[i][j] + " ");
            System.out.println();
        }
        // 파스칼의 삼각형 모양 그대로 순회해보자.
        // 파스칼의 삼각형 각 행 중 가장 큰 값만 순회해보자
    }

    private static int[][] createPascalTriangle(int N) {
        if (N < 0) throw new IllegalArgumentException("overflow");
        int[][] triangle = new int[N][N];
        return go(triangle, 1, N);
    }

    private static int[][] go(int[][] triangle, int size, int MAX) {
        if (size > MAX) return triangle;
        triangle[size-1][0] = 1;
        triangle[size-1][size-1] = 1;
        for (int i=1; i<size-1; i++)
            triangle[size-1][i] = 
                    triangle[size-2][i-1] + triangle[size-2][i];
        return go(triangle, size+1, MAX);
    }


}
