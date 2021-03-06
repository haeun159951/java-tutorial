package com.siwoo.classes.interfaceTest;

public class LiteralExpression implements Expression {
    private String exp;

    @Override
    public void setExpression(String exp) {
        this.exp = exp;
    }

    @Override
    public String getExpression() {
        return this.exp;
    }

    @Override
    public String evaluate() {
        if (!hasExpression())
            throw new IllegalStateException();
        return exp.trim();
    }

}
