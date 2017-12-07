package com.nanosoft.sreda.Model;

/**
 * Created by Nanosoft-Android on 12/3/2017.
 */

public class Info_ElectricGenMixChart {

    private String name;
    private double capacity;
    private double percentage;
    private double total;


    public Info_ElectricGenMixChart(String name, double capacity, double percentage, double total) {

        setName(name);
        setCapacity(capacity);
        setPercentage(percentage);
        setTotal(total);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }
    public void setTotal(double total) {
        this.total = total;
    }

    public double getPercentage() {
        return percentage;
    }

    public double getTotal() {
        return total;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
