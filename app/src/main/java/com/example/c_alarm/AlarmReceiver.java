package com.example.c_alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {                                        //通知を受け取ったときの処理を記述する
        // TODO: This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");
        Toast.makeText(context, "Received alarm.", Toast.LENGTH_SHORT).show();

        Intent startActivityIntent = new Intent(context, AlertActivity.class);
        startActivityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(startActivityIntent);
    }
}
