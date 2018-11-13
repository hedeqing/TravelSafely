package com.example.a24048.travelsafely.driver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.a24048.travelsafely.R;

public class DriverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);
        CharSequence titleLable = "车主";
        setTitle(titleLable);
    }
}
