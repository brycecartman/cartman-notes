package com.example.assignment1;

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
  
    // This will take you to the "New Counter" activity.    
    public void newCounter(View view) {
        Intent intent = new Intent(this, NewCounterActivity.class);
        startActivity(intent);
    }
    
    
    // This will take you to the "View Counters" activity.
    public void viewCounters(View view) {
    	Intent intent = new Intent(this, ViewCountersActivity.class);
        startActivity(intent);
    }
    
}
