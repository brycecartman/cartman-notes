package com.example.assignment1;

import java.util.ArrayList;

import android.R.layout;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;

public class ViewCountersActivity extends Activity implements OnClickListener{
	int total = 30; // Right Margin
	Button[] b = new Button[50];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_counters);
		
		// Show the Up button in the action bar.
		setupActionBar();
		
		LinearLayout viewCounters = (LinearLayout)findViewById(R.id.viewCounters);
		ScrollView scrollCounters = new ScrollView(ViewCountersActivity.this);
		LinearLayout viewCounters2 = new LinearLayout(ViewCountersActivity.this);
		
		viewCounters2.setOrientation(LinearLayout.VERTICAL);
		
		// Lists the data from the clickerNames.
		SharedPreferences clickerData;
		clickerData = getSharedPreferences("clickerData", MODE_WORLD_READABLE);
		String clickerName = clickerData.getString("MYVALUE", "");
				
		
		// Basic loop that goes until there are no more counters.
		// It will set up the button and add it into the layout.

		for(int i = 0; i < counterFunctions.counters.size(); i++){
			b[i] = new Button(this);
			b[i].setOnClickListener(this);
			b[i].setId(i);
			LinearLayout.LayoutParams viewCounterParams = new LinearLayout.LayoutParams((int)LayoutParams.MATCH_PARENT, (int)LayoutParams.MATCH_PARENT);
			viewCounterParams.leftMargin = 20; // Margin from the left side.
			viewCounterParams.rightMargin = 100; // Margin from the right side.
			counterFunctions.setCounter(i);
			b[i].setText(counterFunctions.getCurrentName()); // The button will be the clicker name.
			b[i].setLayoutParams(viewCounterParams); // Gives the parameters to the button.
			viewCounters2.addView(b[i]); // Adds the button onto the layout.
		}
		
		scrollCounters.addView(viewCounters2); // Adds the buttons to scroll.
		viewCounters.addView(scrollCounters); // Puts the scroll w/ buttons onto screen.
		
		
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
		getMenuInflater().inflate(R.menu.view_counters, menu);
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

	@Override
	public void onClick(View view) {
		for(int i = 0; i < counterFunctions.counters.size(); i++){
			if(view.getId() == i){
				Intent intent = new Intent(this, CounterActivity.class);
				intent.putExtra("arrayValue", i);
				startActivity(intent);
			}
				
		}
		
	}



}
