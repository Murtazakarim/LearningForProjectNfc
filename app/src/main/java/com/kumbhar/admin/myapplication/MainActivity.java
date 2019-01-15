package com.kumbhar.admin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv ;
    Button btnreset,btncounter,btncalculator;
    int counter =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tvcounter);
        btncounter = (Button) findViewById(R.id.btncounter);
        btnreset = (Button) findViewById(R.id.btnreset);
        btncalculator = (Button) findViewById(R.id.btnCalculator);

        btncounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                tv.setText("Your Counter Is:"+counter);
            }
        });

        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter =0;
                tv.setText("Your Counter Is:"+counter);
            }
        });

        btncalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this,Calculator.class);
                startActivity(it);
            }
        });
    }
}
