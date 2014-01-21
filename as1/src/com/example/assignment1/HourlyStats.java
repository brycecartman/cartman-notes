package com.example.assignment1;

import android.os.Bundle;
import android.app.Activity;
import android.util.TypedValue;
import android.view.Menu;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class HourlyStats extends Activity {

	// Array of 500 hour statistics.
	TextView[] HourlyStatsText = new TextView[100];
			
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hourly_stats);
		
		LinearLayout viewHourlyStats = (LinearLayout)findViewById(R.id.hourlyStats);
		ScrollView scrollHourlyStats = new ScrollView(HourlyStats.this);
		LinearLayout viewHourlyStats2 = new LinearLayout(HourlyStats.this);
		
		viewHourlyStats2.setOrientation(LinearLayout.VERTICAL);		
		
		
		// Basic loop that goes until there are no more text to display.
		// It will set up the text and add it into the layout.
		for(int i = 0; i < 100; i++){
			HourlyStatsText[i] = new TextView(this);
			HourlyStatsText[i].setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
			LinearLayout.LayoutParams viewHourlyParams = new LinearLayout.LayoutParams((int)LayoutParams.MATCH_PARENT, (int)LayoutParams.MATCH_PARENT);
			//viewHourlyParams.leftMargin = 20; // Margin from the left side.
			//viewHourlyParams.rightMargin = 100; // Margin from the right side.
			HourlyStatsText[i].setText("hi"); // The text will be the statistic.
			HourlyStatsText[i].setLayoutParams(viewHourlyParams); // Gives the parameters to the text.
			viewHourlyStats2.addView(HourlyStatsText[i]); // Adds the text onto the layout.
		    }
		
		scrollHourlyStats.addView(viewHourlyStats2); // Adds the text to scroll.
		viewHourlyStats.addView(scrollHourlyStats); // Puts the scroll w/ text onto screen.	
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hourly_stats, menu);
		return true;
	}
	

}
