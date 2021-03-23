package com.siwoo.accessmodifier;

public class AccessModifier {
    //1. private  - only in the class
    private String secret;
    //2.default var
    String lastName = "kim";
    //3. protected
    protected String firstName = "Haeun";
    // 4. public: can access anywhere
    public String msg= "This is a public message";

    private String getSecret() {
        return this.secret;
    }

    public static void main(String[] args) {
        AccessModifier am = new AccessModifier();
        // 2. can access default variable in the same package
        System.out.println(am.lastName);
        System.out.println(am.msg);
        System.out.println(am.firstName);
    }
}
