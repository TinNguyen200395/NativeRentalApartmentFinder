package com.example.nativerentalapartmentfinder;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return  true;
    }
}