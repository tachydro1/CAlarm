package com.example.c_alarm;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.sql.PreparedStatement;



public class PresetFragment extends Fragment {

    private static final String ARG_SECTION_ID = "section_preset";


    public static PresetFragment newInstance(int index) {
        PresetFragment fragment = new PresetFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_ID, index);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int index = 1;
        if(getArguments() != null){
            index = getArguments().getInt(ARG_SECTION_ID);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,                         //inflaterのいるやつ、おｋ
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_preset, container, false);
    }

}
