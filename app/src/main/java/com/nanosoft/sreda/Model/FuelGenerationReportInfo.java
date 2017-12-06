package com.nanosoft.sreda.Model;

/**
 * Created by NanoSoft on 12/5/2017.
 */

public class FuelGenerationReportInfo {

//    "id": "1",
//            "name": "Coal",
//            "installed_capacity": "250",
//            "fuel_order": "1",
//            "status": "1",
//            "is_checked": "1"

    String id,name,installed_capacity,fuel_order,status,is_checked,color;

    public FuelGenerationReportInfo() {
    }

    public FuelGenerationReportInfo(String id, String name, String installed_capacity, String fuel_order, String status, String is_checked) {
        this.id = id;
        this.name = name;
        this.installed_capacity = installed_capacity;
        this.fuel_order = fuel_order;
        this.status = status;
        this.is_checked = is_checked;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstalled_capacity() {
        return installed_capacity;
    }

    public void setInstalled_capacity(String installed_capacity) {
        this.installed_capacity = installed_capacity;
    }

    public String getFuel_order() {
        return fuel_order;
    }

    public void setFuel_order(String fuel_order) {
        this.fuel_order = fuel_order;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIs_checked() {
        return is_checked;
    }

    public void setIs_checked(String is_checked) {
        this.is_checked = is_checked;
    }
}
