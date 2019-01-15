package com.kumbhar.admin.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListviewImplementation extends AppCompatActivity {

    ListView lv;
    String [] name = {"Aijaz","Mustafa","Murtaza","Sikander","Waseem shah","Waqas jatt","gianji","wahid"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_implementation);

        lv = (ListView) findViewById(R.id.lstView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,name);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int index = position;
                Toast.makeText(getApplicationContext(),"You Selected Name"+name[index],Toast.LENGTH_SHORT).show();
            }
        });


    }
}
