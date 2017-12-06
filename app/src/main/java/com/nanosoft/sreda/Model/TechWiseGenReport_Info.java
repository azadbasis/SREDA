package com.nanosoft.sreda.Model;

import java.util.ArrayList;

/**
 * Created by Nanosoft-Android on 12/5/2017.
 */

public class TechWiseGenReport_Info {

    private int status;
    private ArrayList<TechWiseGenReportData_Info> data;

    public TechWiseGenReport_Info(int status, ArrayList<TechWiseGenReportData_Info> data) {
        this.status = status;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ArrayList<TechWiseGenReportData_Info> getData() {
        return data;
    }

    public void setData(ArrayList<TechWiseGenReportData_Info> data) {
        this.data = data;
    }
}