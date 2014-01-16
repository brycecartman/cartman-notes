package com.example.assignment1;

// This is the main activity window. It has two options, to go to the create counter
// menu or to view current counters.
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
    
}
