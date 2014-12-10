package com.yale.bulletin;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.graphics.Typeface;
import android.util.MonthDisplayHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class TechnologyEventsAdapter extends BaseExpandableListAdapter{
	private Context ctx;
	//*****
	private List<List<String>> Technology_Event_Name;
	//private List<String> Technology_Event_Details;
	
	public TechnologyEventsAdapter(Context ctx, List<List<String>> Technology_Event_Name)
	{
		this.ctx = ctx;
		this.Technology_Event_Name = Technology_Event_Name;
		
	}

	@Override
	public Object getChild(int parent, int child) {
	
		//****
		return Technology_Event_Name.get(parent).get(child+1);
	}

	@Override
	public long getChildId(int parent, int child) {
		// TODO Auto-generated method stub
		return child;
	}

	@Override
	public View getChildView(int parent, int child, boolean lastChild, View convertview,
			ViewGroup parentview) 
	 {
		String child_title =  (String) getChild(parent, child);
		if(convertview == null)
		{
			LayoutInflater inflator = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		    convertview = inflator.inflate(R.layout.child_layout_technology, parentview,false);
		}
		TextView child_textview = (TextView) convertview.findViewById(R.id.child_txt_technology);
		child_textview.setText(child_title);
		
		
		return convertview;
	}

	@Override
	public int getChildrenCount(int arg0) {
		
		//return Technology_Event_Name.get(arg0).size()-1;
		return 5;
	}

	@Override
	public Object getGroup(int arg0) {
		// TODO Auto-generated method stub
		return Technology_Event_Name.get(arg0).get(0);
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return Technology_Event_Name.size();
	}

	@Override
	public long getGroupId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getGroupView(int parent, boolean isExpanded, View convertview, ViewGroup parentview) {
		// TODO Auto-generated method stub
		String group_title = (String) getGroup(parent);
		if(convertview == null)
		{
			LayoutInflater inflator = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		    convertview = inflator.inflate(R.layout.parent_layout_technology, parentview,false);
		}
		TextView parent_textview = (TextView) convertview.findViewById(R.id.parent_txt_technology);
		parent_textview.setTypeface(null, Typeface.BOLD);
		parent_textview.setText(group_title);
		return convertview;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChildSelectable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

}
