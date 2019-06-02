package com.example.c_alarm;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.c_alarm.ui.main.SectionsPagerAdapter;

import static com.example.c_alarm.R.id.view_pager;


public class MainActivity extends AppCompatActivity {
    @Override

    //部品系
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);                                                         //必須
        setContentView(R.layout.activity_main);                                                    //activity_main.xml読み込み

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());  //現在のページ番号取得（クラス作ってる）

        ViewPager viewPager = findViewById(view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

    }

}