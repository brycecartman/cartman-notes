package com.example.assignment1;

import android.os.Bundle;
import android.app.Activity;
import android.util.TypedValue;
import android.view.Menu;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

// This class displays the month/count data onto the screen.

public class MonthlyStats extends Activity {

	// Array of 12 monthly statistics.
	/**
	 * @uml.property  name="monthlyStatsText"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
	TextView[] MonthlyStatsText = new TextView[12];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_monthly_stats);
		
		LinearLayout viewMonthlyStats = (LinearLayout)findViewById(R.id.monthlyStats);
		ScrollView scrollMonthlyStats = new ScrollView(MonthlyStats.this);
		LinearLayout viewMonthlyStats2 = new LinearLayout(MonthlyStats.this);
	
		viewMonthlyStats2.setOrientation(LinearLayout.VERTICAL);		
		int monthlyData[] = CounterFunctions.getMonthlyStats();
		LinearLayout.LayoutParams viewMonthlyParams = new LinearLayout.LayoutParams((int)LayoutParams.MATCH_PARENT, (int)LayoutParams.MATCH_PARENT);
		
		// Basic loop that goes until there are no more text to display.
		// It will set up the text and add it into the layout.
		for(int i = 0; i < 12; i++){
			
			if(monthlyData[i] != 0){
			MonthlyStatsText[i] = new TextView(this);
			MonthlyStatsText[i].setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
			}
			
			if(monthlyData[i] != 0){
				if(i == 0)
				MonthlyStatsText[i].setText("Month of Jan -- " + monthlyData[0]);
				if(i == 1)
				MonthlyStatsText[i].setText("Month of Feb -- " + monthlyData[1]);
				if(i == 2)
				MonthlyStatsText[i].setText("Month of Mar -- " + monthlyData[2]);
				if(i == 3)
				MonthlyStatsText[i].setText("Month of Apr -- " + monthlyData[3]);
				if(i == 4)
				MonthlyStatsText[i].setText("Month of May -- " + monthlyData[4]);
				if(i == 5)
				MonthlyStatsText[i].setText("Month of Jun -- " + monthlyData[5]);
				if(i == 6)
				MonthlyStatsText[i].setText("Month of Jul -- " + monthlyData[6]);
				if(i == 7)
				MonthlyStatsText[i].setText("Month of Aug -- " + monthlyData[7]);
				if(i == 8)
				MonthlyStatsText[i].setText("Month of Sep -- " + monthlyData[8]);
				if(i == 9)
				MonthlyStatsText[i].setText("Month of Oct -- " + monthlyData[9]);
				if(i == 10)
				MonthlyStatsText[i].setText("Month of Nov -- " + monthlyData[10]);
				if(i == 11)
				MonthlyStatsText[i].setText("Month of Dec -- " + monthlyData[11]);
			}
			if(monthlyData[i] != 0){
			MonthlyStatsText[i].setLayoutParams(viewMonthlyParams); // Gives the parameters to the text.
			viewMonthlyStats2.addView(MonthlyStatsText[i]); // Adds the text onto the layout.
			}
		    }
		
		scrollMonthlyStats.addView(viewMonthlyStats2); // Adds the text to scroll.
		viewMonthlyStats.addView(scrollMonthlyStats); // Puts the scroll w/ text onto screen.	
		CounterFunctions.saveCounters(getBaseContext()); // Save File
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.monthly_stats, menu);
		return true;
	}

}
