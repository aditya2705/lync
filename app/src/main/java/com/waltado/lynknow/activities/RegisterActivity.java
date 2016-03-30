package com.waltado.lynknow.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.waltado.lynknow.R;
import com.waltado.lynknow.customViews.LatoFontTextView;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ((LatoFontTextView)findViewById(R.id.proceedView)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, SelectActivity.class);
                startActivity(intent);
            }
        });
    }
}
