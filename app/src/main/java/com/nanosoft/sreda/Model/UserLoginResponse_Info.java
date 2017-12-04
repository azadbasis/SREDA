package com.nanosoft.sreda.Model;

/**
 * Created by Nanosoft-Android on 12/4/2017.
 */

public class UserLoginResponse_Info {

    /*"status": 2000,
    "message": "Successfully Logged In",
    "data": {
        "name": "Administrator",
        "type": "1",
        "email": "admin@mail.com"
    }*/

    private String status;
    private String message;
    private UserLoginData_Info data;

    public UserLoginResponse_Info(String status, String message, UserLoginData_Info data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public UserLoginData_Info getData() {
        return data;
    }

    public void setData(UserLoginData_Info data) {
        this.data = data;
    }

    //    public void setUserLoginData_Info(UserLoginData_Info data) {
//        this.data = data;
//
//    }
//
//    public UserLoginData_Info getUserLoginData_Info() {
//        return data;
//    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
