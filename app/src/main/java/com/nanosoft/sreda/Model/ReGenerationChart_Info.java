package com.nanosoft.sreda.Model;

/**
 * Created by Nanosoft-Android on 12/3/2017.
 */

public class ReGenerationChart_Info {

    private String technology;
    private double on_Grid;
    private double off_Grid;
    private double total;


    public ReGenerationChart_Info(String technology, double on_Grid, double off_Grid, double total) {
        setTechnology(technology);
        setOn_Grid(on_Grid);
        setOff_Grid(off_Grid);
        setTotal(total);
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public double getOn_Grid() {
        return on_Grid;
    }

    public void setOn_Grid(double on_Grid) {
        this.on_Grid = on_Grid;
    }

    public double getOff_Grid() {
        return off_Grid;
    }

    public void setOff_Grid(double off_Grid) {
        this.off_Grid = off_Grid;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
