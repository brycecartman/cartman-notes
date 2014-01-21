package com.example.assignment1;

import java.util.Calendar;
import java.util.TimeZone;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;


//This is the main activity window. It has three options, to go to the create counter
//menu, view counters or to sort the counters before displaying them on view counters.

public class MainActivity extends Activity {

			
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
       // Restores the counters ArrayList file from "file.txt".
       CounterFunctions.restoreCounters(getBaseContext());

        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void newCounter(View view) {
    	 Intent intent = new Intent(this, NewCounterActivity.class);
         startActivity(intent);
    }
    
    
    public void viewCounters(View view) {
    	Intent intent = new Intent(this, ViewCountersActivity.class);
        startActivity(intent);
    }
    
    
    public void sortCounters(View view) {
    	
    }
    
    
}
