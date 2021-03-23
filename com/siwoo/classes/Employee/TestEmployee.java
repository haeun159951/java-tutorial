package com.siwoo.classes.Employee;

public class TestEmployee{
    public static void main(String[] args) {
        Employee[] e = new Employee[3];
        e[0] = new SalaryEmployee("Meg Manager", 500000);
        e[1] = new CommissionEmployee("Sal Salesman", .15, 3400);
        e[2] = new HourlyEmployee("Timmy Temp", 10.50, 25);

        for(Employee worker :e){
            System.out.println(worker);
            System.out.printf("Paycheck: $%.02f\n", worker.getPayment());
        }
    }
}
