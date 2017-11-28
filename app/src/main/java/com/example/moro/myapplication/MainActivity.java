package com.example.moro.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.util.ArrayList;
import java.util.List;

import static com.example.moro.myapplication.R.color.blue;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {

    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionbar = getSupportActionBar();
        if(actionbar!=null){actionbar.hide();}

        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottomNavigationBar.setActiveColor(R.color.myblue);
        bottomNavigationBar.setBarBackgroundColor(R.color.ios);
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, R.string.tab_one))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, R.string.tab_two))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, R.string.tab_three))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, R.string.tab_four))
                .setFirstSelectedPosition(0)
                .initialise();
        bottomNavigationBar.setTabSelectedListener(this);

        setDefaultFragment(new DataFragment());

    }

    private List<Fragment> getFragments(){
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(HomeFragment.newInstance("1","主页"));
        //fragments.add(AnalyzeFragment.newInstance());
        //fragments.add(HistoryFragment.newInstance());
        //fragments.add(SettingFragment.newInstance());
        return fragments;
    }

    @Override
    public void onTabSelected(int position) {
        if (fragments != null){
            if (position < fragments.size()) {
                android.support.v4.app.FragmentManager fragmentmanger = this.getSupportFragmentManager();
                FragmentTransaction transaction = fragmentmanger.beginTransaction();
                Fragment fragment = fragments.get(position);
                transaction.replace(R.id.main_frame, fragment);
                transaction.commit();
            }

        }

    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
    private void setDefaultFragment (Fragment fragment) {
        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.main_frame,fragment );
        transaction.commit();
    }
}
