package com.siwoo.bytes;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class TestStream {
    public static void main(String[] args) throws IOException {
        //systemInAndSystemOut();
        //byteArrayStream();
        //bufferTest();
        scannerTest();
    }

    private static void scannerTest() {
        String test = "this,is,a,test data"; //토큰 구분자로 쪼개지는 것
        byte[] bytes = test.getBytes();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        Scanner sc = new Scanner(new BufferedInputStream(in)); //성능향상을 위해 항상 넣는다
        sc.useDelimiter(",");

        while(sc.hasNext()){
            System.out.println(sc.next());
        }
    }

    private static void bufferTest() throws IOException {
        long  start = System.currentTimeMillis();
        readFile(new FileInputStream("./chromosome4.txt"));
        long end = System.currentTimeMillis();
        System.out.println((end - start) + "ms");
        System.out.println("=======================================");


        start = System.currentTimeMillis();
        readFile(new BufferedInputStream(new FileInputStream("./chromosome4.txt")));
        end =  System.currentTimeMillis();
        System.out.println((end - start) + "ms");

    }

    public static void readFile(InputStream in) throws IOException {
        int data;
        while((data = in.read()) != -1){
            //System.out.println((char) data);
        }
    }
    private static void byteArrayStream() throws IOException {
        String test = "this is a source data";
        byte[] source = test.getBytes(StandardCharsets.UTF_8);
        //byte 배열로부터 읽기 바이트 배열 스트림 생성
        ByteArrayInputStream in = new ByteArrayInputStream(source);
        byte[] destination = new byte[source.length];
        // index: destination 몇번쨰 저장할지 기록
        // data: input stream에서 저장할
        int index = 0, data = -1;
        // 입력소스 바이트 하나를 읽어와서 데이터에 저장 하고 나서 (data != -1)
        // 데이터가 읽을게 남아있을때까지 돈
        while((data = in.read()) != -1){
            destination[index++] = (byte)data;
        }
        for(byte b:destination){
            System.out.print(b);
        }
        System.out.println("\n==========================================");
        System.out.println(new String(destination)); // string 배열로 바꾸어준다.바이트니깐
        in.close();

        ByteArrayOutputStream out= new ByteArrayOutputStream(8);
        out.write(source); // 주어진 배열의 데이터를 읽어오는거: 출력위치는 바이트 어레이
        byte[] target = out.toByteArray();
        System.out.println(new String(target));

    }

    private static void systemInAndSystemOut() {
        try{
            int asciiCode = System.in.read(); //keyboard 데이터 흘러들어온다
            System.out.write(asciiCode); // 데이터를 써야 한다 ->모니터에다가
            System.out.flush();

            System.out.println();
        } catch(IOException e){
            //ignore
        }
    }
}
