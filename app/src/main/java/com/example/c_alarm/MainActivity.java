package com.example.c_alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.c_alarm.ui.main.SectionsPagerAdapter;

import java.util.Calendar;

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


    public void setAlarmManager(Calendar calendar) {
        final AlarmManager am = ((AlarmManager) getSystemService(Context.ALARM_SERVICE));
        final Intent intent = new Intent(this, AlarmReceiver.class);
        final PendingIntent pending = PendingIntent.getBroadcast(this, 0, intent, 0);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            final AlarmManager.AlarmClockInfo info = new AlarmManager.AlarmClockInfo(calendar.getTimeInMillis(), null);
            am.setAlarmClock(info, pending);
        }else{
            am.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pending);             //今回はKITKAT(19)以上で設計しているためこれ以下用の動作は省略
        }
    }

    public void cancelAlarmManager() {
        final AlarmManager am = ((AlarmManager) getSystemService(Context.ALARM_SERVICE));
        final Intent intent = new Intent(this, AlarmReceiver.class);
        final PendingIntent pending = PendingIntent.getBroadcast(this, 0, intent, 0);
        am.cancel(pending);
    }
}