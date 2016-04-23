package com.waltado.lynknow.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.waltado.lynknow.R;
import com.waltado.lynknow.fragments.ProfileAboutFragment;

public class ProfileActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private ViewPager profilePager;
    private ProfileTabAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_collapsing);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        profilePager = (ViewPager) findViewById(R.id.viewpager);
        profilePager.setOffscreenPageLimit(20);

        SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.profile_tabs);

        adapter = new ProfileTabAdapter(getSupportFragmentManager());
        profilePager.setAdapter(adapter);

        viewPagerTab.setViewPager(profilePager);

        findViewById(R.id.forward_fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
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

    public class ProfileTabAdapter extends FragmentPagerAdapter {
        private final String[] tab_names = {"About", "Photos", "Groups", "Events"};

        private ProfileTabAdapter(FragmentManager fm) {
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
                    return new ProfileAboutFragment();
            }
        }
    }


}
