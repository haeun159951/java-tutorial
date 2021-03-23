package com.siwoo.classes.Employee;

public class CommissionEmployee extends Employee{
    private double commissionRate;
    private double totalSales;

    public CommissionEmployee(String name, double commissionRate, double totalSales) {
        super(name);
        this.commissionRate = commissionRate;
        this.totalSales = totalSales;
    }

    public double getPayment(){
        return commissionRate * totalSales;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }

    @Override
    public String toString() {

        return String.format("%s, commission:$ %.02f@ $ %.02f sales",getName(), getCommissionRate(), getTotalSales());
    }
}
