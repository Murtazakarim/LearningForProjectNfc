package com.kumbhar.admin.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SQLView extends AppCompatActivity {

    TextView tvView;
    SqLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlview);

        tvView = (TextView) findViewById(R.id.tvView);
        db = new SqLiteDatabase(this);
        String data = db.getData();
        tvView.setText(data);
    }
}
