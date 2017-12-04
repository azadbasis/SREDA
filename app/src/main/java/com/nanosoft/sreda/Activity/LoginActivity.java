package com.nanosoft.sreda.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.nanosoft.sreda.Model.Employee;
import com.nanosoft.sreda.Model.UserLoginResponse_Info;
import com.nanosoft.sreda.R;
import com.nanosoft.sreda.Receiver.NetworkConnectionReceiver;
import com.nanosoft.sreda.Utility.Api;
import com.nanosoft.sreda.Utility.AppController;
import com.nanosoft.sreda.Utility.CustomAdapter;
import com.nanosoft.sreda.Utility.Operation;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LoginActivity extends AppCompatActivity implements NetworkConnectionReceiver.ConnectivityRecieverListener {


    List<Employee> employeeList;
    RecyclerView recyclerView;
    Boolean isConnected;
    LinearLayout myLinearLayout;
    public static final String NA = "NA";
    CustomAdapter customAdapter;

    final static String SHARED_NAME_STRING="sharedp";
    final static String USER_NAME_STRING="user";
    Button button;
    EditText usernameEditText,passwordEditText;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String persistanceUsernameString=Operation.getString("user","");
        if(persistanceUsernameString.length()>0){
            startActivity(new Intent(AppController.getAppContext(),MainActivity.class));
            finish();
        }else{

            setContentView(R.layout.login);
        }
        myLinearLayout=(LinearLayout)findViewById(R.id.activity_main);

        usernameEditText=(EditText) findViewById(R.id.usernameET);
        passwordEditText=(EditText) findViewById(R.id.passwordET);
       // button=(Button) findViewById(R.id.enterButton);

        Log.d("DICTIONARY", "main activity started");


//        sharedPreferences=getSharedPreferences(SHARED_NAME_STRING, MODE_PRIVATE);
//        String userNameString=sharedPreferences.getString(USER_NAME_STRING, "");
//
//        usernameEditText.setText(userNameString);

    }

    public void goSignIn(View view) {

       // loginWithServer("admin@mail.com","123456");

        if (checkConnectivity()) {

            String emailString=usernameEditText.getText().toString();
            String passwordString=passwordEditText.getText().toString();
            if(emailString.length()==0){
                usernameEditText.setError("Insert Username");
            }
            if(passwordString.length()==0){
                passwordEditText.setError("Insert Password");
            }
            if(emailString.length()>0&&passwordString.length()>0){

                loginWithServer(emailString,passwordString);
            }

        } else {
            showSnackBar();
        }

    }

    private void showSnackBar() {
        //into threa

        Snackbar.make(myLinearLayout, getString(R.string.no_internet), Snackbar.LENGTH_LONG)
                .setAction(getString(R.string.btn_settings), new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(Settings.ACTION_WIRELESS_SETTINGS));
                    }
                }).setActionTextColor(Color.RED).show();
    }

    private boolean checkConnectivity() {
        return NetworkConnectionReceiver.isConnected();
    }

    @Override
    public void OnNetworkChange(boolean inConnected) {
        this.isConnected = inConnected;
    }

    private void loginWithServer(String email, final String password) {


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

                Toast.makeText(LoginActivity.this, ""+responseInfo.getStatus(), Toast.LENGTH_SHORT).show();
                String name=responseInfo.getData().getName();
                String email=responseInfo.getData().getEmail();
                String type=responseInfo.getData().getType();
                Toast.makeText(LoginActivity.this, "name"+name, Toast.LENGTH_SHORT).show();
//                String name = responseInfo.getData().getName();
//                String passworduser = password;

            }

            @Override
            public void onFailure(Call<UserLoginResponse_Info> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

               // busyNow.dismis();
            }
        });
    }
}
