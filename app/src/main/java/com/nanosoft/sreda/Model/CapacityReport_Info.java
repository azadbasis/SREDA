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
    private int status;
    private List<CapacityData_Info> data=new ArrayList<>();


    public CapacityReport_Info(int status, List<CapacityData_Info> data) {
        this.status = status;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<CapacityData_Info> getData() {
        return data;
    }

    public void setData(List<CapacityData_Info> data) {
        this.data = data;
    }
}
