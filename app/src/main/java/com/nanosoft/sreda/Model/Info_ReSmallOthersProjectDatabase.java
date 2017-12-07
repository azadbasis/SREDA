package com.nanosoft.sreda.Model;

import java.util.Date;

/**
 * Created by Nanosoft-Android on 11/21/2017.
 */

public class Info_ReSmallOthersProjectDatabase {

    private int sl_No;
    private int NIRES_NO;
    private String agency;
    private Date date;
    private String system_Name;
    private int number;
    private double capacity;
    private double TOE;


    public Info_ReSmallOthersProjectDatabase(int sl_No, int NIRES_NO, String agency, Date date, String system_Name, int number, double capacity, double TOE) {
        setSl_No(sl_No);
        setNIRES_NO(NIRES_NO);
        setAgency(agency);
        setDate(date);
        setSystem_Name(system_Name);
        setNumber(number);
        setCapacity(capacity);
        setTOE(TOE);
    }

    public int getSl_No() {
        return sl_No;
    }

    public void setSl_No(int sl_No) {
        this.sl_No = sl_No;
    }

    public int getNIRES_NO() {
        return NIRES_NO;
    }

    public void setNIRES_NO(int NIRES_NO) {
        this.NIRES_NO = NIRES_NO;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSystem_Name() {
        return system_Name;
    }

    public void setSystem_Name(String system_Name) {
        this.system_Name = system_Name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getTOE() {
        return TOE;
    }

    public void setTOE(double TOE) {
        this.TOE = TOE;
    }
}
