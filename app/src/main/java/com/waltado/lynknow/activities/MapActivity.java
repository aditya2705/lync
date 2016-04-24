package com.waltado.lynknow.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSeekBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.SeekBar;
import android.widget.TextView;

import com.flipboard.bottomsheet.BottomSheetLayout;
import com.waltado.lynknow.R;

public class MapActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private View bottomSheetView;
    private BottomSheetLayout bottomSheetLayout;
    private FloatingActionButton floatingActionButton;
    private AppCompatSeekBar bottomSheetSeekBar;
    private TextView seekBarPopupTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        floatingActionButton = (FloatingActionButton)findViewById(R.id.bottom_sheet_fab);

        bottomSheetLayout = (BottomSheetLayout) findViewById(R.id.bottomsheet);
        bottomSheetView = LayoutInflater.from(this).inflate(R.layout.custom_bottom_sheet_map, bottomSheetLayout, false);
        bottomSheetView.findViewById(R.id.activity_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapActivity.this, ActivitySelectActivity.class);
                startActivity(intent);
            }
        });
        bottomSheetView.findViewById(R.id.status_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapActivity.this, StatusUpdateActivity.class);
                startActivity(intent);
            }
        });
        bottomSheetView.findViewById(R.id.group_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        bottomSheetView.findViewById(R.id.cross_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetLayout.dismissSheet();
            }
        });

        bottomSheetSeekBar = (AppCompatSeekBar) bottomSheetView.findViewById(R.id.seekBar);
        seekBarPopupTextView = (TextView)bottomSheetView.findViewById(R.id.seekBar_text);
        bottomSheetSeekBar.setMax(100);
        bottomSheetSeekBar.setProgress(0);
        bottomSheetSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarPopupTextView.setText(String.valueOf(progress));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetLayout.showWithSheetView(bottomSheetView);
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
