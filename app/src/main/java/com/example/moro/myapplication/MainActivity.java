package com.example.moro.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import static com.example.moro.myapplication.R.color.blue;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    }
}
