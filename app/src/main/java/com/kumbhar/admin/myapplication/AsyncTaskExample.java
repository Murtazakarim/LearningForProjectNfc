package com.kumbhar.admin.myapplication;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AsyncTaskExample extends AppCompatActivity {
    TextView textResult;
    Button btntime;
    EditText edtTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task_example);

        textResult = (TextView) findViewById(R.id.textResult);
        btntime = (Button) findViewById(R.id.btntime);
        edtTime = (EditText) findViewById(R.id.edtTime);

        btntime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncTaskEx asyncTaskEx = new AsyncTaskEx();
                String time = edtTime.getText().toString();
                asyncTaskEx.execute(time);

            }
        });
    }

    private class AsyncTaskEx extends AsyncTask<String , String , String> {

        private String res;
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(AsyncTaskExample.this,"ProgressDialog","Wait for"+edtTime.getText().toString()+"seconds");
        }

        @Override
        protected String doInBackground(String... params) {

            try{

                int time = Integer.valueOf(params[0])*1000;
                Thread.sleep(time);
                res = "Slept for "+params[0]+" seconds";

            }catch (Exception ex){
                ex.printStackTrace();
            }
            return res;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressDialog.dismiss();
            textResult.setText(s);
        }
    }
}
