package com.waltado.lynknow.activities;

import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.flipboard.bottomsheet.BottomSheetLayout;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.waltado.lynknow.R;
import com.waltado.lynknow.fragments.BlankFragment;
import com.waltado.lynknow.fragments.ContactListFragment;
import com.waltado.lynknow.fragments.LKMListFragment;

public class MainActivity extends AppCompatActivity implements SmartTabLayout.TabProvider{

    private Toolbar mToolbar;
    private ViewPager mainPager;
    private MainTabAdapter adapter;
    private View bottomSheetView;
    private BottomSheetLayout bottomSheetLayout;
    private FloatingActionButton floatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingActionButton = (FloatingActionButton)findViewById(R.id.bottom_sheet_fab);

        bottomSheetLayout = (BottomSheetLayout) findViewById(R.id.bottomsheet);
        bottomSheetView = LayoutInflater.from(this).inflate(R.layout.custom_bottom_sheet, bottomSheetLayout, false);
        bottomSheetView.findViewById(R.id.activity_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SelectActivity.class);
                startActivity(intent);
            }
        });
        bottomSheetView.findViewById(R.id.status_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StatusUpdateActivity.class);
                startActivity(intent);
            }
        });
        bottomSheetView.findViewById(R.id.map_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SelectActivity.class);
                startActivity(intent);
            }
        });

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mainPager = (ViewPager) findViewById(R.id.viewpager);
        mainPager.setOffscreenPageLimit(20);

        SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.main_tabs);

        adapter = new MainTabAdapter(getSupportFragmentManager());
        mainPager.setAdapter(adapter);

        viewPagerTab.setCustomTabView(this);
        viewPagerTab.setViewPager(mainPager);

        mainPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                switch (position) {
                    case 0:
                        floatingActionButton.setImageResource(R.drawable.ic_plus);
                        floatingActionButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                bottomSheetLayout.showWithSheetView(bottomSheetView);
                            }
                        });
                        break;
                    case 1:
                        floatingActionButton.setImageResource(R.drawable.ic_person_white);
                        floatingActionButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                bottomSheetLayout.showWithSheetView(bottomSheetView);
                            }
                        });
                        break;
                    case 2:
                        floatingActionButton.setImageResource(R.drawable.ic_chat_white);
                        floatingActionButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                bottomSheetLayout.showWithSheetView(bottomSheetView);
                            }
                        });
                        break;
                    case 3:
                        floatingActionButton.setImageResource(R.drawable.ic_group_white);
                        floatingActionButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                bottomSheetLayout.showWithSheetView(bottomSheetView);
                            }
                        });
                        break;
                    case 4:
                        floatingActionButton.setImageResource(R.drawable.ic_calendar_white);
                        floatingActionButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                bottomSheetLayout.showWithSheetView(bottomSheetView);
                            }
                        });
                        break;
                }


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mainPager.setCurrentItem(2);


    }

    @Override
    public View createTabView(ViewGroup container, int position, PagerAdapter adapter) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        Resources res = container.getContext().getResources();
        View tab = inflater.inflate(R.layout.custom_tab_icon_mark, container, false);
        ImageView icon = (ImageView) tab.findViewById(R.id.custom_tab_icon);
        switch (position) {
            case 0:
                icon.setImageDrawable(res.getDrawable(R.drawable.ic_home_white));
                break;
            case 1:
                icon.setImageDrawable(res.getDrawable(R.drawable.ic_person_white));
                break;
            case 2:
                icon.setImageDrawable(res.getDrawable(R.drawable.ic_chat_white));
                break;
            case 3:
                icon.setImageDrawable(res.getDrawable(R.drawable.ic_group_white));
                break;
            case 4:
                icon.setImageDrawable(res.getDrawable(R.drawable.ic_calendar_white));
                break;
            default:
                throw new IllegalStateException("Invalid position: " + position);
        }
        return tab;
    }

    public class MainTabAdapter extends FragmentPagerAdapter {
        private final String[] tab_names = {"1", "2", "3", "4", "5"};

        private MainTabAdapter(FragmentManager fm) {
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
                case 0:
                    return new LKMListFragment();
                case 1:
                    return new BlankFragment();
                case 2:
                    return new ContactListFragment();
                case 3:
                    return new BlankFragment();
                case 4:
                    return new BlankFragment();
                default:
                    return new BlankFragment();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(R.id.myswitch);
        item.setActionView(R.layout.menu_switch_layout);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Intent intent;
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_register) {
            this.finish();
            return true;
        }else if(id == R.id.menu_1){
            return true;
        }else if(id == R.id.menu_2){
            intent = new Intent(MainActivity.this,StatusUpdateActivity.class);
            startActivity(intent);
            return true;
        }else if(id == R.id.menu_3){
            intent = new Intent(MainActivity.this,SelectActivity.class);
            startActivity(intent);
            return true;
        }else if(id == R.id.menu_4){
            intent = new Intent(MainActivity.this,LynkingCategoriesActivity.class);
            startActivity(intent);
            return true;
        }else if(id == R.id.menu_5){
            intent = new Intent(MainActivity.this,ProfileActivity.class);
            startActivity(intent);
            return true;
        }else if(id == R.id.menu_6){
            intent = new Intent(MainActivity.this,UserInfoActivity.class);
            startActivity(intent);
            return true;
        }else if(id == R.id.search){
            SearchView mSearchView = (SearchView) MenuItemCompat.getActionView(item);
            mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }
            });

            mSearchView.setQueryHint("Search");
            SearchView.SearchAutoComplete searchAutoComplete = (SearchView.SearchAutoComplete) mSearchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
            searchAutoComplete.setHintTextColor(getResources().getColor(R.color.md_white_400));
            searchAutoComplete.setTextColor(getResources().getColor(R.color.md_white_1000));

        }

        return super.onOptionsItemSelected(item);
    }

}
