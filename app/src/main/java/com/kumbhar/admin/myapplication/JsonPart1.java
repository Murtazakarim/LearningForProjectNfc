package com.kumbhar.admin.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;

public class JsonPart1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_part1);

        try{
            JSONObject obj = new JSONObject(JsonLoad());
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
                    Toast.makeText(getApplicationContext(),""+hex,Toast.LENGTH_SHORT).show();

                }


                Toast.makeText(getApplicationContext(),""+color,Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),""+category,Toast.LENGTH_SHORT).show();
            }

        }catch (JSONException e){
            e.printStackTrace();
        }

    }

    public String JsonLoad(){

        String json=null;
        try{
            InputStream is=getApplicationContext().getAssets().open("colorsname.json");
            int size = is.available();
            byte[] buffer= new byte[size];
            is.read(buffer);
            is.close();
            json=new String(buffer, "UTF-8");

        }catch (Exception ex){

            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
