package com.kumbhar.admin.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStorage extends AppCompatActivity {

    EditText edtFilename,edtContent;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_storage);
        edtFilename = (EditText) findViewById(R.id.edtFilename);
        edtContent = (EditText) findViewById(R.id.edtContent);
        btnSave = (Button) findViewById(R.id.btnsave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fileName = edtFilename.getText().toString();
                String content = edtContent.getText().toString();

                FileOutputStream fos;

                try{
                    fos = openFileOutput(fileName,Context.MODE_PRIVATE);
                    fos.write(content.getBytes());
                    fos.close();

                    Toast.makeText(FileStorage.this, fileName+" Saved", Toast.LENGTH_SHORT).show();

                }catch (FileNotFoundException e){
                    e.printStackTrace();
                    }
                    catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
