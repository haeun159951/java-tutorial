package com.siwoo.bytes;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class IOEx3 {
    public static void main(String[] args) {
        byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] outSrc = null;

        byte[] temp = new byte[4];

        ByteArrayInputStream input = null;
        ByteArrayOutputStream output = null;

        input = new ByteArrayInputStream(inSrc);
        output = new ByteArrayOutputStream();

        try{
            while(input.available() > 0 ){ // 아직 읽을게 남아있냐 0,1,2,3 / 4,5,6,7 / 8,9
                input.read(temp); //데이터 쓰는것

                output.write(temp); // 템프의 데이터를 읽어와서 내부적인 바이트 어레이에 쓰는것

                System.out.println("temp: " + Arrays.toString(temp));

            }
        }catch(IOException e){}

        outSrc = output.toByteArray();
        System.out.println("Input Source: " + Arrays.toString(inSrc));
        System.out.println("temp Source: " + Arrays.toString(temp));
        System.out.println("Output Source: " + Arrays.toString(outSrc));
    }
}
