package com.example.assignment1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;

public class CounterActivity extends Activity implements OnClickListener {

	Button incrementBtn; // The button that increments the counter.
	Button resetBtn; // The button that resets the counter.
	Button homeBtn; // The button that takes you to the app's home.
	EditText counterBox; // The box containing counter text.
	int counterValue = 0; // The default counter value.
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Gets the name of the clicker and sets it as the title.
		Intent intent = getIntent();
		String myCounterName = intent.getStringExtra(NewCounterActivity.counterName);
		setTitle(myCounterName);
		
		// Gets the value of the clicker.
		//int temp = intent.getIntExtra("arrayValue", 0);
		
		
		// Stores the name of the clicker into shared preferences and commits.
		SharedPreferences clickerData = getSharedPreferences("clickerData", MODE_WORLD_READABLE);
		SharedPreferences.Editor clickerEdit;
		clickerEdit = clickerData.edit();
		clickerEdit.putString("MYVALUE", myCounterName);
		clickerEdit.commit();
		
		setContentView(R.layout.activity_counter);
		// Show the Up button in the action bar.
		setupActionBar();
		
		// Assigns the buttons and text box their proper item via ID.
		incrementBtn = (Button)findViewById(R.id.incrementCounter);
		resetBtn = (Button)findViewById(R.id.resetCounter);
		homeBtn = (Button)findViewById(R.id.homeButton);
		counterBox = (EditText)findViewById(R.id.editText1);
		
		// Allows the buttons to be checked for a click event.
		incrementBtn.setOnClickListener(this);
		resetBtn.setOnClickListener(this);
		homeBtn.setOnClickListener(this);
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
		getMenuInflater().inflate(R.menu.counter, menu);
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
	
	
	// This function will increment the value, reset the counter or
	// go home based on a onClick event occurring.
	
	
	public void onClick(View v){
		if (v == incrementBtn){
			counterValue = counterValue + 1;
			counterBox.setText(Integer.toString(counterValue));
			}
		
		if (v == resetBtn){
			counterValue = 0;
			counterBox.setText(Integer.toString(counterValue));
		}
		
		if (v == homeBtn){
			Intent intent = new Intent(this, MainActivity.class);
	        startActivity(intent);
		}
			
		}
	}



