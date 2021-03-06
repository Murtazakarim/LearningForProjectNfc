package com.kumbhar.admin.myapplication;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.nfc.tech.NdefFormatable;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

public class Nfctutorials04read extends AppCompatActivity {

    NfcAdapter nfcAdapter;
    ToggleButton tglReadWrite;
    EditText txtTagContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfctutorials04read);

        nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        tglReadWrite = (ToggleButton) findViewById(R.id.tglReadWrite);
        txtTagContent = (EditText) findViewById(R.id.txtTagContent);
    }

    @Override
    protected void onResume() {

        enableForegroundDispatchSytem();
        super.onResume();
    }

    @Override
    protected void onPause() {

        disableForegroundDispatchSytem();
        super.onPause();
    }

    @Override
    protected void onNewIntent(Intent intent) {

        if (intent.hasExtra(NfcAdapter.EXTRA_TAG)) {

            Toast.makeText(this, "NfcIntent!", Toast.LENGTH_SHORT).show();

            if (tglReadWrite.isChecked())
            {
                Parcelable[] parcelables = intent.getParcelableArrayExtra(nfcAdapter.EXTRA_NDEF_MESSAGES);

                if (parcelables != null && parcelables.length > 0){

                    readTextFromMessage((NdefMessage) parcelables[0]);

                }else{
                    Toast.makeText(this, "No NDEF message found!", Toast.LENGTH_SHORT).show();
                }

            }else {
                Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
                NdefMessage ndefMessage = createNdefMassage(txtTagContent.getText()+"");
                writeNdefMassage(tag,ndefMessage);
            }


        }
        super.onNewIntent(intent);
    }

    private void readTextFromMessage(NdefMessage ndefMessage) {

        NdefRecord[] ndefRecords = ndefMessage.getRecords();

        if (ndefRecords != null && ndefRecords.length > 0){

            NdefRecord ndefRecord = ndefRecords[0];
            String tagContent = getTextFromNdefRecord(ndefRecord);
            txtTagContent.setText(tagContent);

        }else {
            Toast.makeText(this, "No NDEF records found!", Toast.LENGTH_SHORT).show();
        }
    }

    private String getTextFromNdefRecord(NdefRecord ndefRecord) {

        String tagContent = null;

        try{
            byte[] payload = ndefRecord.getPayload();
            String textEncoding = ((payload[0] & 128) == 0) ? "UTF-8" : "UTF-16";
            int languageSize = payload[0] & 0063;
            tagContent = new String(payload,languageSize + 1,payload.length - languageSize - 1,textEncoding);

        }catch (UnsupportedEncodingException e){
            Log.e("getTextFromNdefRecord", e.getMessage(),e);
        }
        return tagContent;
    }

    public void enableForegroundDispatchSytem() {

        Intent intent = new Intent(this, NfcTutorials03.class).addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        IntentFilter[] intentFilter = new IntentFilter[]{};
        nfcAdapter.enableForegroundDispatch(this, pendingIntent, intentFilter, null);

    }

    public void disableForegroundDispatchSytem() {

        nfcAdapter.disableForegroundDispatch(this);

    }

    private void formatTag(Tag tag, NdefMessage ndefMessage) {

        NdefFormatable ndefFormatable = NdefFormatable.get(tag);

        try {

            if (ndefFormatable == null) {

                Toast.makeText(this, "Tag is not Ndef formatable", Toast.LENGTH_SHORT).show();
                return;
            }

            ndefFormatable.connect();
            ndefFormatable.format(ndefMessage);
            ndefFormatable.close();

            Toast.makeText(this, "Writen!", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {

            Log.e("formatTag", e.getMessage());

        }


    }

    private void writeNdefMassage(Tag tag, NdefMessage ndefMessage) {

        try {

            if (tag == null) {

                Toast.makeText(this, "Tag object can not be null", Toast.LENGTH_SHORT).show();
                return;

            }

            Ndef ndef = Ndef.get(tag);

            if (ndef == null) {


                formatTag(tag, ndefMessage);
            } else {
                ndef.connect();

                if (!ndef.isWritable()) {

                    Toast.makeText(this, "Tag is not writeable!", Toast.LENGTH_SHORT).show();
                    ndef.close();
                    return;
                }

                ndef.writeNdefMessage(ndefMessage);
                ndef.close();

                Toast.makeText(this, "Writen!", Toast.LENGTH_SHORT).show();

            }

        } catch (Exception e) {

            Log.e("writeNdefMassage", e.getMessage());
        }
    }

    private NdefRecord createTextRecord(String content) {

        try {
            byte[] langauge;
            langauge = Locale.getDefault().getLanguage().getBytes("UTF-8");

            final byte[] text = content.getBytes("UTF-8");
            final int languageSize = langauge.length;
            final int textLength = text.length;
            final ByteArrayOutputStream payload = new ByteArrayOutputStream(1 + languageSize + textLength);

            payload.write((byte) (languageSize & 0x1F));
            payload.write(langauge, 0, languageSize);
            payload.write(text, 0, textLength);

            return new NdefRecord(NdefRecord.TNF_WELL_KNOWN, NdefRecord.RTD_TEXT, new byte[0], payload.toByteArray());


        } catch (Exception e) {
            Log.e("CreateTextRecord", e.getMessage());
        }

        return null;
    }

    private NdefMessage createNdefMassage(String content){

        NdefRecord ndefRecord = createTextRecord(content);

        NdefMessage ndefMessage = new NdefMessage(new NdefRecord[]{ndefRecord});

        return ndefMessage;
    }


    public void tglReadWriteOnClick(View view) {
        txtTagContent.setText("");
    }
}
