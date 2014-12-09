package com.yale.bulletin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TechnologyDataProvider {

	public static HashMap<String, List<String>> getTechnologyInfo()
	{
		HashMap<String, List<String>> TechnologyEventsDetails = new HashMap<String, List<String>>();
		
		List<String> TechnologyEvent1 = new ArrayList<String>();
		TechnologyEvent1.add("Event1 date");
		TechnologyEvent1.add("Event1 time");
		TechnologyEvent1.add("Event1 description");
		TechnologyEvent1.add("Event1 host");
		TechnologyEvent1.add("Event1 location");
		
		List<String> TechnologyEvent2 = new ArrayList<String>();
		TechnologyEvent2.add("Event2 date");
		TechnologyEvent2.add("Event2 time");
		TechnologyEvent2.add("Event2 description");
		TechnologyEvent2.add("Event2 host");
		TechnologyEvent2.add("Event2 location");
		
		List<String> TechnologyEvent3= new ArrayList<String>();
		TechnologyEvent3.add("Event3 date");
		TechnologyEvent3.add("Event3 time");
		TechnologyEvent3.add("Event3 description");
		TechnologyEvent3.add("Event3 host");
		TechnologyEvent3.add("Event3 location");
		
		List<String> TechnologyEvent4 = new ArrayList<String>();
		TechnologyEvent4.add("Event4 date");
		TechnologyEvent4.add("Event4 time");
		TechnologyEvent4.add("Event4 description");
		TechnologyEvent4.add("Event4 host");
		TechnologyEvent4.add("Event4 location");
		
		List<String> TechnologyEvent5 = new ArrayList<String>();
		TechnologyEvent5.add("Event5 date");
		TechnologyEvent5.add("Event5 time");
		TechnologyEvent5.add("Event5 description");
		TechnologyEvent5.add("Event5 host");
		TechnologyEvent5.add("Event5 location");
		
		TechnologyEventsDetails.put("Tech Event 1", TechnologyEvent1);
		TechnologyEventsDetails.put("Tech Event 2", TechnologyEvent2);
		TechnologyEventsDetails.put("Tech Event 3", TechnologyEvent3);
		TechnologyEventsDetails.put("Tech Event 4", TechnologyEvent4);
		TechnologyEventsDetails.put("Tech Event 5", TechnologyEvent5);
		
		return TechnologyEventsDetails;
		
	}
	
}
