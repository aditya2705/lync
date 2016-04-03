package com.waltado.lynknow.activities;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSeekBar;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.flipboard.bottomsheet.BottomSheetLayout;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.waltado.lynknow.R;
import com.waltado.lynknow.fragments.BlankFragment;
import com.waltado.lynknow.fragments.ChatListFragment;
import com.waltado.lynknow.fragments.ContactListFragment;
import com.waltado.lynknow.fragments.EventListFragment;
import com.waltado.lynknow.fragments.GroupListFragment;
import com.waltado.lynknow.fragments.LKMListFragment;

public class MainActivity extends AppCompatActivity implements SmartTabLayout.TabProvider{

    private Toolbar mToolbar;
    private ViewPager mainPager;
    private MainTabAdapter adapter;
    private View bottomSheetView;
    private BottomSheetLayout bottomSheetLayout;
    private FloatingActionButton floatingActionButton;
    private AppCompatSeekBar bottomSheetSeekBar;
    private TextView seekBarPopupTextView;
    private LKMListFragment lkmFragment;
    private ContactListFragment contactListFragment;
    private ChatListFragment chatListFragment;
    private GroupListFragment groupListFragment;
    private EventListFragment eventListFragment;
    private boolean contactRequestBoolean = false, chatRequestBoolean = false, groupRequestBoolean = false, eventAlternateBoolean = false;
    private int fab_0,fab_1,fab_2,fab_3,fab_4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingActionButton = (FloatingActionButton)findViewById(R.id.bottom_sheet_fab);
        fab_0 = R.drawable.ic_plus;
        fab_1 = R.drawable.ic_person_add_white;
        fab_2 = R.drawable.ic_ping_white;
        fab_3 = R.drawable.ic_group_add_white;
        fab_4 = R.drawable.ic_event_invitation_white;

        lkmFragment = new LKMListFragment();
        contactListFragment = new ContactListFragment();
        chatListFragment = new ChatListFragment();
        groupListFragment = new GroupListFragment();
        eventListFragment = new EventListFragment();

        bottomSheetLayout = (BottomSheetLayout) findViewById(R.id.bottomsheet);
        bottomSheetView = LayoutInflater.from(this).inflate(R.layout.custom_bottom_sheet_main, bottomSheetLayout, false);
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
                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                startActivity(intent);
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
                seekBarPopupTextView.setVisibility(View.VISIBLE);
                final Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_in);
                seekBarPopupTextView.startAnimation(animation);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                final Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_out);
                seekBarPopupTextView.startAnimation(animation);
                seekBarPopupTextView.setVisibility(View.INVISIBLE);
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
                        floatingActionButton.setImageResource(fab_0);
                        floatingActionButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                bottomSheetLayout.showWithSheetView(bottomSheetView);
                            }
                        });
                        break;
                    case 1:
                        floatingActionButton.setImageResource(fab_1);
                        floatingActionButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                toggleContactRequestList();
                            }
                        });
                        break;
                    case 2:
                        floatingActionButton.setImageResource(fab_2);
                        floatingActionButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                togglePingList();
                            }
                        });
                        break;
                    case 3:
                        floatingActionButton.setImageResource(fab_3);
                        floatingActionButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                toggleGroupRequestList();
                            }
                        });
                        break;
                    case 4:
                        floatingActionButton.setImageResource(fab_4);
                        floatingActionButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                toggleEventInvitationList();
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
                    return lkmFragment;
                case 1:
                    return contactListFragment;
                case 2:
                    return chatListFragment;
                case 3:
                    return groupListFragment;
                case 4:
                    return eventListFragment;
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

    private void toggleContactRequestList() {

        if(contactRequestBoolean){
            fab_1 = R.drawable.ic_person_add_white;
            contactRequestBoolean = false;
        }else{
            fab_1 = R.drawable.ic_person_white;
            contactRequestBoolean = true;
        }
        floatingActionButton.setImageResource(fab_1);

        contactListFragment.toggleRequestList();

    }

    private void togglePingList() {

        if(chatRequestBoolean){
            fab_2 = R.drawable.ic_ping_white;
            chatRequestBoolean = false;
        }else{
            fab_2 = R.drawable.ic_chat_white;
            chatRequestBoolean = true;
        }
        floatingActionButton.setImageResource(fab_2);

        chatListFragment.toggleRequestList();

    }

    private void toggleGroupRequestList() {

        if(groupRequestBoolean){
            fab_3 = R.drawable.ic_group_add_white;
            groupRequestBoolean = false;
        }else{
            fab_3 = R.drawable.ic_group_white;
            groupRequestBoolean = true;
        }
        floatingActionButton.setImageResource(fab_3);

        groupListFragment.toggleRequestList();

    }

    private void toggleEventInvitationList() {

        if(eventAlternateBoolean){
            fab_4 = R.drawable.ic_event_invitation_white;
            eventAlternateBoolean = false;
        }else{
            fab_4 = R.drawable.ic_event_white;
            eventAlternateBoolean = true;
        }
        floatingActionButton.setImageResource(fab_4);

        eventListFragment.toggleRequestList();

    }

}
