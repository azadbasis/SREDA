package com.nanosoft.sreda.Model;

/**
 * Created by Nanosoft-Android on 11/21/2017.
 */

public class Info_TechWiseGeneration {

    private int sl_No;
    private double on_Grid;
    private double off_Grid;
    private double total;

    public Info_TechWiseGeneration(int sl_No, double on_Grid, double off_Grid, double total) {
        setSl_No(sl_No);
        setOn_Grid(on_Grid);
        setOff_Grid(off_Grid);
        setTotal(total);
    }


    public int getSl_No() {
        return sl_No;
    }

    public void setSl_No(int sl_No) {
        this.sl_No = sl_No;
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
