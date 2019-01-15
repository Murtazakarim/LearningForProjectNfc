package com.kumbhar.admin.myapplication;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class LoopImplimentation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loop_implimentation);

    /*    for(int i=0; i<10; i++)
        {
            Log.d("Loop testing","Hello world");
        }*/
    /*int i=0;
    while(i<10)
    {
        Log.d("Loop testing", "Hello word");
        i++;
    }*/

   /* String [] dishes={"biscuits","biryani","choclate"};
    for(int j=0; j<3; j++ )
    {
        Log.d("My favourate dishes", ""+dishes[j]);
    }*/

        Resources res = getResources();
        String [] dishes = res.getStringArray(R.array.array_dishes);

        for(int j=0; j<4; j++ )
        {
            Log.d("My favourate dishes", ""+dishes[j]);
        }

    }
}
