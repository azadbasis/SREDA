package com.nanosoft.sreda.Model;

import java.util.ArrayList;

/**
 * Created by Nanosoft-Android on 12/5/2017.
 */

public class TechWiseGenReportData_Info {


    private ArrayList<TechWiseGenReportSubCategory_Info> sub_category = new ArrayList<>();

String technology_name,parent_position;

    public TechWiseGenReportData_Info(ArrayList<TechWiseGenReportSubCategory_Info> subCategory, String technology_name, String parent_position) {
        this.sub_category = subCategory;
        this.technology_name = technology_name;
        this.parent_position = parent_position;
    }

    public ArrayList<TechWiseGenReportSubCategory_Info> getSub_category() {
        return sub_category;
    }

    public void setSub_category(ArrayList<TechWiseGenReportSubCategory_Info> sub_category) {
        this.sub_category = sub_category;
    }

    public String getTechnology_name() {
        return technology_name;
    }

    public void setTechnology_name(String technology_name) {
        this.technology_name = technology_name;
    }

    public String getParent_position() {
        return parent_position;
    }

    public void setParent_position(String parent_position) {
        this.parent_position = parent_position;
    }
}
