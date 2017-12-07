package com.nanosoft.sreda.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nanosoft-Android on 12/4/2017.
 */

public class Info_CapacityResponse {


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
    private List<Info_CapacityData> data=new ArrayList<>();



    public Info_CapacityResponse(int status, List<Info_CapacityData> data) {
        this.status = status;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Info_CapacityData> getData() {
        return data;
    }

    public void setData(List<Info_CapacityData> data) {
        this.data = data;
    }
}
