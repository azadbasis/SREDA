package com.nanosoft.sreda.Utility;

import android.content.Context;
import android.content.SharedPreferences;

import com.nanosoft.sreda.Model.CapacityData_Info;
import com.nanosoft.sreda.Model.CapacityReport_Info;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nanosoft-Android on 11/20/2017.
 */

public class Operation {


    public static List<CapacityData_Info> listCapacityData = new ArrayList<>();

    public static void saveString(String keyValue, String getValue){

        SharedPreferences sharedPreferences =AppController.getAppContext().getSharedPreferences("SREDA",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(keyValue,getValue);
        editor.apply();

    }

    public static String getString(String keyValue,String defaultValue){

        SharedPreferences sharedPreferences =AppController.getAppContext().getSharedPreferences("SREDA",Context.MODE_PRIVATE);
        return sharedPreferences.getString(keyValue,defaultValue);
    }
}
