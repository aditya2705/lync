package com.waltado.lynknow.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.waltado.lynknow.R;
import com.waltado.lynknow.fragments.MoodImageFragment;
import com.waltado.lynknow.fragments.ProfileAboutFragment;

public class StatusUpdateActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private ViewPager moodPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_update);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        moodPager = (ViewPager)findViewById(R.id.mood_viewpager);
        moodPager.setOffscreenPageLimit(20);
        moodPager.setAdapter(new MoodPagerAdapter(getSupportFragmentManager()));

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

    public class MoodPagerAdapter extends FragmentPagerAdapter {
        private final String[] tab_names = {"1", "2", "3", "4"};

        private MoodPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tab_names[position];
        }

        @Override
        public int getCount() {
            return tab_names.length;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                default:
                    return new MoodImageFragment();
            }
        }
    }
}
