package com.nanosoft.sreda.Model;

import java.util.ArrayList;

/**
 * Created by Nanosoft-Android on 12/5/2017.
 */

public class Info_TechWiseGenReportResponse {

    private int status;
    private ArrayList<Info_TechWiseGenReportData> data;

    public Info_TechWiseGenReportResponse(int status, ArrayList<Info_TechWiseGenReportData> data) {
        this.status = status;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ArrayList<Info_TechWiseGenReportData> getData() {
        return data;
    }

    public void setData(ArrayList<Info_TechWiseGenReportData> data) {
        this.data = data;
    }
}
