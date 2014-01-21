package com.example.assignment1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

// This class controls the 4 stats buttons.

public class StatsMain extends Activity implements OnClickListener {
	Button hourlyStatsBtn; // The button that goes to HourlyStats.
	Button monthlyStatsBtn; // The button that goes to MonthlyStats.
	Button weeklyStatsBtn; // The button that goes to WeeklyStats.
	Button dailyStatsBtn; // The button that goes to DailyStats.
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stats_main);
		
		// Assigns the buttons and text box their proper item via ID.
		hourlyStatsBtn = (Button)findViewById(R.id.hourStats);
		monthlyStatsBtn = (Button)findViewById(R.id.monthStats);
		weeklyStatsBtn = (Button)findViewById(R.id.weekStats);
		dailyStatsBtn = (Button)findViewById(R.id.dayStats);
		
		// Allows the buttons to be checked for a click event.
		hourlyStatsBtn.setOnClickListener(this);
		monthlyStatsBtn.setOnClickListener(this);
		weeklyStatsBtn.setOnClickListener(this);
		dailyStatsBtn.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.stats_main, menu);
		return true;
	}
	
	
	// If a button is clicked, react.
	public void onClick(View v){
	
	if (v == hourlyStatsBtn){
		Intent intent = new Intent(this, HourlyStats.class);
		startActivity(intent);
	}
	if (v == monthlyStatsBtn){
		Intent intent = new Intent(this, MonthlyStats.class);
		startActivity(intent);
	}
	if (v == weeklyStatsBtn){
		Intent intent = new Intent(this, WeeklyStats.class);
		startActivity(intent);
	}
	if (v == dailyStatsBtn){
		Intent intent = new Intent(this, DailyStats.class);
		startActivity(intent);
	}
		
	}

}
