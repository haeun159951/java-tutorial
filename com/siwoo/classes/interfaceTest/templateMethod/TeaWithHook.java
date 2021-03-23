package com.siwoo.classes.interfaceTest.templateMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TeaWithHook extends CaffeineBeverage{
    public void brew(){
        System.out.println("차를  우려내는중");
    }
    public void addCondiments(){
        System.out.println("레몬 추가하는 중");
    }


    boolean customerWantsCondiments(){
        String answer = getUserInput();
        if(answer.toLowerCase().startsWith("y")){
            return true;
        }
        return false;
    }

    private String getUserInput(){
        String answer = null;

        System.out.println("레몬을 넣어드릴까요? 예/아니오");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        try{
            answer = in.readLine();
        } catch (IOException ioe){
            System.err.println("IO 오류");
        }

        if(answer ==null){
            return "no";
        }
        return answer;
    }

}
