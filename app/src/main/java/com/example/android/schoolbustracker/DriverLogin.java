package com.example.android.schoolbustracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by ishikasaini on 12/02/18.
 */

public class DriverLogin extends AppCompatActivity {
    EditText driverUsername;
    EditText driverPassword;

    Button dLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.driver_login);


        driverUsername = (EditText) findViewById(R.id.driver_username);
        driverPassword = (EditText) findViewById(R.id.driver_password);
        dLogin = (Button) findViewById(R.id.buttonD);
        //dU = driverUsername.getText().toString();
        //dP = driverPassword.getText().toString();


            dLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (driverUsername.getText().toString().equals("driver") && driverPassword.getText().toString().equals("1234")) {
                        Intent intent = new Intent(DriverLogin.this, DriverLocation.class);
                        startActivity(intent);
                        finish();
                    }
                    else {
                        Toast toast = Toast.makeText(getApplicationContext(), "Incorrect email or password.", Toast.LENGTH_SHORT);
                        toast.show();
                        driverUsername.getText().clear();
                        driverPassword.getText().clear();

                    }

                }
            });
        }
}