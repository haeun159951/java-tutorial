package com.siwoo.classes.interfaceTest;

public class NegateExpression implements Expression{
    private EqualExpression equalExpression;

    public NegateExpression(String delimiter) {
        equalExpression = new EqualExpression(delimiter);
    }

    @Override
    public void setExpression(String exp) {
        this.equalExpression.setExpression(exp);
    }

    @Override
    public String getExpression() {
        return this.equalExpression.getExpression();
    }

    @Override
    public String evaluate() {
        String e = this.equalExpression.evaluate();
        if ("true".equals(e))
            return "false";
        else
            return "true";
    }

    public static void main(String[] args) {
        Expression expression = new PlusExpression();
        expression.setExpression("133+255");
        String x = expression.evaluate();
        System.out.println("Plus: " + x); //388

        expression = new MinusExpression();
        expression.setExpression("255-100");
        x =  expression.evaluate();
        System.out.println("Minus: " + x);

        expression = new SqrtExpression();
        expression.setExpression("153");
        x = expression.evaluate();
        System.out.println("Sqrt: " + x); //12.....

        expression = new EqualExpression("==");
        expression.setExpression("1==10");
        System.out.println(expression.evaluate()); // false

        expression.setExpression("153==153");
        System.out.println(expression.evaluate()); // true

        expression = new NegateExpression("!=");
        expression.setExpression("100!=100");
        System.out.println(expression.evaluate()); //false
    }

}
