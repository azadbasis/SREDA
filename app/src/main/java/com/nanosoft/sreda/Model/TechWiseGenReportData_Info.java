package com.nanosoft.sreda.Model;

import java.util.ArrayList;

/**
 * Created by Nanosoft-Android on 12/5/2017.
 */

public class TechWiseGenReportData_Info {


    private ArrayList<TechWiseGenReportSubCategory_Info> subCategory;


    public TechWiseGenReportData_Info(ArrayList<TechWiseGenReportSubCategory_Info> subCategory) {
        this.subCategory = subCategory;
    }

    public ArrayList<TechWiseGenReportSubCategory_Info> getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(ArrayList<TechWiseGenReportSubCategory_Info> subCategory) {
        this.subCategory = subCategory;
    }
}
