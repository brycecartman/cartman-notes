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

	// Array of hourly statistics.
	TextView[][][] HourlyStatsText = new TextView[12][32][25];
			
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hourly_stats);
		
		LinearLayout viewHourlyStats = (LinearLayout)findViewById(R.id.hourlyStats);
		ScrollView scrollHourlyStats = new ScrollView(HourlyStats.this);
		LinearLayout viewHourlyStats2 = new LinearLayout(HourlyStats.this);
		
		viewHourlyStats2.setOrientation(LinearLayout.VERTICAL);		
		
		int hourlyData[][][] = CounterFunctions.getHourlyStats();
		LinearLayout.LayoutParams viewHourlyParams = new LinearLayout.LayoutParams((int)LayoutParams.MATCH_PARENT, (int)LayoutParams.MATCH_PARENT);
		
		// Basic loop that goes until there are no more text to display.
		// It will set up the text and add it into the layout.
		for(int i = 0; i < 12; i++){
			for(int x = 1; x < 32; x++){
				for(int c = 1; c < 25; c++){
						
					if(hourlyData[i][x][c] != 0){
					HourlyStatsText[i][x][c] = new TextView(this);
					HourlyStatsText[i][x][c].setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
					}
					
				if(hourlyData[i][x][c] != 0){
					
					if(i == 0)
						HourlyStatsText[i][x][c].setText("Jan " + x + " " + c + " -- " + hourlyData[i][x][c]);
					if(i == 1)
						HourlyStatsText[i][x][c].setText("Feb " + x + " " + c + " -- " + hourlyData[i][x][c]);
					if(i == 2)
						HourlyStatsText[i][x][c].setText("Mar " + x + " " + c + " -- " + hourlyData[i][x][c]);
					if(i == 3)
						HourlyStatsText[i][x][c].setText("Apr " + x + " " + c + " -- " + hourlyData[i][x][c]);
					if(i == 4)
						HourlyStatsText[i][x][c].setText("May " + x + " " + c + " -- " + hourlyData[i][x][c]);
					if(i == 5)
						HourlyStatsText[i][x][c].setText("Jun " + x + " " + c + " -- " + hourlyData[i][x][c]);
					if(i == 6)
						HourlyStatsText[i][x][c].setText("Jul " + x + " " + c + " -- " + hourlyData[i][x][c]);
					if(i == 7)
						HourlyStatsText[i][x][c].setText("Aug " + x + " " + c + " -- " + hourlyData[i][x][c]);
					if(i == 8)
						HourlyStatsText[i][x][c].setText("Sep " + x + " " + c + " -- " + hourlyData[i][x][c]);
					if(i == 9)
						HourlyStatsText[i][x][c].setText("Oct " + x + " " + c + " -- " + hourlyData[i][x][c]);
					if(i == 10)
						HourlyStatsText[i][x][c].setText("Nov " + x + " " + c + " -- " + hourlyData[i][x][c]);
					if(i == 11)
						HourlyStatsText[i][x][c].setText("Dec " + x + " " + c + " -- " + hourlyData[i][x][c]);
					}
					
				if(hourlyData[i][x][c] != 0){
				HourlyStatsText[i][x][c].setLayoutParams(viewHourlyParams); // Gives the parameters to the text.
				viewHourlyStats2.addView(HourlyStatsText[i][x][c]); // Adds the text onto the layout.
					}
				}
			}
		}
	scrollHourlyStats.addView(viewHourlyStats2); // Adds the text to scroll.
	viewHourlyStats.addView(scrollHourlyStats); // Puts the scroll w/ text onto screen.	
	CounterFunctions.saveCounters(getBaseContext()); // Save File
}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hourly_stats, menu);
		return true;
	}
	

}
