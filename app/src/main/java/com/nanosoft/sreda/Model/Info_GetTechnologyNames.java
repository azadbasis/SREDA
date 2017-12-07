package com.nanosoft.sreda.Model;

import java.util.ArrayList;

/**
 * Created by Nanosoft-Android on 12/5/2017.
 */

public class Info_GetTechnologyNames {

    private int status;
    private ArrayList<Info_GetTechnologyNamesData> data;


    public Info_GetTechnologyNames(int status, ArrayList<Info_GetTechnologyNamesData> data) {
        this.status = status;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ArrayList<Info_GetTechnologyNamesData> getData() {
        return data;
    }

    public void setData(ArrayList<Info_GetTechnologyNamesData> data) {
        this.data = data;
    }
}
