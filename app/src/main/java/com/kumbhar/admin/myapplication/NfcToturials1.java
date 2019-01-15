package com.kumbhar.admin.myapplication;

import android.nfc.NfcAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class NfcToturials1 extends AppCompatActivity {

    private NfcAdapter nfcAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfc_toturials1);

        nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        if(nfcAdapter != null && nfcAdapter.isEnabled())
        {
            Toast.makeText(this,"NFC available",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"NFC not Available",Toast.LENGTH_SHORT).show();
        }

    }

}
