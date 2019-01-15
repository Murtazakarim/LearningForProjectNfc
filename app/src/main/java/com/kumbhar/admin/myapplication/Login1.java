package com.kumbhar.admin.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login1 extends AppCompatActivity {
    EditText etusername,etpassword;
    Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);

        etusername = (EditText) findViewById(R.id.etusername);
        etpassword = (EditText) findViewById(R.id.etpassword);
    }

    public void OnLogin(View view) {
        String username = etusername.getText().toString();
        String password = etpassword.getText().toString();
        String type = "login";
        BackgroundWorker backgroundWorker = new  BackgroundWorker(this);
        backgroundWorker.execute(type,username,password);
    }
}
