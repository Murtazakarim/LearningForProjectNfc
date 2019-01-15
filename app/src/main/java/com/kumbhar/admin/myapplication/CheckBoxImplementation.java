package com.kumbhar.admin.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class CheckBoxImplementation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box_implementation);

        final CheckBox checkbox1 = (CheckBox) findViewById(R.id.checkbox1);
        checkbox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkbox1.isChecked()){
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"UnChecked",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
