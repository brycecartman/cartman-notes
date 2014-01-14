package com.example.assignment1;

import java.util.ArrayList;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class NewCounterActivity extends Activity{
	public static String counterName = "com.example.assignment1.MESSAGE";
	private ArrayAdapter<counter> myAdapter;
	
	
	// The counter class which holds all the counter functions + the list of counters.
	public class counter{
		
	
	    // Basic counter variables.
		public String name; // The name of the counter.
		public int count; // The count of the counter.
		public int isEmpty; // 
			
		// .setName(counterName) will set the counter's name.
		public void setName(String counterName){
				name = counterName;
			}
		// .count(countValue) will set/update the counter's value.
		public void count(int countValue){
			count = countValue;
		}
			
		// .isEmpty will show if the counter space is taken or not.
		public void isEmpty(int emptyValue){
			isEmpty = emptyValue;
		}
		
		// .getCounters() will be used to retrieve the counter array.
		public ArrayList<counter> getCounters(){
			return counters; // Returns the ArrayList<counter> counters
		}
	}
		
	
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_counter);
		// This ArrayList will physically hold the counters.
	    ArrayList<counter> counters = new ArrayList<counter>();
	      
		Intent intent = new Intent(this, CounterActivity.class);
        EditText editText = (EditText)findViewById(R.id.newCounter_message);
        String message = editText.getText().toString(); // Message holds the name of the counter.
		int arrayValue = 0; // Holds the value of the array.
		for(int i = 0; i < counters.size(); i++){
		if(counters.get(i).isEmpty == 0){    // Checks to see if the counter is empty.
			 counters.get(i).name = message; // Sets the counters name.
			 counters.get(i).count = 0; // Set the counters default count to 0.
			 counters.get(i).isEmpty = 1; // Set the counter to being full ie: in use.
		     arrayValue = i; // Gives the correct array location.
		 }
		}
		intent.putExtra("counterName", message); // Makes the next page show the counter name.
		intent.putExtra("arrayValue", arrayValue); // Gives the arrayValue to the next activity.
        startActivity(intent);
    }

		// Show the Up button in the action bar.
		setupActionBar();
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_counter, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	// Gets the name of the counter and goes to the new counter screen.
	public void counter(View view) {
				
        
}
	
}
