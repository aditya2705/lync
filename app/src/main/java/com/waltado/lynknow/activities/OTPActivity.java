package com.waltado.lynknow.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;

import com.waltado.lynknow.R;
import com.waltado.lynknow.customViews.LatoFontLightTextView;

public class OTPActivity extends AppCompatActivity {

    private AppCompatSpinner countryCodeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        ((LatoFontLightTextView)findViewById(R.id.doneView)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OTPActivity.this, UserInfoActivity.class);
                startActivity(intent);
            }
        });


    }
}
