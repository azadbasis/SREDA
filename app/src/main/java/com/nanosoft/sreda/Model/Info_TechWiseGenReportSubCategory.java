package com.nanosoft.sreda.Model;

/**
 * Created by Nanosoft-Android on 12/5/2017.
 */

public class Info_TechWiseGenReportSubCategory {


    /* "sub_category_title": "Solar Roof Top",
                    "sub_category_position": "105",
                    "on_grid": 100,
                    "off_grid": 0,
                    "toe": 67.8,
                    "total": 100,
                    "no_on_system": 2*/


    private String sub_category_title;
    private String sub_category_position;
    private double on_grid;
    private double off_grid;
    private double toe;
    private double total;
    private int no_on_system;

    public Info_TechWiseGenReportSubCategory(String sub_category_title, String sub_category_position, double on_grid, double off_grid, double toe, double total, int no_on_system) {
        this.sub_category_title = sub_category_title;
        this.sub_category_position = sub_category_position;
        this.on_grid = on_grid;
        this.off_grid = off_grid;
        this.toe = toe;
        this.total = total;
        this.no_on_system = no_on_system;
    }

    public String getSub_category_title() {
        return sub_category_title;
    }

    public void setSub_category_title(String sub_category_title) {
        this.sub_category_title = sub_category_title;
    }

    public String getSub_category_position() {
        return sub_category_position;
    }

    public void setSub_category_position(String sub_category_position) {
        this.sub_category_position = sub_category_position;
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

    public double getToe() {
        return toe;
    }

    public void setToe(double toe) {
        this.toe = toe;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getNo_on_system() {
        return no_on_system;
    }

    public void setNo_on_system(int no_on_system) {
        this.no_on_system = no_on_system;
    }
}
