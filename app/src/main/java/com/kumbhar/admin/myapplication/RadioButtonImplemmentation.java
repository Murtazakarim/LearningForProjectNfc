package com.kumbhar.admin.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioButtonImplemmentation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button_implemmentation);

        RadioGroup rdbgroup = (RadioGroup) findViewById(R.id.rdbgroup);

        rdbgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton rdb1 = (RadioButton) findViewById(R.id.rdb1);

                if(rdb1.isChecked())
                {
                    Toast.makeText(getApplicationContext(),"Male",Toast.LENGTH_LONG).show();
                }else{

                    Toast.makeText(getApplicationContext(),"Female",Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}
