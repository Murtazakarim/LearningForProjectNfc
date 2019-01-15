package com.kumbhar.admin.myapplication;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class DatabaseImplimentation extends AppCompatActivity implements View.OnClickListener {

    EditText edtfirstname,edtsecondname,edtid;
    Button btnInsert,btnView,btnSearch,btnUpdate,btnDelete;
    SqLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_implimentation);

        edtfirstname = (EditText) findViewById(R.id.edtfirstname);
        edtsecondname = (EditText) findViewById(R.id.edtsecondname);
        edtid = (EditText) findViewById(R.id.edtid);

        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnView = (Button) findViewById(R.id.btnView);
        btnSearch = (Button) findViewById(R.id.btnSearch);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnDelete = (Button) findViewById(R.id.btnDelete);

        btnInsert.setOnClickListener(this);
        btnView.setOnClickListener(this);
        btnSearch.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);

        db = new SqLiteDatabase(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnInsert:
                boolean fine=true;
                try {

                    String firstname = edtfirstname.getText().toString();
                    String secondname = edtsecondname.getText().toString();
                    db.insertStudent(firstname, secondname);
                }
                catch (Exception e)
                {
                    fine =false;
                    String error = e.toString();
                    Dialog d = new Dialog(this);
                    d.setTitle("Sorry");
                    TextView tv = new TextView(this);
                    tv.setText(error);
                    d.setContentView(tv);
                    d.show();
                }finally {
                    if(fine)
                    {
                        Dialog d = new Dialog(this);
                        d.setTitle("Atlas we did it");
                        TextView tv = new TextView(this);
                        tv.setText("Success");
                        d.setContentView(tv);
                        d.show();
                    }

                }

                break;
            case R.id.btnView:

                Intent it = new Intent(getApplicationContext(),SQLView.class);
                startActivity(it);

                break;
            case R.id.btnSearch:
                boolean fine1=true;
                try {

                    String id =edtid.getText().toString();
                    long l = Long.parseLong(id);
                    String fname = db.getStudentfirstname(l);
                    String sname = db.getStudentsecondname(l);

                    edtfirstname.setText(fname);
                    edtsecondname.setText(sname);

                }
                catch (Exception e)
                {
                    fine1 =false;
                    String error = e.toString();
                    Dialog d = new Dialog(this);
                    d.setTitle("Sorry");
                    TextView tv = new TextView(this);
                    tv.setText(error);
                    d.setContentView(tv);
                    d.show();
                }finally {
                    if(fine1)
                    {
                        Dialog d = new Dialog(this);
                        d.setTitle("Atlas we did it");
                        TextView tv = new TextView(this);
                        tv.setText("Success");
                        d.setContentView(tv);
                        d.show();
                    }

                }
                break;
            case R.id.btnUpdate:
                boolean fine2=true;
                try {

                    String firstname = edtfirstname.getText().toString();
                    String secondname = edtsecondname.getText().toString();
                    String id =edtid.getText().toString();
                    long l = Long.parseLong(id);
                    db.UpdateStudent(l,firstname,secondname);

                }
                catch (Exception e)
                {
                    fine2 =false;
                    String error = e.toString();
                    Dialog d = new Dialog(this);
                    d.setTitle("Sorry");
                    TextView tv = new TextView(this);
                    tv.setText(error);
                    d.setContentView(tv);
                    d.show();
                }finally {
                    if(fine2)
                    {
                        Dialog d = new Dialog(this);
                        d.setTitle("Atlas we did it");
                        TextView tv = new TextView(this);
                        tv.setText("Success");
                        d.setContentView(tv);
                        d.show();
                    }

                }
                break;
            case R.id.btnDelete:
                boolean fine3=true;
                try {

                    String id =edtid.getText().toString();
                    long l = Long.parseLong(id);
                    db.deleteStudent(l);


                }
                catch (Exception e)
                {
                    fine3 =false;
                    String error = e.toString();
                    Dialog d = new Dialog(this);
                    d.setTitle("Sorry");
                    TextView tv = new TextView(this);
                    tv.setText(error);
                    d.setContentView(tv);
                    d.show();
                }finally {
                    if(fine3)
                    {
                        Dialog d = new Dialog(this);
                        d.setTitle("Atlas we did it");
                        TextView tv = new TextView(this);
                        tv.setText("Success");
                        d.setContentView(tv);
                        d.show();
                    }

                }
                break;
        }
    }
}
