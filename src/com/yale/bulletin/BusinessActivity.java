package com.yale.bulletin;

import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;

public class BusinessActivity extends ActionBarActivity implements OnClickListener {

	List<List<String>> Business_event_name;
	List<String> Business_event_details;
	ExpandableListView Exp_list_business;
	BusinessEventsAdapter adapter;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_business);
		
		Bundle extras = getIntent().getExtras();
		String value = "";
		if(extras != null){
			value = extras.getString("CITY");
			//new AlertDialog.Builder(this)
			//.setTitle(value)
			//.show();
		}
		
		Exp_list_business = (ExpandableListView) findViewById(R.id.exp_list_business);
        Business_event_name = BusinessDataProvider.getBusinessInfo(value);
        adapter = new BusinessEventsAdapter(this, Business_event_name);
        Exp_list_business.setAdapter(adapter);

		
		Button businessback = (Button) findViewById(R.id.businessback);
		businessback.setOnClickListener(new View.OnClickListener() {

    	    public void onClick(View v) {
    	    	businessbackClick(v);
    	    }
    	});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.business, menu);
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

	public void businessbackClick(View v) {
    	Intent intent = new Intent(this, HomeScreenActivity.class);
    	startActivity(intent);
    }
	
	@Override
	public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub
		
	}
}
