package com.example.safety;

import android.content.Intent;
import android.location.LocationManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationSettingsRequest;

public class MainActivity2 extends AppCompatActivity {

    Button b1, b2;
    private FusedLocationProviderClient client;
    DatabaseHandler myDB;
    private final int REQUEST_CHECK_CODE = 8989;
    private LocationSettingsRequest.Builder builder;
    String x= "", y="";
    private static final int REQUEST_LOCATION = 1;

    LocationManager locationManager;
    Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b1 = findViewById( R.id.button );
        b2 = findViewById( R.id.button2 );
        myDB = new DatabaseHandler(this );
        final MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.emergency_alarm );

        locationManager = ( LocationManager.isProviderEnabled( LOCATION_SERVICE));
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            onGPS();
        }
        else{
            startTrack();
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent i = new Intent ( getApplicationContext(),Register.class);
                 startActivity( i );
            }
        });
    }

    private void startTrack() {
    }

    private void onGPS() {
    }
}