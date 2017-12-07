package com.nanosoft.sreda.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.nanosoft.sreda.R;
import com.nanosoft.sreda.Receiver.NetworkConnectionReceiver;
import com.nanosoft.sreda.Utility.AppController;
import com.nanosoft.sreda.Utility.Operation;
import com.nanosoft.sreda.Utility.ServerResponseOperation;


public class Activity_Login extends AppCompatActivity implements NetworkConnectionReceiver.ConnectivityRecieverListener {




    Boolean isConnected;
    LinearLayout myLinearLayout;
    public static final String NA = "NA";
    EditText usernameEditText,passwordEditText;

    public  static Activity_Login activityLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLogin = this;
        String persistenceUsernameString=Operation.getString("email","");
        if(persistenceUsernameString.length()>0){
            startActivity(new Intent(AppController.getAppContext(),Activity_Main.class));
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
