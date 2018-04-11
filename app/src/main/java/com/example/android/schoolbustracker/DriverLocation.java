package com.example.android.schoolbustracker;

import android.*;
import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ishikasaini on 07/04/18.
 */

public class DriverLocation extends AppCompatActivity {
    Button dLogout, bt;
    TextView latTextView;
    TextView longTextView;
    private LocationManager locationManager;
    private LocationListener locationListener;
    FirebaseDatabase database;
    DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.driver_location);

        dLogout = (Button) findViewById(R.id.logoutD);
        bt = (Button) findViewById(R.id.getLocation);

        Log.i("Location","In 1") ;

        //logout intent to go back to driver login page
        dLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                locationManager.removeUpdates(locationListener);
                locationManager = null;
                Intent intent = new Intent(DriverLocation.this, DriverLogin.class);
                startActivity(intent);
                finish();
            }
        });

        latTextView = (TextView) findViewById(R.id.latitude);
        longTextView = (TextView) findViewById(R.id.longitude);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        //this code won't execute if the permissions are not granted
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Location","In 7") ;

                if (ActivityCompat.checkSelfPermission(DriverLocation.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(DriverLocation.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }

                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
                        0, 0, locationListener);

            }
        });

        locationListener = new LocationListener() {

            @Override
            public void onLocationChanged(Location location) {

                Log.i("Location","In 2") ;
                latTextView.setText(location.getLatitude() + "");
                longTextView.setText(location.getLongitude() + "");

                Lat_Long pos = new Lat_Long(location.getLatitude(), location.getLongitude());
                myRef.child("Location").setValue(pos);

                Toast toast = Toast.makeText(getApplicationContext(), "Location sent.", Toast.LENGTH_SHORT);
                toast.show();
                return;


            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {
                Log.i("Location","In 3") ;


            }

            @Override
            public void onProviderEnabled(String s) {
                Log.i("Location","In 4") ;


            }

            @Override
            public void onProviderDisabled(String s) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        };

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Log.i("Location","In 6") ;
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.INTERNET}, 10);
            }
            return;
        } else {
            Log.i("Location","In 5") ;

        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Log.i("Location","In 7") ;
        switch (requestCode) {
            case 10:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    return;
        }
    }




}
