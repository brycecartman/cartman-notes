package com.example.assignment1;

import android.os.Bundle;
import android.app.Activity;
import android.util.TypedValue;
import android.view.Menu;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

// This class displays the week/month/count values onto the screen.

public class WeeklyStats extends Activity {
	
	// Array of 5 weekly statistics.
	TextView[][] weeklyStatsText = new TextView[5][12];
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_weekly_stats);
		
		LinearLayout viewWeeklyStats = (LinearLayout)findViewById(R.id.weeklyStats);
		ScrollView scrollWeeklyStats = new ScrollView(WeeklyStats.this);
		LinearLayout viewWeeklyStats2 = new LinearLayout(WeeklyStats.this);
	
		viewWeeklyStats2.setOrientation(LinearLayout.VERTICAL);		
		int weeklyData[][] = CounterFunctions.getWeeklyStats();
		LinearLayout.LayoutParams viewWeeklyParams = new LinearLayout.LayoutParams((int)LayoutParams.MATCH_PARENT, (int)LayoutParams.MATCH_PARENT);
		
		// Basic loop that goes until there are no more text to display.
		// It will set up the text and add it into the layout.
		for(int i = 0; i < 12; i++){
			for(int w = 0; w < 5; w++){
				
				if(weeklyData[w][i] != 0){
				weeklyStatsText[w][i] = new TextView(this);
				weeklyStatsText[w][i].setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
				}
				
				if(weeklyData[w][i] != 0){
					if(w == 0){
						if(i == 0)
							weeklyStatsText[w][i].setText("Week 1 of Jan -- " + weeklyData[0][0]);
						if(i == 1)
							weeklyStatsText[w][i].setText("Week 1 of Feb --  " + weeklyData[0][1]);
						if(i == 2)
							weeklyStatsText[w][i].setText("Week 1 of Mar --  " + weeklyData[0][2]);
						if(i == 3)
							weeklyStatsText[w][i].setText("Week 1 of Apr --  " + weeklyData[0][3]);
						if(i == 4)
							weeklyStatsText[w][i].setText("Week 1 of May --  " + weeklyData[0][4]);
						if(i == 5)
							weeklyStatsText[w][i].setText("Week 1 of Jun --  " + weeklyData[0][5]);
						if(i == 6)
							weeklyStatsText[w][i].setText("Week 1 of Aul --  " + weeklyData[0][6]);
						if(i == 7)
							weeklyStatsText[w][i].setText("Week 1 of Aug --  " + weeklyData[0][7]);
						if(i == 8)
							weeklyStatsText[w][i].setText("Week 1 of Sep --  " + weeklyData[0][8]);
						if(i == 9)
							weeklyStatsText[w][i].setText("Week 1 of Oct --  " + weeklyData[0][9]);
						if(i == 10)
							weeklyStatsText[w][i].setText("Week 1 of Nov --  " + weeklyData[0][10]);
						if(i == 11)
							weeklyStatsText[w][i].setText("Week 1 of Dec --  " + weeklyData[0][11]);
					}
					if(w == 1){
						if(i == 0)
							weeklyStatsText[w][i].setText("Week 2 of Jan --  " + weeklyData[1][0]);
						if(i == 1)
							weeklyStatsText[w][i].setText("Week 2 of Feb --  " + weeklyData[1][1]);
						if(i == 2)
							weeklyStatsText[w][i].setText("Week 2 of Mar --  " + weeklyData[1][2]);
						if(i == 3)
							weeklyStatsText[w][i].setText("Week 2 of Apr --  " + weeklyData[1][3]);
						if(i == 4)
							weeklyStatsText[w][i].setText("Week 2 of May --  " + weeklyData[1][4]);
						if(i == 5)
							weeklyStatsText[w][i].setText("Week 2 of Jun --  " + weeklyData[1][5]);
						if(i == 6)
							weeklyStatsText[w][i].setText("Week 2 of Aul --  " + weeklyData[1][6]);
						if(i == 7)
							weeklyStatsText[w][i].setText("Week 2 of Aug --  " + weeklyData[1][7]);
						if(i == 8)
							weeklyStatsText[w][i].setText("Week 2 of Sep --  " + weeklyData[1][8]);
						if(i == 9)
							weeklyStatsText[w][i].setText("Week 2 of Oct --  " + weeklyData[1][9]);
						if(i == 10)
							weeklyStatsText[w][i].setText("Week 2 of Nov --  " + weeklyData[1][10]);
						if(i == 11)
							weeklyStatsText[w][i].setText("Week 2 of Dec --  " + weeklyData[1][11]);
					}
					if(w == 2){
						if(i == 0)
							weeklyStatsText[w][i].setText("Week 3 of Jan --  " + weeklyData[2][0]);
						if(i == 1)
							weeklyStatsText[w][i].setText("Week 3 of Feb --  " + weeklyData[2][1]);
						if(i == 2)
							weeklyStatsText[w][i].setText("Week 3 of Mar --  " + weeklyData[2][2]);
						if(i == 3)
							weeklyStatsText[w][i].setText("Week 3 of Apr --  " + weeklyData[2][3]);
						if(i == 4)
							weeklyStatsText[w][i].setText("Week 3 of May --  " + weeklyData[2][4]);
						if(i == 5)
							weeklyStatsText[w][i].setText("Week 3 of Jun --  " + weeklyData[2][5]);
						if(i == 6)
							weeklyStatsText[w][i].setText("Week 3 of Jul --  " + weeklyData[2][6]);
						if(i == 7)
							weeklyStatsText[w][i].setText("Week 3 of Aug --  " + weeklyData[2][7]);
						if(i == 8)
							weeklyStatsText[w][i].setText("Week 3 of Sep --  " + weeklyData[2][8]);
						if(i == 9)
							weeklyStatsText[w][i].setText("Week 3 of Oct --  " + weeklyData[2][9]);
						if(i == 10)
							weeklyStatsText[w][i].setText("Week 3 of Nov --  " + weeklyData[2][10]);
						if(i == 11)
							weeklyStatsText[w][i].setText("Week 3 of Dec --  " + weeklyData[2][11]);
					}
					if(w == 3){
						if(i == 0)
							weeklyStatsText[w][i].setText("Week 4 of Jan --  " + weeklyData[3][0]);
						if(i == 1)
							weeklyStatsText[w][i].setText("Week 4 of Feb --  " + weeklyData[3][1]);
						if(i == 2)
							weeklyStatsText[w][i].setText("Week 4 of Mar --  " + weeklyData[3][2]);
						if(i == 3)
							weeklyStatsText[w][i].setText("Week 4 of Apr --  " + weeklyData[3][3]);
						if(i == 4)
							weeklyStatsText[w][i].setText("Week 4 of May --  " + weeklyData[3][4]);
						if(i == 5)
							weeklyStatsText[w][i].setText("Week 4 of Jun --  " + weeklyData[3][5]);
						if(i == 6)
							weeklyStatsText[w][i].setText("Week 4 of Jul --  " + weeklyData[3][6]);
						if(i == 7)
							weeklyStatsText[w][i].setText("Week 4 of Aug --  " + weeklyData[3][7]);
						if(i == 8)
							weeklyStatsText[w][i].setText("Week 4 of Sep --  " + weeklyData[3][8]);
						if(i == 9)
							weeklyStatsText[w][i].setText("Week 4 of Oct --  " + weeklyData[3][9]);
						if(i == 10)
							weeklyStatsText[w][i].setText("Week 4 of Nov --  " + weeklyData[3][10]);
						if(i == 11)
							weeklyStatsText[w][i].setText("Week 4 of Dec --  " + weeklyData[3][11]);
					}
					if(w == 4){
						if(i == 0)
							weeklyStatsText[w][i].setText("Week 5 of Jan --  " + weeklyData[4][0]);
						if(i == 1)
							weeklyStatsText[w][i].setText("Week 5 of Feb --  " + weeklyData[4][1]);
						if(i == 2)
							weeklyStatsText[w][i].setText("Week 5 of Mar --  " + weeklyData[4][2]);
						if(i == 3)
							weeklyStatsText[w][i].setText("Week 5 of Apr --  " + weeklyData[4][3]);
						if(i == 4)
							weeklyStatsText[w][i].setText("Week 5 of May --  " + weeklyData[4][4]);
						if(i == 5)
							weeklyStatsText[w][i].setText("Week 5 of Jun --  " + weeklyData[4][5]);
						if(i == 6)
							weeklyStatsText[w][i].setText("Week 5 of Jul --  " + weeklyData[4][6]);
						if(i == 7)
							weeklyStatsText[w][i].setText("Week 5 of Aug --  " + weeklyData[4][7]);
						if(i == 8)
							weeklyStatsText[w][i].setText("Week 5 of Sep --  " + weeklyData[4][8]);
						if(i == 9)
							weeklyStatsText[w][i].setText("Week 5 of Oct --  " + weeklyData[4][9]);
						if(i == 10)
							weeklyStatsText[w][i].setText("Week 5 of Nov --  " + weeklyData[4][10]);
						if(i == 11)
							weeklyStatsText[w][i].setText("Week 5 of Dec --  " + weeklyData[4][11]);
					}
				}
				if(weeklyData[w][i] != 0){
				weeklyStatsText[w][i].setLayoutParams(viewWeeklyParams); // Gives the parameters to the text.
				viewWeeklyStats2.addView(weeklyStatsText[w][i]); // Adds the text onto the layout.
				}
		    }
		}
		
		scrollWeeklyStats.addView(viewWeeklyStats2); // Adds the text to scroll.
		viewWeeklyStats.addView(scrollWeeklyStats); // Puts the scroll w/ text onto screen.	
		CounterFunctions.saveCounters(getBaseContext()); // Save File
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.weekly_stats, menu);
		return true;
	}

}
