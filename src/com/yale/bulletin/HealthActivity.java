package com.yale.bulletin;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HealthActivity extends ActionBarActivity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_health);
		
		
		Button healthback = (Button) findViewById(R.id.healthback);
		healthback.setOnClickListener(new View.OnClickListener() {

    	    public void onClick(View v) {
    	    	healthbackClick(v);
    	    }
    	});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.health, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void healthbackClick(View v) {
    	Intent intent = new Intent(this, HomeScreenActivity.class);
    	startActivity(intent);
    }
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
}
