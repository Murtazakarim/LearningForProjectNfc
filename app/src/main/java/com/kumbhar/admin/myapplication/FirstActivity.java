package com.kumbhar.admin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    EditText edtFirstName,edtSecondName;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        edtFirstName = (EditText) findViewById(R.id.edtFirst);
        edtSecondName = (EditText) findViewById(R.id.edtSecond);
        btnNext = (Button) findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String FirstName = edtFirstName.getText().toString();
                String LastName = edtSecondName.getText().toString();
                Intent it = new Intent(FirstActivity.this,SecondActivity.class);
                it.putExtra("FirstName",FirstName);
                it.putExtra("LastName",LastName);
                startActivity(it);
            }
        });

    }
}
