package com.nanosoft.sreda.Model;

/**
 * Created by NanoSoft on 12/31/2017.
 */

public class Solar
{
    private String off_grid;

    private String on_grid;

    @Override
    public String toString() {
        return "Solar{" +
                "off_grid='" + off_grid + '\'' +
                ", on_grid='" + on_grid + '\'' +
                '}';
    }

    public String getOff_grid() {
        return off_grid;
    }

    public void setOff_grid(String off_grid) {
        this.off_grid = off_grid;
    }

    public String getOn_grid() {
        return on_grid;
    }

    public void setOn_grid(String on_grid) {
        this.on_grid = on_grid;
    }
}
