package com.siwoo.classes.Employee;

public class SalaryEmployee extends Employee{
    private double salary;

    public SalaryEmployee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getPayment(){
        return salary / 12 /2;
    }
    @Override
    public String toString() {

        return String.format("%s, salary:$ %.02f",getName(), getSalary());
//        return "SalaryEmployee{" +
//                "salary: $" + salary +
//                '}';
    }
}
