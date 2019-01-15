package com.kumbhar.admin.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Broadcastreceiverimplementation extends AppCompatActivity {

    private BroadcastReceiver broad = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            int level = intent.getIntExtra("level",0);
            ProgressBar pb = (ProgressBar) findViewById(R.id.progressbettry);
            pb.setProgress(level);

            TextView tv = (TextView) findViewById(R.id.textBettry);
            tv.setText("Bettry Level " +Integer.toString(level) +"%");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcastreceiverimplementation);

        registerReceiver(broad, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }
}
