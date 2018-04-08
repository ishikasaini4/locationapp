package com.example.android.schoolbustracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by ishikasaini on 12/02/18.
 */

public class ParentLogin extends AppCompatActivity {

    Button Plogin;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent_login);
        Plogin = (Button) findViewById(R.id.buttonP);
        Plogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ParentLogin.this,MapsActivity.class);
                startActivity(intent);

            }
        });
    }

    }
