package com.example.c_alarm.dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.TextView;

import com.example.c_alarm.AlarmFragment;
import com.example.c_alarm.R;

import java.util.ArrayList;
import java.util.List;

public class DefaultMusicSelectFragment extends DialogFragment {

    public String musicTitle;

/*インターフェース
    public interface DefaultMusicSelectListener{
        public String sendMusicTitle(String musicTitleSender);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        DefaultMusicSelectListener listener = (DefaultMusicSelectListener) context;
    }
    public class ResistMusicTitle implements DefaultMusicSelectListener{
        @Override
        public String sendMusicTitle(String musicTitleSender) {
            return musicTitle;
        }
    }
*/

    //ダイアログ作成
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final List<String> defaultAlarmSounds = new ArrayList<String>();
        final RingtoneManager ringtoneManager = new RingtoneManager(getActivity().getApplicationContext());
        final Cursor cursor = ringtoneManager.getCursor();

        while (cursor.moveToNext()) {
            defaultAlarmSounds.add(cursor.getString(RingtoneManager.TITLE_COLUMN_INDEX));
        }

        final String[] items = defaultAlarmSounds.toArray(new String[defaultAlarmSounds.size()]);
        final int defaultCheckedItem = 0;
        final List<Integer> checkedItem = new ArrayList<>();
        checkedItem.add(defaultCheckedItem);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("アラーム音一覧");
        builder.setSingleChoiceItems(items, defaultCheckedItem, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    checkedItem.clear();
                    checkedItem.add(which);
                    ringtoneManager.getRingtone(which).play();
                }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (!checkedItem.isEmpty()) {
                        ringtoneManager.getRingtone(checkedItem.get(0)).stop();
                        musicTitle = items[checkedItem.get(0)];
                        //TODO:曲名を表示する
                        }
                    }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        if (!checkedItem.isEmpty()) {
                            ringtoneManager.getRingtone(checkedItem.get(0)).stop();
                            //TODO:戻るやつ（なくてもよくね…）曲選べるようになってから利便性を見てだな…
                        }
                    }
        });
        return builder.create();
    }

    AlarmFragment alarmFragment = new AlarmFragment();

}
