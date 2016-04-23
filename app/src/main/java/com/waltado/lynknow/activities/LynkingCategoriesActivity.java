package com.waltado.lynknow.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.github.aakira.expandablelayout.Utils;
import com.waltado.lynknow.R;

import java.util.ArrayList;

public class LynkingCategoriesActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    int screenWidth;
    int screenHeight;
    private View includeView;
    private ImageView arrowView;
    private LinearLayout expandingListenerLayout;
    private ArrayList<ExpandableRelativeLayout> expandableLayoutArrayList;
    private ArrayList<View> viewArrayList;
    private ArrayList<ImageView> arrowArrayList;
    private ExpandableRelativeLayout mExpandLayout;
    private RotateAnimation anim1, anim2;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lynking_categories);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        setupExpandableLayouts();

        findViewById(R.id.forward_fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LynkingCategoriesActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });



    }

    private void setupExpandableLayouts() {

        expandableLayoutArrayList = new ArrayList<>();
        viewArrayList = new ArrayList<>();
        arrowArrayList = new ArrayList<>();
        anim1 = new RotateAnimation(0f, 350f, 15f, 15f);
        anim1.setInterpolator(new LinearInterpolator());
        anim1.setDuration(100);
        anim2 = new RotateAnimation(0f, 0f, 0f, 0f);
        anim2.setInterpolator(new LinearInterpolator());
        anim2.setDuration(100);
        includeView = findViewById(R.id.arts);
        mExpandLayout = (ExpandableRelativeLayout) includeView.findViewById(R.id.expandableLayout);
        mExpandLayout.setInterpolator(Utils.createInterpolator(Utils.LINEAR_OUT_SLOW_IN_INTERPOLATOR));
        mExpandLayout.setDuration(1000);
        arrowView = (ImageView) includeView.findViewById(R.id.arrow);
        arrowArrayList.add(arrowView);
        expandableLayoutArrayList.add(mExpandLayout);
        expandingListenerLayout = (LinearLayout) includeView.findViewById(R.id.expand_listener_layout);
        viewArrayList.add(expandingListenerLayout);
        expandingListenerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewArrayList.indexOf(v);
                Log.d("CLICKED", "" + position);
                if (expandableLayoutArrayList.get(position).isExpanded()) {
                    arrowArrayList.get(position).setBackgroundResource(R.drawable.ic_arrow_down_grey);
                } else {
                    arrowArrayList.get(position).setBackgroundResource(R.drawable.ic_arrow_down_grey);
                }

                expandableLayoutArrayList.get(viewArrayList.indexOf(v)).toggle();
            }
        });
        textView = (TextView) includeView.findViewById(R.id.title_text);
        textView.setText("Arts");

        includeView = findViewById(R.id.fitness);
        mExpandLayout = (ExpandableRelativeLayout) includeView.findViewById(R.id.expandableLayout);
        mExpandLayout.setInterpolator(Utils.createInterpolator(Utils.LINEAR_OUT_SLOW_IN_INTERPOLATOR));
        mExpandLayout.setDuration(1000);
        arrowView = (ImageView) includeView.findViewById(R.id.arrow);
        arrowArrayList.add(arrowView);
        expandableLayoutArrayList.add(mExpandLayout);
        expandingListenerLayout = (LinearLayout) includeView.findViewById(R.id.expand_listener_layout);
        viewArrayList.add(expandingListenerLayout);
        expandingListenerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewArrayList.indexOf(v);
                Log.d("CLICKED", "" + position);
                if (expandableLayoutArrayList.get(position).isExpanded()) {
                    arrowArrayList.get(position).setBackgroundResource(R.drawable.ic_arrow_down_grey);
                } else {
                    arrowArrayList.get(position).setBackgroundResource(R.drawable.ic_arrow_down_grey);
                }

                expandableLayoutArrayList.get(viewArrayList.indexOf(v)).toggle();
            }
        });
        textView = (TextView) includeView.findViewById(R.id.title_text);
        textView.setText("Fitness & Well Being");

        includeView = findViewById(R.id.technology);
        mExpandLayout = (ExpandableRelativeLayout) includeView.findViewById(R.id.expandableLayout);
        mExpandLayout.setInterpolator(Utils.createInterpolator(Utils.LINEAR_OUT_SLOW_IN_INTERPOLATOR));
        mExpandLayout.setDuration(1000);
        arrowView = (ImageView) includeView.findViewById(R.id.arrow);
        arrowArrayList.add(arrowView);
        expandableLayoutArrayList.add(mExpandLayout);
        expandingListenerLayout = (LinearLayout) includeView.findViewById(R.id.expand_listener_layout);
        viewArrayList.add(expandingListenerLayout);
        expandingListenerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewArrayList.indexOf(v);
                Log.d("CLICKED", "" + position);
                if (expandableLayoutArrayList.get(position).isExpanded()) {
                    arrowArrayList.get(position).setBackgroundResource(R.drawable.ic_arrow_down_grey);
                } else {
                    arrowArrayList.get(position).setBackgroundResource(R.drawable.ic_arrow_down_grey);
                }

                expandableLayoutArrayList.get(viewArrayList.indexOf(v)).toggle();
            }
        });
        textView = (TextView) includeView.findViewById(R.id.title_text);
        textView.setText("Technology");


        includeView = findViewById(R.id.sports);
        mExpandLayout = (ExpandableRelativeLayout) includeView.findViewById(R.id.expandableLayout);
        mExpandLayout.setInterpolator(Utils.createInterpolator(Utils.LINEAR_OUT_SLOW_IN_INTERPOLATOR));
        mExpandLayout.setDuration(1000);
        arrowView = (ImageView) includeView.findViewById(R.id.arrow);
        arrowArrayList.add(arrowView);
        expandableLayoutArrayList.add(mExpandLayout);
        expandingListenerLayout = (LinearLayout) includeView.findViewById(R.id.expand_listener_layout);
        viewArrayList.add(expandingListenerLayout);
        expandingListenerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewArrayList.indexOf(v);
                Log.d("CLICKED", "" + position);
                if (expandableLayoutArrayList.get(position).isExpanded()) {
                    arrowArrayList.get(position).setBackgroundResource(R.drawable.ic_arrow_down_grey);
                } else {
                    arrowArrayList.get(position).setBackgroundResource(R.drawable.ic_arrow_down_grey);
                }

                expandableLayoutArrayList.get(viewArrayList.indexOf(v)).toggle();
            }
        });
        textView = (TextView) includeView.findViewById(R.id.title_text);
        textView.setText("Sports");


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
