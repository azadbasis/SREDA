package com.nanosoft.sreda.Model;


/**
 * Created by NanoSoft on 10/15/2017.
 */

public class Info_ReGeneration {
    private String projectName, technologyType, capacity, location, finance, completionDate, presentStatus;
    private int sl_No;

    public Info_ReGeneration() {
    }

    public Info_ReGeneration(int sl_No, String projectName, String technologyType, String capacity, String location, String finance, String completionDate, String presentStatus) {

        setSl_No(sl_No);
        setProjectName(projectName);
        setTechnologyType(technologyType);
        setCapacity(capacity);
        setLocation(location);
        setFinance(finance);
        setCompletionDate(completionDate);
        setPresentStatus(presentStatus);

    }

    public int getSl_No() {
        return sl_No;
    }

    public void setSl_No(int sl_No) {
        this.sl_No = sl_No;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getTechnologyType() {
        return technologyType;
    }

    public void setTechnologyType(String technologyType) {
        this.technologyType = technologyType;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFinance() {
        return finance;
    }

    public void setFinance(String finance) {
        this.finance = finance;
    }

    public String getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }

    public String getPresentStatus() {
        return presentStatus;
    }

    public void setPresentStatus(String presentStatus) {
        this.presentStatus = presentStatus;
    }
}
