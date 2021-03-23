package com.siwoo.accessmodifier;

// private -  only this class
public class Private {
    private String secret;
    private String getSecret() {
        return this.secret;
    }

    public static void main(String[] args) {
        HouseKim kim = new HouseKim();
        System.out.println("house kim - default" + kim.lastname);
    }
}
