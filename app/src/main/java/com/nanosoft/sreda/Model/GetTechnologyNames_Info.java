package com.nanosoft.sreda.Model;

import java.util.ArrayList;

/**
 * Created by Nanosoft-Android on 12/5/2017.
 */

public class GetTechnologyNames_Info {

    private int status;
    private ArrayList<GetTechnologyNamesData_Info> getTechnologyNamesData_infoArrayList;


    public GetTechnologyNames_Info(int status, ArrayList<GetTechnologyNamesData_Info> getTechnologyNamesData_infoArrayList) {
        this.status = status;
        this.getTechnologyNamesData_infoArrayList = getTechnologyNamesData_infoArrayList;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ArrayList<GetTechnologyNamesData_Info> getGetTechnologyNamesData_infoArrayList() {
        return getTechnologyNamesData_infoArrayList;
    }

    public void setGetTechnologyNamesData_infoArrayList(ArrayList<GetTechnologyNamesData_Info> getTechnologyNamesData_infoArrayList) {
        this.getTechnologyNamesData_infoArrayList = getTechnologyNamesData_infoArrayList;
    }
}
