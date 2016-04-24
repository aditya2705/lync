package com.waltado.lynknow.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import com.waltado.lynknow.R;
import com.waltado.lynknow.customViews.LatoFontEditText;

public class UserInfoActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private LatoFontEditText yourselfEditText;
    private TextView yourselfCharacterCount;
    private AutoCompleteTextView homeTownView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        yourselfCharacterCount = (TextView)findViewById(R.id.yourself_character_count);

        yourselfEditText = (LatoFontEditText)findViewById(R.id.edittext_yourself);
        yourselfEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                yourselfCharacterCount.setText(s.length()+"/140");
            }
        });

        homeTownView = (AutoCompleteTextView)findViewById(R.id.homeTownView);

        ArrayAdapter<String> adp=new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,new String[]{"Mumbai","New Delhi","Nasik","Kolkata","Chennai","Bangalore","Calangute"});

        homeTownView.setThreshold(1);
        homeTownView.setAdapter(adp);

        findViewById(R.id.forward_fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserInfoActivity.this, LynkingCategoriesActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
