package Adapter;

import java.util.ArrayList;
import java.util.HashMap;
import pie.app.foodtesting.R;
import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import attribute_inTest.childInAttribute;

public class Adapter_attribute extends BaseExpandableListAdapter{
	
	//ArrayList<String> Attribute = new ArrayList<String>();
	//ArrayList<HashMap<String,String>> Child = new ArrayList<HashMap<String,String>>();
	
	String Attribute[] = {"ลักษณะปรากฏ","กลิ่น","กลิ่นรส","เนื้อสัมผัส"};
	String child_1[] = {"สีครีม","ความมันวาว"};
	String child_2[] = {"Dairy Product","หวาน","เปรี้ยว","Butyric acid","Fermented","Floral"};
	String child_3[] = {"Brown","Fruity","Chemical","Citrus","วานิลา","Musty"};
	String child_4[] = {"ความหนืด"};
	int group[] = {2,6,5,1};
	Context context;
	
	
	ArrayList<childInAttribute> data = new ArrayList<childInAttribute>();
	childInAttribute sub_data;
	
	public Adapter_attribute(Context context){
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

	@SuppressLint("NewApi")
	@Override
	public View getChildView(final int groupPosition, final int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		
		
	if(convertView==null){
		sub_data = new childInAttribute(10);
		data.add(groupPosition,sub_data);
		LayoutInflater inflater =  (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    convertView = inflater.inflate(R.layout.item_seekbar, null);
	    LinearLayout parent_scale = (LinearLayout)convertView.findViewById(R.id.parent_scale);	
	    LayoutInflater scale = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
	    for(int i=0;i<15;i++)
    	{
	    	
    		final RelativeLayout child = (RelativeLayout)scale.inflate(R.layout.scale, null);
			LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                    LayoutParams.MATCH_PARENT,
                    LayoutParams.MATCH_PARENT, 1.0f);		
    		param.gravity = Gravity.TOP | Gravity.END |Gravity.RIGHT;
    		
    		child.setLayoutParams(param);
    		
		    TextView point = (TextView)child.findViewById(R.id.txt_scale);
		    point.setText(String.valueOf(i+1));
		    
		    if(i==0)
		    	 parent_scale.addView(child, 1);
		    else
		    	 parent_scale.addView(child, parent_scale.getChildCount());		   
    	}   
	}  
	      
	    final TextView attribute_name = (TextView)convertView.findViewById(R.id.attribute_name);
		

	    Log.d("111111", "111111 : "+String.valueOf(groupPosition)+" : "+String.valueOf(childPosition));
	    
	    if(group[groupPosition]==2)
	    	attribute_name.setText(child_1[childPosition]);
	    if(group[groupPosition]==6)
	    	attribute_name.setText(child_2[childPosition]);
	    if(group[groupPosition]==5)
	    	attribute_name.setText(child_3[childPosition]);
	    if(group[groupPosition]==1)
	    	attribute_name.setText(child_4[childPosition]);
		
	    
	
	 	final TextView display_point = (TextView)convertView.findViewById(R.id.display_point);
		display_point.setText(data.get(groupPosition).get_point(childPosition));
		final SeekBar seek_point = (SeekBar)convertView.findViewById(R.id.seekBar);		
		
		String point = data.get(groupPosition).get_point(childPosition);
		Double display = Double.parseDouble(point);
		display = display*100/15;
		Integer show_point = display.intValue();
		seek_point.setProgress(show_point);
		
		
		seek_point.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
	        public void onProgressChanged(SeekBar seekBar,int progress, boolean fromUser){
	            //Do something here with new value
	        	double point = (double)progress;
	        	point = Math.round(point*15/10)/10;
	        	
	        	display_point.setText(String.valueOf(point));
	        	
	        	//sub_data.set_Attribute("");
	        	sub_data.set_point(childPosition, String.valueOf(point));
	        	data.set(groupPosition, sub_data);
	        }

			public void onStartTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				
			}

			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
	    });
	
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
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView2, ViewGroup parent) {
		if(convertView2 == null){
			 LayoutInflater inflater =  (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			 convertView2 = inflater.inflate(R.layout.item_attribute, null);
		}  
			 TextView scale_name = (TextView)convertView2.findViewById(R.id.txt_attribute);
			 scale_name.setText(Attribute[groupPosition]);
		
		
		 return convertView2;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return true;
	}

}
