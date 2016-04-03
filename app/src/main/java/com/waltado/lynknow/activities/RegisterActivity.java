package com.waltado.lynknow.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.ArrayAdapter;

import com.waltado.lynknow.R;
import com.waltado.lynknow.customViews.LatoFontLightTextView;

public class RegisterActivity extends AppCompatActivity {

    private AppCompatSpinner countryCodeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ((LatoFontLightTextView)findViewById(R.id.proceedView)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, OTPActivity.class);
                startActivity(intent);
            }
        });


        countryCodeSpinner = (AppCompatSpinner)findViewById(R.id.country_code_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.country_codes, R.layout.register_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        countryCodeSpinner.setAdapter(adapter);


    }
}
