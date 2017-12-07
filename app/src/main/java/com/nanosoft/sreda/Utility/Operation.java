package com.nanosoft.sreda.Utility;

import android.content.Context;
import android.content.SharedPreferences;

import com.nanosoft.sreda.Model.Info_CapacityData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nanosoft-Android on 11/20/2017.
 */

public class Operation {


    public static List<Info_CapacityData> listCapacityData = new ArrayList<>();

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
