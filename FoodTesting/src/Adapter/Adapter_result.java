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
	String Attribute[] = {"ลักษณะปรากฏ","กลิ่น","กลิ่นรส","เนื้อสัมผัส"};
	String child_1[] = {"สีครีม","ความมันวาว"};
	String child_2[] = {"Dairy Product","หวาน","เปรี้ยว","Butyric acid","Fermented","Floral"};
	String child_3[] = {"Brown","Fruity","Chemical","Citrus","วานิลา","Musty"};
	String child_4[] = {"ความหนืด"};
	int group[] = {2,6,5,1};
	
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
			 
			 	if(group[groupPosition]==2)
				 	child_attribute_name.setText(child_1[childPosition]);
			    if(group[groupPosition]==6)
			    	child_attribute_name.setText(child_2[childPosition]);
			    if(group[groupPosition]==5)
			    	child_attribute_name.setText(child_3[childPosition]);
			    if(group[groupPosition]==1)
			    	child_attribute_name.setText(child_4[childPosition]);
			
			 
			 TextView point = (TextView)convertView.findViewById(R.id.result_attribute_point);
			 point.setText("12.5/15");
			 return convertView;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		return group[groupPosition];
	}

	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return 4;
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
			 convertView = inflater.inflate(R.layout.item_attribute, null);
		}
			 
			 TextView scale_name = (TextView)convertView.findViewById(R.id.txt_attribute);
			 scale_name.setText(Attribute[groupPosition]);
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
