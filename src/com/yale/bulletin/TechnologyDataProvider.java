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

public class TechnologyDataProvider extends Activity {

	public static List<List<String>> getTechnologyInfo(String citytosearch)
	{
		final ArrayList<List<String>> TechnologyEventsDetails = new ArrayList<List<String>>();
		
		ParseQuery<ParseObject> techEvents = ParseQuery.getQuery("Event");
			
			techEvents.whereEqualTo("category", "technology & design");
			techEvents.whereEqualTo("city", citytosearch);
			techEvents.orderByAscending("date");
			techEvents.addAscendingOrder("time");
			techEvents.setLimit(20);
			try {
				List<ParseObject> techEventList = techEvents.find();
				int numberevents = techEventList.size();
		    	for (int i = 0; i < numberevents; i++) {
		    		String eventnum = Integer.toString(i);
		    		List<String> techEvent = new ArrayList<String>();
		    		ParseObject event = techEventList.get(i);
		    			techEvent.add(event.getString("name"));
		    			techEvent.add(event.getString("host"));
		    			techEvent.add(event.getString("description"));
		    			techEvent.add(event.getString("time"));
		    			techEvent.add(event.getString("date"));
		    			techEvent.add(event.getString("location"));
		    		TechnologyEventsDetails.add(techEvent);
		    	}
			} catch (ParseException e) {
				e.printStackTrace();
				throw new RuntimeException (e);
			}
		
		return TechnologyEventsDetails;
		
	}
	
	
}


