package com.example.c_alarm.dialogs;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import com.example.c_alarm.AlarmFragment;

import java.util.ArrayList;
import java.util.List;

public class MusicCategorySelectFragment extends DialogFragment{

    String musicTitle;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final String[] categories = {"アラーム音", "category1", "category2"};

        return new AlertDialog.Builder(getActivity())
                .setTitle("アラーム音カテゴリ")
                .setItems(categories, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                dialog.dismiss();
                                DialogFragment defaultMusicSelectFragment = new DefaultMusicSelectFragment();
                                defaultMusicSelectFragment.show(getFragmentManager(), "DEFAULT_SELECT");


                            case 1:

                            case 2:

                        }

                    }
                })
                .show();
    }


/*    public Dialog onCreateDialog2() {

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

        return new AlertDialog.Builder(getActivity())
                .setTitle("アラーム音一覧")
                .setSingleChoiceItems(items, defaultCheckedItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        checkedItem.clear();
                        checkedItem.add(which);
                        ringtoneManager.getRingtone(which).play();
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (!checkedItem.isEmpty()) {
                            ringtoneManager.getRingtone(checkedItem.get(0)).stop();
                            musicTitle = defaultAlarmSounds.get(checkedItem.get(0));
                            AlarmFragment alarmFragment = new AlarmFragment();
                            Bundle bundle = new Bundle();
                            bundle.putString("MUSIC_TITLE", musicTitle);
                            alarmFragment.setArguments(bundle);

                            //TODO:曲名を表示する
                        }
                    }
                })
                .setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        if (!checkedItem.isEmpty()) {
                            ringtoneManager.getRingtone(checkedItem.get(0)).stop();
                            //TODO:戻るやつ（なくてもよくね…）曲選べるようになってから利便性を見てだな…
                        }
                    }
                })
                .show();
    }
*/



    //*******************************************************************************************
/*
    static public class FileInfo{   //インナークラス　ファイル・ディレクトリの表示名とfileオブジェクトの管理
        private String fileName;
        private File fileFile;

        public FileInfo(String string, File file){
            fileName = string;
            fileFile = file;
        }

        public String getName(){
            return fileName;
        }

        public File getFile(){
            return fileFile;
        }
    }


    static public class FileInfoArrayAdapter extends BaseAdapter{ //インナークラス　ファイル情報配列アダプタ
    //ファイル情報リストの委譲・管理、ListViewの一要素のビュー作成
        private Context contextContext;
        private List<FileInfo> fileInfoList;

        //コンストラクタ
        public FileInfoArrayAdapter(Context context, List<FileInfo> list){
            super();
            contextContext = context;
            fileInfoList = list;
        }

        @Override
        public int getCount(){
            return fileInfoList.size();
        }

        @Override
        public FileInfo getItem(int position){
            return fileInfoList.get(position);
        }

        @Override
        public long getItemId(int position){
            return position;
        }

        static class ViewHolder{
            TextView textViewFileName;
        }

        //一要素のビューの生成
        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            ViewHolder viewHolder;
            if(convertView == null){
                //レイアウト
                LinearLayout layout = new LinearLayout(contextContext);
                layout.setOrientation(LinearLayout.VERTICAL);
                layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                //ファイル名テキスト
                TextView textViewFileName2 = new TextView(contextContext);
                textViewFileName2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 24);
                layout.addView(textViewFileName2, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

                convertView = layout;
                viewHolder = new ViewHolder();
                viewHolder.textViewFileName = textViewFileName2;
                convertView.setTag(viewHolder);
            }else{
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.textViewFileName.setText(fileInfoList.get(position).getName());
            return convertView;
        }
    }
    //保存したページの3つ目のクラスから続き




    //TODO: 7/3 : ダイアログ戻る機能のためにフラグメント分けるとしても、マイ音楽の方を考えてからでないとできないのでダイアログ戻る機能はいったん保留であとで考える
*/
}