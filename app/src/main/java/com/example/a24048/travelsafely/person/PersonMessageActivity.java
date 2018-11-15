package com.example.a24048.travelsafely.person;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.a24048.travelsafely.MainActivity;
import com.example.a24048.travelsafely.R;
import com.leon.lib.settingview.LSettingItem;

public class PersonMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_message);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)     {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }

        LSettingItem one =findViewById(R.id.item_one);
        one.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                Toast.makeText(PersonMessageActivity.this,"点击了钱包",Toast.LENGTH_SHORT).show();
            }
        });
    }


}
