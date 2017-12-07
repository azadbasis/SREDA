package com.nanosoft.sreda.Model;

/**
 * Created by Nanosoft-Android on 12/4/2017.
 */

public class Info_CapacityData {

    /* "technology_name": "Solar",
            "position": "1",
            "on_grid": 100,
            "off_grid": 10,
            "total": 110*/

    private String technology_name;
    private String position;
    private String color;
    private double on_grid;
    private double off_grid;
    private double total;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Info_CapacityData(String technology_name, String position, double on_grid, double off_grid, double total) {
        this.technology_name = technology_name;
        this.position = position;
        this.on_grid = on_grid;
        this.off_grid = off_grid;
        this.total = total;
    }

    public String getTechnology_name() {
        return technology_name;
    }

    public void setTechnology_name(String technology_name) {
        this.technology_name = technology_name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getOn_grid() {
        return on_grid;
    }

    public void setOn_grid(double on_grid) {
        this.on_grid = on_grid;
    }

    public double getOff_grid() {
        return off_grid;
    }

    public void setOff_grid(double off_grid) {
        this.off_grid = off_grid;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
