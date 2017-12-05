package com.nanosoft.sreda.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NanoSoft on 12/5/2017.
 */

public class FuelGenerationRepoResponse {


    private int status;
    private List<FuelGenerationReportInfo> data=new ArrayList<>();

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<FuelGenerationReportInfo> getData() {
        return data;
    }

    public void setData(List<FuelGenerationReportInfo> data) {
        this.data = data;
    }
}
