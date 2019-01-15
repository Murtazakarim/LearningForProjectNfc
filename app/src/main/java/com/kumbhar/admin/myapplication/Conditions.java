package com.kumbhar.admin.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Conditions extends AppCompatActivity {

    EditText fp;
    TextView tvfp;
    Button btnfp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conditions);

        fp = (EditText) findViewById(R.id.edit1);
        tvfp = (TextView) findViewById(R.id.tvresult1);
        btnfp = (Button) findViewById(R.id.btnenter);

        btnfp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String option = fp.getText().toString();

                if(option.equals("pass"))
                {
                    tvfp.setText("Your are pass");
                }else if(option.equals("fail")){
                    tvfp.setText("Your are fail");
                }else{
                    tvfp.setText("Invalid");
                }
            }
        });
    }
}
