package com.example.c_alarm.ui.main;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.c_alarm.AlarmFragment;
import com.example.c_alarm.PresetFragment;
import com.example.c_alarm.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {      //タブやタイトルもあるのでMainActivity内でなく別でアダプターを作成

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tabAlarm_text, R.string.tabPreset_text};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        switch(position){
            case 0:
                return AlarmFragment.newInstance(position + 1);
            case 1:
                return PresetFragment.newInstance(position + 1);
        }
        return null;
    }

    @Nullable
    @Override                                                                                       //タイトルがずっと表示されてる
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }
}