package com.siwoo.classes.Employee;

abstract class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //abstract method
    abstract double getPayment();

    @Override
    public String toString() {
        return "Employee{" +
                    "name='" + name + '\'' + '}';
    }

}
