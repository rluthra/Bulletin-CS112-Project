package com.yale.bulletin;

import com.parse.ParseObject;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class CreatePostActivity extends ActionBarActivity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_post);
		
		
		RadioGroup categoryradio = (RadioGroup) findViewById(R.id.categoryradiogroup);
		Button postevent = (Button) findViewById(R.id.postevent);
		
		postevent.setOnClickListener(new View.OnClickListener() {
    	    public void onClick(View v) {    
    	    	sendEventToParseClick(v);
    	    	posteventClick(v);
    	    }
    	});
    	
    	Button cancelcreatepost = (Button) findViewById(R.id.cancelcreatepost);
    	cancelcreatepost.setOnClickListener(new View.OnClickListener() {
    	    public void onClick(View v) {
    	        posteventClick(v);
    	    }
    	});
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create_post, menu);
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
	
	public void sendEventToParseClick(View view) {
		ParseObject event = new ParseObject("Event");
		EditText name = (EditText)findViewById(R.id.eventtitlevalue);
		String eventname = name.getText().toString();
		event.put("name", eventname);
		EditText host = (EditText)findViewById(R.id.eventhostvalue);
		String eventhost = host.getText().toString();
		event.put("host", eventhost);
		EditText description = (EditText)findViewById(R.id.eventdescriptionvalue);
		String eventdescription = description.getText().toString();
		event.put("description", eventdescription);
		EditText date = (EditText)findViewById(R.id.eventdatevalue);
		String eventdate = date.getText().toString();
		event.put("date", eventdate);
		EditText time = (EditText)findViewById(R.id.eventtimevalue);
		String eventtime = time.getText().toString();
		event.put("time", eventtime);
		EditText location = (EditText)findViewById(R.id.eventlocationvalue);
		String eventlocation = location.getText().toString();
		event.put("location", eventlocation);
		EditText city = (EditText)findViewById(R.id.eventcityvalue);
		String eventcity = city.getText().toString();
		event.put("city", eventcity);
		RadioGroup categoryradiogroup = (RadioGroup) findViewById(R.id.categoryradiogroup);
		int selected = categoryradiogroup.getCheckedRadioButtonId();
		if (selected == -1){
			event.put("category", "uncategorized");
		} else {
			RadioButton cat = (RadioButton) findViewById(selected);
			String category = (String) cat.getText();
			event.put("category", category);
		}
		event.saveInBackground();
	}
	
	public void eventCategoryClick(RadioGroup group, int checkedId) {
		
	}

	public void posteventClick(View v) {
    	Intent intent = new Intent(this, HomeScreenActivity.class);
    	startActivity(intent);
    }
	
	public void cancelcreatepostClick(View v) {
    	Intent intent = new Intent(this, HomeScreenActivity.class);
    	startActivity(intent);
    }
    
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
}
