package com.siwoo.classes.interfaceTest;

public class PlusExpression implements Expression{
    private String exp;

    @Override
    public void setExpression(String exp) {
        this.exp = exp;

    }

    @Override
    public String getExpression() {
        return exp;
    }

    @Override
    public String evaluate() {
        if (!hasExpression())
            throw new IllegalStateException();
        String[] params = exp.split("\\+");
        return Integer.toString(Integer.parseInt(params[0]) + Integer.parseInt(params[1]));
    }
}
