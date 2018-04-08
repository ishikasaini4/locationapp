package com.example.android.schoolbustracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by ishikasaini on 12/02/18.
 */

public class DriverLogin extends AppCompatActivity {
    Button dLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.driver_login);

        dLogin = (Button) findViewById(R.id.buttonD);
        dLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DriverLogin.this,DriverLocation.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
