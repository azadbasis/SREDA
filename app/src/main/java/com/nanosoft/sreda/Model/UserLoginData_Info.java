package com.nanosoft.sreda.Model;

/**
 * Created by Nanosoft-Android on 12/4/2017.
 */

public class UserLoginData_Info {

    private String name;
    private String type;
    private String email;


    public UserLoginData_Info(String name, String type, String email) {
        this.name = name;
        this.type = type;
        this.email = email;
    }

    public UserLoginData_Info() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
