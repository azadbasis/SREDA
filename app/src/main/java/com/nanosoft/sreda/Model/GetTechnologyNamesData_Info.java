package com.nanosoft.sreda.Model;

/**
 * Created by Nanosoft-Android on 12/5/2017.
 */

public class GetTechnologyNamesData_Info {

    /* {
            "id": "7",
            "name": "Solar"
        },*/


    private int id;
    private String name;


    public GetTechnologyNamesData_Info(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
