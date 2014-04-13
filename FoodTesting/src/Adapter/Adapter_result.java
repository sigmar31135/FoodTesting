package Adapter;

import java.util.ArrayList;
import java.util.HashMap;

import pie.app.foodtesting.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class Adapter_result extends BaseExpandableListAdapter{

	Context context;
	ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String,String>>();
	
	public Adapter_result(Context context,ArrayList<HashMap<String, String>> data)
	{
		this.context = context;
		this.data = data;
	}
	
	@Override
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
	
		if(convertView==null){
			 LayoutInflater inflater =  (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			 convertView = inflater.inflate(R.layout.child_result, null);
		}
			 TextView child_attribute_name = (TextView)convertView.findViewById(R.id.result_attribute_name);
			 child_attribute_name.setText(data.get(groupPosition).get("cname_"+String.valueOf(childPosition)));
			 child_attribute_name.setTextSize(25);
			 
			 TextView point = (TextView)convertView.findViewById(R.id.result_attribute_point);
			 point.setText(data.get(groupPosition).get("point_"+String.valueOf(childPosition))+"/15");
			 point.setTextSize(25);
			 return convertView;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		return (data.get(groupPosition).size()-2)/3;
	}

	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		if(convertView==null){
			 LayoutInflater inflater =  (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			 convertView = inflater.inflate(R.layout.header_result, null);
		}
			 
			 TextView scale_name = (TextView)convertView.findViewById(R.id.header_result_txt);
			 scale_name.setText(data.get(groupPosition).get("aname"));
			 scale_name.setTextSize(30);
			 return convertView;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return false;
	}

}
