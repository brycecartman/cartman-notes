package com.example.assignment1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class RenameActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rename);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.rename, menu);
		return true;
	}
	
	public void rename(View view) {
       Intent intent = new Intent(this, ViewCountersActivity.class);
       EditText editText = (EditText)findViewById(R.id.renameCounter_message);    

        
        // Gets the name of the counter and sends it to the CounterActivity.java activity.
        String message = editText.getText().toString();

        CounterFunctions.setName(message);
        	
		startActivity(intent);
	}

}
