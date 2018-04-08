package com.example.android.schoolbustracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ishikasaini on 07/04/18.
 */

public  class Lat_Long {
    double Latitude;
    double Longitude;

     void getCoordinates(double x, double y){
        Latitude = x;
        Longitude = y;
    }
}
