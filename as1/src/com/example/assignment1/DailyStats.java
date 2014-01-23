package com.example.assignment1;

import android.os.Bundle;
import android.app.Activity;
import android.util.TypedValue;
import android.view.Menu;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class DailyStats extends Activity {

	// Array of 12 months and 31 days.
	/**
	 * @uml.property  name="dailyStatsText" multiplicity="(0 -1)" dimension="2"
	 */
	TextView[][] DailyStatsText = new TextView[12][32];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_daily_stats);
		
		LinearLayout viewDailyStats = (LinearLayout)findViewById(R.id.dailyStats);
		ScrollView scrollDailyStats = new ScrollView(DailyStats.this);
		LinearLayout viewDailyStats2 = new LinearLayout(DailyStats.this);
	
		viewDailyStats2.setOrientation(LinearLayout.VERTICAL);		
		int dailyData[][] = CounterFunctions.getDailyStats();
		LinearLayout.LayoutParams viewDailyParams = new LinearLayout.LayoutParams((int)LayoutParams.MATCH_PARENT, (int)LayoutParams.MATCH_PARENT);
		
		// Basic loop that goes until there are no more text to display.
		// It will set up the text and add it into the layout.
		for(int i = 0; i < 12; i++){
			for(int x = 1; x < 32; x++){
				
			if(dailyData[i][x] != 0){
			DailyStatsText[i][x] = new TextView(this);
			DailyStatsText[i][x].setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
			}
			
			if(dailyData[i][x] != 0){
				if(i == 0)
					DailyStatsText[i][x].setText("Jan " + x + " -- " + dailyData[i][x]);
				if(i == 1)
					DailyStatsText[i][x].setText("Feb " + x + " -- " + dailyData[i][x]);
				if(i == 2)
					DailyStatsText[i][x].setText("Mar " + x + " -- " + dailyData[i][x]);
				if(i == 3)
					DailyStatsText[i][x].setText("Apr " + x + " -- " + dailyData[i][x]);
				if(i == 4)
					DailyStatsText[i][x].setText("May " + x + " -- " + dailyData[i][x]);
				if(i == 5)
					DailyStatsText[i][x].setText("Jun " + x + " -- " + dailyData[i][x]);
				if(i == 6)
					DailyStatsText[i][x].setText("Jul " + x + " -- " + dailyData[i][x]);
				if(i == 7)
					DailyStatsText[i][x].setText("Aug " + x + " -- " + dailyData[i][x]);
				if(i == 8)
					DailyStatsText[i][x].setText("Sep " + x + " -- " + dailyData[i][x]);
				if(i == 9)
					DailyStatsText[i][x].setText("Oct " + x + " -- " + dailyData[i][x]);
				if(i == 10)
					DailyStatsText[i][x].setText("Nov " + x + " -- " + dailyData[i][x]);
				if(i == 11)
					DailyStatsText[i][x].setText("Dec " + x + " -- " + dailyData[i][x]);
			}
			
			if(dailyData[i][x] != 0){
			DailyStatsText[i][x].setLayoutParams(viewDailyParams); // Gives the parameters to the text.
			viewDailyStats2.addView(DailyStatsText[i][x]); // Adds the text onto the layout.
				}
		    }
		}
		scrollDailyStats.addView(viewDailyStats2); // Adds the text to scroll.
		viewDailyStats.addView(scrollDailyStats); // Puts the scroll w/ text onto screen.	
		CounterFunctions.saveCounters(getBaseContext()); // Save File
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.daily_stats, menu);
		return true;
	}

}
