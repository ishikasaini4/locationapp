package com.example.android.schoolbustracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnext,h;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnext = (Button) findViewById(R.id.next);
        h = (Button) findViewById(R.id.aboutApp);


        btnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SelectLogin.class);
                startActivity(intent);

            }
        });

        h.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent( MainActivity.this,Help.class);
                        startActivity(intent);
                    }
                });


    }
}
