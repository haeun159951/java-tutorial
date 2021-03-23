package com.siwoo.classes.oneCard;

import java.util.Arrays;

public class CardPack {
    private Card[] cards;

    public CardPack() {
        this.cards = new Card[52];
        String[] suits = {Card.HEART, Card.SPADE, Card.CLUB, Card.DIAMOND};
        int index = 0;
        for (String suit : suits) {
            for (int i = 1; i <= 13; i++) {
                Card card = new Card(i, suit);
                cards[index++] = card;
            }
        }
    }


    @Override
    public String toString() {
      String s= "";
      for(int i =0; i<cards.length; i++) {
          s += cards[i] + "\n";
      }
      return s;
    }

    public int numberOfCards(){
        return cards.length;
    }

    public Card[] getCards(String suit){
        Card[] tmp = new Card[cards.length / 4];
        int idx = 0;
        for(int i =0; i<cards.length; i++){
            if (suit.equalsIgnoreCase(cards[i].getSuit())){
                tmp[idx++] = cards[i];
            }
        }
        return tmp;
    }

    public Card[] getCards(int number){
        Card[] tmp = new Card[4];
        int idx = 0;
        for(int i =0; i< cards.length; i++){
            if(number == cards[i].getNumber()){
                tmp[idx++] = cards[i];
            }
        }
        return tmp;
    }

    public void flip(){
       for(Card card: cards)
           card.flip();
    }

    public void flip(boolean flip){
       for(Card card:cards)
           card.flip(flip);
    }


    public static void main(String[] args) {
        CardPack cp = new CardPack();
        System.out.println(cp);
        System.out.println(Arrays.toString(cp.getCards("Spade")));
        System.out.println(Arrays.toString(cp.getCards(5)));

        cp.flip();
        System.out.println(Arrays.toString(cp.getCards("Spade")));
        System.out.println(cp);
    }
}
