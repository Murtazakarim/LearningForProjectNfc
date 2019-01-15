package com.kumbhar.admin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv = (TextView) findViewById(R.id.tvData);

        Intent it = getIntent();
        String FirstName = it.getStringExtra("FirstName");
        String LastName = it.getStringExtra("LastName");

        tv.setText("FirstName: "+FirstName+"\nLastName: "+LastName);

    }
}
