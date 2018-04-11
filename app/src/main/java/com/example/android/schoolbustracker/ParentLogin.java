package com.example.android.schoolbustracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by ishikasaini on 12/02/18.
 */

public class ParentLogin extends AppCompatActivity {
    EditText parentUsername;
    EditText parentPassword;


    Button Plogin;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent_login);
        Plogin = (Button) findViewById(R.id.buttonP);
        parentUsername = (EditText) findViewById(R.id.parent_username);
        parentPassword = (EditText) findViewById(R.id.parent_password);

        Plogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (parentUsername.getText().toString().equals("parent") && parentPassword.getText().toString().equals("1234")) {
                    Intent intent = new Intent(ParentLogin.this, MapsActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Incorrect email or password.", Toast.LENGTH_SHORT);
                    toast.show();
                    parentUsername.getText().clear();
                    parentPassword.getText().clear();
                }

            }
        });
    }

    }
