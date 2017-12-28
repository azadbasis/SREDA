package com.nanosoft.sreda.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nanosoft-Android on 12/5/2017.
 */

public class Info_TechWiseGenReportResponse {

    private int status;
    private List<Info_TechWiseGenReportData> data = new ArrayList<>();

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

    public List<Info_TechWiseGenReportData> getData() {
        return data;
    }

    public void setData(List<Info_TechWiseGenReportData> data) {
        this.data = data;
    }

    public void setData(ArrayList<Info_TechWiseGenReportData> data) {
        this.data = data;
    }
}
