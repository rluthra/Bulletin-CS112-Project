package com.yale.bulletin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.parse.*;

public class BusinessDataProvider extends Activity {

	public static List<List<String>> getBusinessInfo(String citytosearch)
	{
		final ArrayList<List<String>> BusinessEventsDetails = new ArrayList<List<String>>();
		
		ParseQuery<ParseObject> busEvents = ParseQuery.getQuery("Event");
			
			busEvents.whereEqualTo("category", "business & finance");
			busEvents.whereEqualTo("city", citytosearch);
			busEvents.orderByAscending("date");
			busEvents.addAscendingOrder("time");
			busEvents.setLimit(20);
			try {
					List<ParseObject> busEventList = busEvents.find();
					int numberevents = busEventList.size();
					for (int i = 0; i < numberevents; i++) {
						String eventnum = Integer.toString(i);
						List<String> busEvent = new ArrayList<String>();
						ParseObject event = busEventList.get(i);
							busEvent.add(event.getString("name"));
							busEvent.add("host:\n" + event.getString("host"));
							busEvent.add("description:\n" + event.getString("description"));
							busEvent.add("time:\n" + event.getString("time"));
							busEvent.add("date:\n" + event.getString("date"));
							busEvent.add("location:\n" + event.getString("location"));
							BusinessEventsDetails.add(busEvent);
					}
			}catch (ParseException e) {
				e.printStackTrace();
				throw new RuntimeException (e);
			}
			
		
		return BusinessEventsDetails;
		
	}
	
	
}

