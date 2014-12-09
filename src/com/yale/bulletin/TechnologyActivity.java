package com.yale.bulletin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.yale.bulletin.TechnologyDataProvider;
import com.yale.bulletin.TechnologyEventsAdapter;
import com.yale.bulletin.R;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ExpandableListView;

public class TechnologyActivity extends Activity implements OnClickListener {
	HashMap<String, List<String>> Technology_event_name;
	List<String> Technology_event_details;
	ExpandableListView Exp_list_technology;
	TechnologyEventsAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_technology);
		
		Exp_list_technology = (ExpandableListView) findViewById(R.id.exp_list_technology);
        Technology_event_name = TechnologyDataProvider.getTechnologyInfo();
        Technology_event_details = new ArrayList<String>(Technology_event_name.keySet());
        adapter = new TechnologyEventsAdapter(this, Technology_event_name, Technology_event_details);
        Exp_list_technology.setAdapter(adapter);
		
		Button technologyback = (Button) findViewById(R.id.technologyback);
		technologyback.setOnClickListener(new View.OnClickListener() {

    	    public void onClick(View v) {
    	    	technologybackClick(v);
    	    }
    	});
		
	}

	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.technology, menu);
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
	
	public void technologybackClick(View v) {
    	Intent intent = new Intent(this, HomeScreenActivity.class);
    	startActivity(intent);
    }

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
}
