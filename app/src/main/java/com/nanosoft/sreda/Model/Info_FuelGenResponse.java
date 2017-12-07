package com.nanosoft.sreda.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NanoSoft on 12/5/2017.
 */

public class Info_FuelGenResponse {


    private int status;
    private List<Info_FuelGenReport> data=new ArrayList<>();

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Info_FuelGenReport> getData() {
        return data;
    }

    public void setData(List<Info_FuelGenReport> data) {
        this.data = data;
    }
}
