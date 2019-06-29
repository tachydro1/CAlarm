package com.example.c_alarm;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class AlarmFragment extends Fragment {

    //フラグメントのセッティング
    private static final String ARG_SECTION_ID = "section_alarm";

    public static AlarmFragment newInstance(int index) {         //クラxs bbスのインスタンスを作る処理,Bundleクラスのインスタンスがデータで、それをargumentsに保存、再生成時に読み込む
        AlarmFragment fragment = new AlarmFragment();              //fragmentをnew定義
        Bundle bundle = new Bundle();                                          //bundleをnew定義
        bundle.putInt(ARG_SECTION_ID, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {                               //argumentsから値を取り出す処理(TODO:クラスの最後じゃないとだめ？)
        super.onCreate(savedInstanceState);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_ID);
        }
    }

    @Override                                                               //★フラグメントのビューを設計図から作成して返す★
    public View onCreateView(                                                                       //めっちゃいるっぽい
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_alarm, container, false);     //引数で貰ったinflaterでレイアウトをinflateする
        return root;                                                                               //inflateされたViewをそのまま返す
    }



    //機能の中身（本題）
    Switch setSwitch;
    TextView timeText;
    Calendar alarmCalendar;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setSwitch = (Switch) getActivity().findViewById(R.id.setSwitch);
        setSwitch.setOnCheckedChangeListener(setSwitchListener);

        timeText = (TextView) getActivity().findViewById(R.id.timeText);
        timeText.setOnClickListener(setTimeListener);
    }

    CompoundButton.OnCheckedChangeListener setSwitchListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            final MainActivity mainAct = (MainActivity) getActivity();

            if(isChecked == true){
                mainAct.setAlarmManager(alarmCalendar);
            }else{
                mainAct.cancelAlarmManager();
            }
        }
    };

    View.OnClickListener setTimeListener = new View.OnClickListener() {
        Calendar calendar = Calendar.getInstance();

        @Override
        public void onClick(View v) {
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);
            TimePickerDialog dialog =  new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                    calendar.set(calendar.MINUTE, minute);
                    calendar.set(calendar.SECOND, 0);
                    alarmCalendar = calendar;
                    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
                    String selectedTime = dateFormat.format(calendar.getTime());
                    timeText.setText(selectedTime);
                }
            }, hour, minute, true);
            dialog.show();
        }
    };
}

