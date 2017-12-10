package com.nanosoft.sreda.Utility;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.nanosoft.sreda.Activity.Activity_Login;
import com.nanosoft.sreda.Activity.Activity_Main;
import com.nanosoft.sreda.Model.Info_CapacityData;
import com.nanosoft.sreda.Model.Info_CapacityResponse;
import com.nanosoft.sreda.Model.Info_UserLoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Nanosoft-Android on 12/4/2017.
 */

public class ServerResponseOperation {
    Context context;

    public ServerResponseOperation(Context context) {
        this.context = context;
    }

    public void loginWithServer(String email, final String password) {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);
        Call<Info_UserLoginResponse> call = api.getLoginUser(email,password);

        call.enqueue(new Callback<Info_UserLoginResponse>() {
            @Override
            public void onResponse(Call<Info_UserLoginResponse> call, Response<Info_UserLoginResponse> response) {


                Info_UserLoginResponse responseInfo = response.body();

                if(responseInfo.getStatus()==2000){
                    String name=responseInfo.getData().getName();
                    String email=responseInfo.getData().getEmail();
                    String type=responseInfo.getData().getType();

                    Intent intent=new Intent(context, Activity_Main.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("user", email);
                    Operation.saveString("email",email);
                    Operation.saveString("password",password);
                    Operation.saveString("type",type);
                    Operation.saveString("name",name);
                    context.startActivity(intent);
                    Activity_Login.activityLogin.finish();
                   // Toast.makeText(context, "name"+name, Toast.LENGTH_SHORT).show();
                    Toast.makeText(context, responseInfo.getMessage(), Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(context, responseInfo.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Info_UserLoginResponse> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();

                // busyNow.dismis();
            }
        });
    }


    public void getCapacityDataFormServer(String email, final String password) {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);
        Call<Info_CapacityResponse> call = api.getCapacity(email,password);

        call.enqueue(new Callback<Info_CapacityResponse>() {
            @Override
            public void onResponse(Call<Info_CapacityResponse> call, Response<Info_CapacityResponse> response) {
                Info_CapacityResponse responseInfo = response.body();



                if(responseInfo.getStatus()==2000){
                   // Operation.listCapacityData = responseInfo.getData();

                    for(Info_CapacityData temp:responseInfo.getData()){
                        Operation.listCapacityData.add(temp);
                    }
                }



////                String name=responseInfo.getData().getName();
////                String email=responseInfo.getData().getEmail();
////                String type=responseInfo.getData().getType();
//
//                Intent intent=new Intent(context, Activity_Main.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                intent.putExtra("user", email);
//                Operation.saveString("email",email);
//                Operation.saveString("password",password);
//                Operation.saveString("type",type);
//                Operation.saveString("name",name);
//                context.startActivity(intent);
//                Activity_Login.activityLogin.finish();
                Toast.makeText(context, ""+responseInfo.getData().size(), Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onFailure(Call<Info_CapacityResponse> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();

                // busyNow.dismis();
            }
        });
    }

}
