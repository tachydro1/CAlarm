package com.example.c_alarm;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class AlarmFragment extends Fragment {

    //フラグメントのセッティング

    private static final String ARG_SECTION_ID = "section_alarm";


    public static AlarmFragment newInstance(int index) {         //クラスのインスタンスを作る処理,Bundleクラスのインスタンスがデータで、それをargumentsに保存、再生成時に読み込む
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

   /* @Override
    public void onStart() {
        super.onStart();
        final Activity activity = getActivity();
        final Switch onOff = (Switch) activity.findViewById(R.id.onOffSwitch);

        onOff.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //TODO:
            }
        });
    }
    */



}
