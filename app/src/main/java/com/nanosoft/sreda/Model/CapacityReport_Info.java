package com.nanosoft.sreda.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nanosoft-Android on 12/4/2017.
 */

public class CapacityReport_Info {


    /* "status": 2000,
    "data": [
        {
            "technology_name": "Solar",
            "position": "1",
            "on_grid": 100,
            "off_grid": 10,
            "total": 110
        },*/
    private String status;
    private List<CapacityData_Info> data=new ArrayList<>();

    public CapacityReport_Info(String status, ArrayList<CapacityData_Info> data) {
        this.status = status;
        this.data = data;
    }

    public CapacityReport_Info() {

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<CapacityData_Info> getData() {
        return (ArrayList<CapacityData_Info>) data;
    }

    public void setData(ArrayList<CapacityData_Info> data) {
        this.data = data;
    }
}
