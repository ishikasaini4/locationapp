package com.example.android.schoolbustracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by ishikasaini on 10/02/18.
 */

public class SelectLogin extends AppCompatActivity {

    Button Parent,Driver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_login);

         Parent = (Button) findViewById(R.id.parent);
         Parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectLogin.this,ParentLogin.class);
                startActivity(intent);
            }
        });

         Driver = (Button) findViewById(R.id.driver);
         Driver.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(SelectLogin.this,DriverLogin.class);
                 startActivity(intent);
             }
         });
    }
}
