package com.kumbhar.admin.myapplication;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomDialog extends AppCompatActivity {

    Button btnDialog1,btnDialog2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);
        btnDialog1 = (Button) findViewById(R.id.btnDialog);
        btnDialog2 = (Button) findViewById(R.id.btnDialog2);

        btnDialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog1 = new Dialog(CustomDialog.this);
                dialog1.setContentView(R.layout.custom_dialog2);
                dialog1.setCancelable(true);
                dialog1.show();
            }
        });

        btnDialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(CustomDialog.this);
                dialog.setContentView(R.layout.custom_dialog);
                dialog.setTitle("Custom Dialog");

                TextView text = (TextView) dialog.findViewById(R.id.textDialog);
                text.setText("Murtaza Dialog");

                ImageView image = (ImageView) dialog.findViewById(R.id.imageDialog);
                image.setImageResource(R.drawable.dialog3);

                dialog.show();

                Button declineButton = (Button) dialog.findViewById(R.id.declineButton);
                declineButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

            }
        });
    }
}
