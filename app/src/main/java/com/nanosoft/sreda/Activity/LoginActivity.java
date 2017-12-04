package com.nanosoft.sreda.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.nanosoft.sreda.Model.Employee;
import com.nanosoft.sreda.R;
import com.nanosoft.sreda.Receiver.NetworkConnectionReceiver;
import com.nanosoft.sreda.Utility.AppController;
import com.nanosoft.sreda.Utility.CustomAdapter;
import com.nanosoft.sreda.Utility.Operation;
import com.nanosoft.sreda.Utility.ServerResponseOperation;

import java.util.List;


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

    public  static LoginActivity loginActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loginActivity = this;
        String persistanceUsernameString=Operation.getString("email","");
        if(persistanceUsernameString.length()>0){
            startActivity(new Intent(AppController.getAppContext(),MainActivity.class));
            finish();
        }else{

            setContentView(R.layout.login);
        }
        myLinearLayout=(LinearLayout)findViewById(R.id.activity_main);
        usernameEditText=(EditText) findViewById(R.id.usernameET);
        passwordEditText=(EditText) findViewById(R.id.passwordET);

    }

    public void goSignIn(View view) {


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
                ServerResponseOperation serverResponseOperation=new ServerResponseOperation(getApplicationContext());
                serverResponseOperation.loginWithServer(emailString,passwordString);
            }

        } else {
            showSnackBar();
        }

    }

    private void showSnackBar() {

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


}
