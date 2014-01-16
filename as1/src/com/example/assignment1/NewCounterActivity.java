package com.example.assignment1;

// This activity gives you the option to specify the name of a counter and create it.

import android.os.Bundle;
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

public class NewCounterActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_new_counter);
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

	
	// The data from the textbook ie: counterName
	// public static String counterName = "com.example.assignment1.MESSAGE";
	// Gets the name of the counter and goes to the new counter screen.
	public void counter(View view) {
        Intent intent = new Intent(this, CounterActivity.class);
        EditText editText = (EditText)findViewById(R.id.newCounter_message);
        
       int arrayValue = counterFunctions.counters.size();
        
        // Find the next open counter spot. There are only 50 counters MAX.
       /* for(int i = counterFunctions.counters.size(); i > 0; i--){
    		if(counterFunctions.counters.get(i).isEmpty() == false){    // Checks to see if the counter is empty.
    		     arrayValue = i; // Gives the correct array location.
    		     break;
    		 }
    	}*/
        
        // Gets the name of the counter and sends it to the CounterActivity.java activity.
        String message = editText.getText().toString();
        intent.putExtra("arrayValue", arrayValue);
		intent.putExtra("counterName", message);
		
		counterFunctions.addCounter(message);
		startActivity(intent);
    }

}
