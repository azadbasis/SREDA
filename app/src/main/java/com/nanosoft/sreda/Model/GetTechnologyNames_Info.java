package com.nanosoft.sreda.Model;

import java.util.ArrayList;

/**
 * Created by Nanosoft-Android on 12/5/2017.
 */

public class GetTechnologyNames_Info {

    private int status;
    private ArrayList<GetTechnologyNamesData_Info> data;


    public GetTechnologyNames_Info(int status, ArrayList<GetTechnologyNamesData_Info> data) {
        this.status = status;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ArrayList<GetTechnologyNamesData_Info> getData() {
        return data;
    }

    public void setData(ArrayList<GetTechnologyNamesData_Info> data) {
        this.data = data;
    }
}
