package com.kumbhar.admin.myapplication;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.Buffer;

public class JSONPARSINGFROMSERVER extends AppCompatActivity {

    TextView txtvw;
    String [] array;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsonparsingfromserver);
        txtvw = (TextView) findViewById(R.id.txtvw);
    }

    public class jsondata extends AsyncTask<Void, Void, String>
    {
        String names;
        ProgressDialog pd;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd=new ProgressDialog(JSONPARSINGFROMSERVER.this);
            pd.setTitle("Loading Data");
            pd.setCancelable(true);
            pd.show();
        }

        @Override
        protected String doInBackground(Void...voids ) {

            try {
                URL url = new URL("http://192.168.0.136/androidexamples/colorsname.json");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder result = new StringBuilder();
                String data;

                while ((data= reader.readLine()) != null){
                    result.append(data);
                }

                JSONObject obj = new JSONObject(result.toString());
                JSONArray mArray = obj.getJSONArray("colors");

                for (int i = 0; i<mArray.length(); i++){

                    JSONObject jinside = mArray.getJSONObject(i);
                    String color = jinside.getString("color");
                    String category = jinside.getString("category");


                    //JSON PART 2

                    JSONArray secondarray = jinside.getJSONArray("code");
                    for(int j=0; j<secondarray.length(); j++){

                        JSONObject jjinside = secondarray.getJSONObject(j);
                        String hex = jjinside.getString("hex");
                        Log.d("hex",""+hex);
                       // Toast.makeText(getApplicationContext(),""+hex,Toast.LENGTH_SHORT).show();

                    }


                    Log.d("color",""+color);
                    Log.d("category",""+category);
                   // Toast.makeText(getApplicationContext(),""+color,Toast.LENGTH_SHORT).show();
                    // Toast.makeText(getApplicationContext(),""+category,Toast.LENGTH_SHORT).show();
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) { pd.dismiss();
        }
    }
}
