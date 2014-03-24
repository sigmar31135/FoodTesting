package Adapter;

import pie.app.foodtesting.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class Adapter_result extends BaseExpandableListAdapter{

	Context context;
	
	
	public Adapter_result(Context context)
	{
		this.context = context;
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
	
			 LayoutInflater inflater =  (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			 convertView = inflater.inflate(R.layout.child_result, null);
			  
			 TextView child_attribute_name = (TextView)convertView.findViewById(R.id.result_attribute_name);
			 child_attribute_name.setText("Attribute "+String.valueOf(groupPosition+1));
			 
			 TextView point = (TextView)convertView.findViewById(R.id.result_attribute_point);
			 point.setText("10/20");
			 return convertView;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {

			 LayoutInflater inflater =  (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			 convertView = inflater.inflate(R.layout.item_attribute, null);
			  
			 TextView scale_name = (TextView)convertView.findViewById(R.id.txt_attribute);
			 scale_name.setText("Attribute "+String.valueOf(groupPosition+1));
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
