package com.nanosoft.sreda.Model;

/**
 * Created by Nanosoft-Android on 12/4/2017.
 */

public class Info_UserLoginResponse {

    /*"status": 2000,
    "message": "Successfully Logged In",
    "data": {
        "name": "Administrator",
        "type": "1",
        "email": "admin@mail.com"
    }*/

    private String status;
    private String message;
    private Info_UserLoginData data;

    public Info_UserLoginResponse(String status, String message, Info_UserLoginData data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Info_UserLoginData getData() {
        return data;
    }

    public void setData(Info_UserLoginData data) {
        this.data = data;
    }

    //    public void setUserLoginData_Info(Info_UserLoginData data) {
//        this.data = data;
//
//    }
//
//    public Info_UserLoginData getUserLoginData_Info() {
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
