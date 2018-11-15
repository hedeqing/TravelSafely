package com.example.a24048.travelsafely.driver;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.a24048.travelsafely.R;

public class DriverSendActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_send);
//        CharSequence titleLable = "车主";
//        setTitle(titleLable);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)     {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }

    }
}
