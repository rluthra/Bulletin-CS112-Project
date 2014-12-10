package com.yale.bulletin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.view.View;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.parse.*;

public class HealthDataProvider extends Activity {

	public static List<List<String>> getHealthInfo(String citytosearch)
	{
		final ArrayList<List<String>> HealthEventsDetails = new ArrayList<List<String>>();
		
		ParseQuery<ParseObject> healthEvents = ParseQuery.getQuery("Event");
			
		healthEvents.whereEqualTo("category", "health professions");
		healthEvents.whereEqualTo("city", citytosearch);
		healthEvents.orderByAscending("date");
		healthEvents.addAscendingOrder("time");
		healthEvents.setLimit(20);
			try {
				List<ParseObject> healthEventList = healthEvents.find();
				int numberevents = healthEventList.size();
		    	for (int i = 0; i < numberevents; i++) {
		    		String eventnum = Integer.toString(i);
		    		List<String> healthEvent = new ArrayList<String>();
		    		ParseObject event = healthEventList.get(i);
		    		healthEvent.add(event.getString("name"));
		    		healthEvent.add(event.getString("host"));
		    		healthEvent.add(event.getString("description"));
		    		healthEvent.add(event.getString("time"));
		    		healthEvent.add(event.getString("date"));
		    		healthEvent.add(event.getString("location"));
		    		HealthEventsDetails.add(healthEvent);
		    	}
			} catch (ParseException e) {
				e.printStackTrace();
				throw new RuntimeException (e);
			}
		
		return HealthEventsDetails;
		
	}
	
	
}


