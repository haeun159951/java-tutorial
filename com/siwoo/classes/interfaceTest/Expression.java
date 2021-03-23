package com.siwoo.classes.interfaceTest;

public interface Expression {
    void setExpression(String s);  //abstract method
    String getExpression();  //abstract method
    String evaluate(); //abstract method

    default boolean hasExpression(){
        return getExpression() != null &&
                !getExpression().isEmpty();
    }
}
