package com.siwoo.stream;

import javax.swing.text.html.Option;
import java.util.Optional;

public class StreamEx0 {
    public static void main(String[] args) {
        int[] arr = new int[0];
        System.out.println("arr.length = " + arr.length);
        Optional<String> opt = Optional.empty();
//        Optional<String> opt = Optional.of("abc");
        System.out.println("opt=" + opt);
        System.out.println("opt"+opt.get());

        String str = "";
        str = opt.get(); //exception



    }

}
