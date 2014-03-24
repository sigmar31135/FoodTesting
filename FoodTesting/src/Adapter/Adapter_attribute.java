package Adapter;

import pie.app.foodtesting.R;
import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class Adapter_attribute extends BaseExpandableListAdapter{
	
	Context context;
	
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
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		
		LayoutInflater inflater =  (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    convertView = inflater.inflate(R.layout.item_seekbar, null);
	    
	    LinearLayout parent_scale = (LinearLayout)convertView.findViewById(R.id.parent_scale);
		
	    LayoutInflater scale = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
	   
	    for(int i=0;i<4;i++)
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
		
	    final TextView display_point = (TextView)convertView.findViewById(R.id.display_point);
		display_point.setText("0.0");
		SeekBar seek_point = (SeekBar)convertView.findViewById(R.id.seekBar);		
		seek_point.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
		        public void onProgressChanged(SeekBar seekBar,int progress, boolean fromUser){
		            //Do something here with new value
		        	double point = (double)progress;
		        	display_point.setText(String.valueOf(point/25));
		        	
		        }

				public void onStartTrackingTouch(SeekBar arg0) {
					// TODO Auto-generated method stub
					
				}

				public void onStopTrackingTouch(SeekBar seekBar) {
					// TODO Auto-generated method stub
					
				}
		    });
		
		
		 
	    TextView attribute_name = (TextView)convertView.findViewById(R.id.attribute_name);
		attribute_name.setText("child attribute "+String.valueOf(childPosition+1));
		
		
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
