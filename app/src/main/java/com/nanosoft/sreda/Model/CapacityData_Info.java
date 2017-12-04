package com.nanosoft.sreda.Model;

/**
 * Created by Nanosoft-Android on 12/4/2017.
 */

public class CapacityData_Info {

    /* "technology_name": "Solar",
            "position": "1",
            "on_grid": 100,
            "off_grid": 10,
            "total": 110*/

    private String technology_name;
    private String position;
    private String on_grid;
    private String off_grid;
    private String total;

    public CapacityData_Info(String technology_name, String position, String on_grid, String off_grid, String total) {
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

    public String getOn_grid() {
        return on_grid;
    }

    public void setOn_grid(String on_grid) {
        this.on_grid = on_grid;
    }

    public String getOff_grid() {
        return off_grid;
    }

    public void setOff_grid(String off_grid) {
        this.off_grid = off_grid;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
