package com.example.assignment1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class HourlyStats extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hourly_stats);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hourly_stats, menu);
		return true;
	}

}
