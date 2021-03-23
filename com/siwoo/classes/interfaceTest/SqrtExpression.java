package com.siwoo.classes.interfaceTest;

public class SqrtExpression implements Expression {
    private String exp;

    @Override
    public void setExpression(String exp) {
        this.exp =exp;
    }

    @Override
    public String getExpression() {
        return exp;
    }

    @Override
    public String evaluate() {
        if (!hasExpression())
            throw new IllegalStateException();
        return Double.toString(Math.sqrt(Integer.parseInt(exp)));
    }
}
