package com.siwoo.classes.bank;

import javax.security.auth.callback.CallbackHandler;

public class Cash {
        private int amount;

    public Cash(int amount) {
        this.amount = amount;
    }

    public boolean hasEnoughMoney(int amount){
            if(this.amount - amount < 0 ){
               return false;
            } else {
                System.out.println("ok");
                return true;
            }
        }

        public void deposit(int amount){
            this.amount += amount;
        }

        public void withdraw(int amount){
        if(!hasEnoughMoney(amount)){
            throw new IllegalArgumentException();
        }
            this.amount -= amount;
        }

        public int amount() {
            return amount;
        }

    public static void main(String[] args) {
        Cash cash = new Cash(10);
        cash.withdraw(20);
    }
}
