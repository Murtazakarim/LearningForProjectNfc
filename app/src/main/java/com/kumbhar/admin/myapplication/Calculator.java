package com.kumbhar.admin.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends AppCompatActivity implements View.OnClickListener {

    EditText editFirst,editSecond;
    Button btnAdd,btnMinus,btnMultiply,btnDivide;
    TextView tvResult;
    double firstname,secondname,result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        editFirst = (EditText) findViewById(R.id.tvview);
        editSecond = (EditText) findViewById(R.id.tvsecond);
        btnAdd = (Button) findViewById(R.id.btnadd);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnMultiply = (Button) findViewById(R.id.btnMultiply);
        btnDivide = (Button) findViewById(R.id.btnDivide);
        tvResult = (TextView) findViewById(R.id.tvresult);

        btnAdd.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivide.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch(v.getId())
        {
            case R.id.btnadd:
                firstname = Double.valueOf(editFirst.getText().toString());
                secondname = Double.valueOf(editSecond.getText().toString());
                result = firstname+secondname;
                tvResult.setText("Your result is ="+result);
                break;
            case R.id.btnMinus:
                firstname = Double.valueOf(editFirst.getText().toString());
                secondname = Double.valueOf(editSecond.getText().toString());
                result = firstname-secondname;
                tvResult.setText("Your result is ="+result);
                break;
            case R.id.btnMultiply:
                firstname = Double.valueOf(editFirst.getText().toString());
                secondname = Double.valueOf(editSecond.getText().toString());
                result = firstname*secondname;
                tvResult.setText("Your result is ="+result);
                break;
            case R.id.btnDivide:
                firstname = Double.valueOf(editFirst.getText().toString());
                secondname = Double.valueOf(editSecond.getText().toString());
                result = firstname/secondname;
                tvResult.setText("Your result is ="+result);
                break;
        }
    }
}
