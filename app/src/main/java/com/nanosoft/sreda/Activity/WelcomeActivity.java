package com.nanosoft.sreda.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.nanosoft.sreda.R;
import com.nanosoft.sreda.Utility.AppController;
import com.nanosoft.sreda.Utility.Operation;


public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String persistanceUsernameString= Operation.getString("email","");
        if(persistanceUsernameString.length()>0){
            startActivity(new Intent(AppController.getAppContext(),MainActivity.class));
            finish();
        }else {
            setContentView(R.layout.welcome);
        }
    }

    public void startSignInActivity(View view) {
        startActivity(new Intent(WelcomeActivity.this,LoginActivity.class));
        finish();
    }
}
