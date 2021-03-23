package com.siwoo.classes.interfaceTest;

public class EqualExpression implements Expression{

    private String delimiter, exp;

    public EqualExpression(String delimiter) {
        this.delimiter = delimiter;
    }


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
        String[] params = exp.split(delimiter);
        if (params[0].equals(params[1]))
            return "true";
        else
            return "false";
    }
}
