package com.siwoo.classes.oneCard;

public class Card {
    public static final String HEART ="HEART";
    public static final String SPADE = "SPADE";
    public static final String DIAMOND ="DIAMOND";
    public static final String CLUB ="CLUB";
    public static int HEIGHT = 1;
    public static int WIDTH = 2;
    private boolean flipped;
    private int number;
    private String suit;

    public Card(int number, String suit) {
        this.number = number;
        this.suit = suit;
    }

    public boolean isFlipped() {
        return flipped;
    }

    public void setFlipped(boolean flipped) {
        this.flipped = flipped;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
       if(flipped){
           return "[HIDE]";
       }else if(number == 1){
           return "[" + suit + " A" + "]";
       }else if(number == 11){
           return "[" + suit + " J" + "]";
       }else if(number == 12){
           return "[" + suit + " Q" + "]";
       } else if(number == 13){
               return "[" + suit + " K" + "]";
       }else{
           return "[" + suit + " " + number+ "]";
       }
    }

    public void flip(){
        flipped = !flipped;
//       boolean isflip;
//
//       if(isFlipped()){
//           isflip = false;
//       }
//       else{
//           isflip= true;
//       }
    }
    public void flip(boolean f){
        this.flipped = f;
    }
}
