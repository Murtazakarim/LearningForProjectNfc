package com.kumbhar.admin.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CheckNetwork extends AppCompatActivity {
    TextView tvNetwork;
    Button btnChecknetwork,btnEnableWifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_network);

        tvNetwork = (TextView) findViewById(R.id.tvNetwork);
        btnChecknetwork = (Button) findViewById(R.id.btnChecknetwork);
        btnEnableWifi = (Button) findViewById(R.id.btnEnableWifi);

        ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activenetwork  = cm.getActiveNetworkInfo();

        if (activenetwork != null){
            if (activenetwork.getType() == ConnectivityManager.TYPE_WIFI){

                Toast.makeText(getApplicationContext(),activenetwork.getTypeName(),Toast.LENGTH_SHORT).show();


            }else if (activenetwork.getType() == ConnectivityManager.TYPE_MOBILE){

                Toast.makeText(getApplicationContext(),activenetwork.getTypeName(),Toast.LENGTH_SHORT).show();

            }else {
                Toast.makeText(getApplicationContext(),"Not Connected",Toast.LENGTH_SHORT).show();
            }
        }

        WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        wifi.setWifiEnabled(true);
        boolean wifienable = wifi.isWifiEnabled();

        btnChecknetwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = getIntent();
                finish();
                startActivity(it);
            }
        });

        btnEnableWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Settings.ACTION_SETTINGS));
            }
        });
    }
}
