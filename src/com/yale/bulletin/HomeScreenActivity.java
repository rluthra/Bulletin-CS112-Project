package com.yale.bulletin;


import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class HomeScreenActivity extends ActionBarActivity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_screen);
		
		Button createevent = (Button) findViewById(R.id.createevent);
    	createevent.setOnClickListener(new View.OnClickListener() {

    		public void onClick(View v) {
    	        createeventClick(v);
    	    }
    	});
    	
    	Button signout = (Button) findViewById(R.id.signout);
    	signout.setOnClickListener(new View.OnClickListener() {

    		public void onClick(View v) {
    	        signoutClick(v);
    	    }
    	});
    	
    	Button choosebusiness = (Button) findViewById(R.id.choosebusiness);
    	choosebusiness.setOnClickListener(new View.OnClickListener() {

    		public void onClick(View v) {
    			choosebusinessClick(v);
    	    }
    	});
    	
    	Button choosehealth = (Button) findViewById(R.id.choosehealth);
    	choosehealth.setOnClickListener(new View.OnClickListener() {

    		public void onClick(View v) {
    			choosehealthClick(v);
    	    }
    	});
    	
    	Button choosetechnology = (Button) findViewById(R.id.choosetechnology);
    	choosetechnology.setOnClickListener(new View.OnClickListener() {

    		public void onClick(View v) {
    			choosetechnologyClick(v);
    	    }
    	});
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_screen, menu);
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
	
	public void createeventClick(View v) {
    	Intent intent = new Intent(this, CreatePostActivity.class);
    	startActivity(intent);
    }
	
	public void signoutClick(View v) {
    	Intent intent = new Intent(this, MainActivity.class);
    	startActivity(intent);
    }
	
	public void choosebusinessClick(View v) {
    	Intent intent = new Intent(this, BusinessActivity.class);
    	EditText chosencity = (EditText)findViewById(R.id.choosecityvalue);
		String eventcity = chosencity.getText().toString();
		intent.putExtra("CITY", eventcity);
    	startActivity(intent);
    }
	
	public void choosehealthClick(View v) {
    	Intent intent = new Intent(this, HealthActivity.class);
    	EditText chosencity = (EditText)findViewById(R.id.choosecityvalue);
		String eventcity = chosencity.getText().toString();
		intent.putExtra("CITY", eventcity);
    	startActivity(intent);
    }
	
	public void choosetechnologyClick(View v) {
    	Intent intent = new Intent(this, TechnologyActivity.class);
    	EditText chosencity = (EditText)findViewById(R.id.choosecityvalue);
		String eventcity = chosencity.getText().toString();
		intent.putExtra("CITY", eventcity);
    	startActivity(intent);
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
}
