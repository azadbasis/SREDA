package com.nanosoft.sreda.Utility;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.nanosoft.sreda.Activity.LoginActivity;
import com.nanosoft.sreda.Activity.MainActivity;
import com.nanosoft.sreda.Model.UserLoginResponse_Info;

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
        Call<UserLoginResponse_Info> call = api.getLoginUser(email,password);

        call.enqueue(new Callback<UserLoginResponse_Info>() {
            @Override
            public void onResponse(Call<UserLoginResponse_Info> call, Response<UserLoginResponse_Info> response) {
                UserLoginResponse_Info responseInfo = response.body();
                String name=responseInfo.getData().getName();
                String email=responseInfo.getData().getEmail();
                String type=responseInfo.getData().getType();

                Intent intent=new Intent(context, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("user", email);
                Operation.saveString("email",email);
                Operation.saveString("password",password);
                Operation.saveString("type",type);
                Operation.saveString("name",name);
                context.startActivity(intent);
                LoginActivity.loginActivity.finish();
                Toast.makeText(context, "name"+name, Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onFailure(Call<UserLoginResponse_Info> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();

                // busyNow.dismis();
            }
        });
    }
}
