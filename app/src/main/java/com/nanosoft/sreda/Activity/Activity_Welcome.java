package com.nanosoft.sreda.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.nanosoft.sreda.R;
import com.nanosoft.sreda.Utility.AppController;
import com.nanosoft.sreda.Utility.Operation;


public class Activity_Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        checkWelcomePage();


    }

    private void checkWelcomePage() {
        String persistenceUsernameString = Operation.getString("email", "");
        if (persistenceUsernameString.length() > 0) {
            startActivity(new Intent(AppController.getAppContext(), Activity_Main.class));
            finish();
        } else {
            setContentView(R.layout.welcome);
        }
    }

    public void startSignInActivity(View view) {
        startActivity(new Intent(Activity_Welcome.this, Activity_Login.class));
        finish();
    }
}
