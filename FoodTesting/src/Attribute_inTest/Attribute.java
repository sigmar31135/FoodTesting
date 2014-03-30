package attribute_inTest;

import java.security.acl.LastOwnerException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import pie.app.foodtesting.R;
import Connect_server.http_post;
import android.R.integer;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ExpandableListActivity;
import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Attribute extends Activity{
	
	ExpandableListView expandableListView;
	Button done;
	LinearLayout listview;
	Context context = this;
	Attribute page_atAttribute = this;
	Bundle bundle;
	ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String,String>>();
	ArrayList<HashMap<String, String>> data_child,data_attribute = new ArrayList<HashMap<String,String>>();
	String tid,uid;
	int count=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.attribute);
		bundle = getIntent().getExtras();
		tid = bundle.getString("tid");
		uid = bundle.getString("uid");
		
		getActionBar().hide();
		initial();
		get_Attribute();
		
		if(bundle.getSerializable("data") != null)
			{
				data = (ArrayList<HashMap<String, String>>) bundle.getSerializable("data");
				re_listview();
			}
		else
		
		set_listview();
		
		
		set_button();
		}
	
	private void re_listview() {
		// TODO Auto-generated method stub
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		for(int i=0;i<data_attribute.size();i++){
			final HashMap<String, String> map = new HashMap<String, String>();				
			final View view = inflater.inflate(R.layout.item_attribute, null);    
			TextView name_Attribute = (TextView)view.findViewById(R.id.txt_attribute);
			name_Attribute.setText(data_attribute.get(i).get("aname"));
			name_Attribute.setTextSize(30);
			map.put("aname", data_attribute.get(i).get("aname"));
			map.put("aid", data_attribute.get(i).get("aid"));
			count+=2;
			((ViewGroup) listview).addView(view,listview.getChildCount(), new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
			
			ArrayList<HashMap<String, String>> data_child = new ArrayList<HashMap<String,String>>();
			data_child = get_child(data_attribute.get(i).get("aid"));
					
			
			for(int j=0;j<data_child.size();j++){
					
				    final View view2 = inflater.inflate(R.layout.item_seekbar, null);
					TextView name_child = (TextView)view2.findViewById(R.id.attribute_name);
					name_child.setText(data_child.get(j).get("cname"));
					name_child.setTextSize(25);
					count+=3;
					LinearLayout parent_scale = (LinearLayout)view2.findViewById(R.id.parent_scale);	
			 
						for(int k=0;k<15;k++)
				    	{	
				    		final RelativeLayout child = (RelativeLayout)inflater.inflate(R.layout.scale, null);
							LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
				                    LayoutParams.MATCH_PARENT,
				                    LayoutParams.MATCH_PARENT, 1.0f);		
				    		param.gravity = Gravity.TOP | Gravity.END |Gravity.RIGHT;
				    		
				    		child.setLayoutParams(param);
				    		
						    TextView point = (TextView)child.findViewById(R.id.txt_scale);
						    point.setText(String.valueOf(k+1));
						    point.setTextSize(18);
						
						    if(k==0)
						    	 parent_scale.addView(child, 1);
						    else
						    	 parent_scale.addView(child, parent_scale.getChildCount());		   
				    	} 
						
					
					final TextView display_point = (TextView)view2.findViewById(R.id.display_point);	
				    	
				    display_point.setText(data.get(i).get("point_"+String.valueOf(j)));
				    
					display_point.setTextSize(22);
					final int index_j = j;
					final int index_i = i;
					
					SeekBar seekBar = (SeekBar)view2.findViewById(R.id.seekBar);
					
					Double double1 = Double.parseDouble(data.get(i).get("point_"+String.valueOf(j)));
					double1 = double1*100/15;
					int seek = double1.intValue();
					//Toast.makeText(context, String.valueOf(seek),Toast.LENGTH_LONG).show();
					seekBar.setProgress(seek);
					
					seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
				        @SuppressLint("ResourceAsColor") public void onProgressChanged(SeekBar seekBar,int progress, boolean fromUser){
				            //Do something here with new value
				        	double point = (double)progress;
				        	point = Math.round(point*15/10)/10.0;		        	
				        	display_point.setText(String.valueOf(point));	
				        	display_point.setTextSize(32);
				        	display_point.setTextColor(Color.RED);
				        	
				        	data.get(index_i).put("point_"+String.valueOf(index_j), String.valueOf(point));
				        	//map.put("point_"+String.valueOf(index),String.valueOf(point));
				        	
				        }

						public void onStartTrackingTouch(SeekBar arg0) {
							// TODO Auto-generated method stub
							
						}

						public void onStopTrackingTouch(SeekBar seekBar) {
							// TODO Auto-generated method stub
							display_point.setTextSize(22);
							display_point.setTextColor(Color.BLACK);
						}
				    });
					((ViewGroup) listview).addView(view2, listview.getChildCount(), new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));	
			}
			Log.d("0000000000000", "0000000000 add : "+String.valueOf(map.size()) );
			//data.add(map);	
		}
	}

	private ArrayList<HashMap<String, String>> get_child(String aid) {
		
		ArrayList<HashMap<String, String>> data_child = new ArrayList<HashMap<String,String>>();
		
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		String url = "http://food.tartecake.com/countch.php?aid="+aid;
		http_post post = new http_post(context);
		
		//params.add(new BasicNameValuePair("tid",aid));
		data_child = post.get_child(url, params);
		return data_child;
	}
	
	private void get_Attribute() {
		
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		String url = "http://food.tartecake.com/countatt.php";
		http_post post = new http_post(context);
		
		params.add(new BasicNameValuePair("tid",tid));
		data_attribute = post.get_attribute(url, params);	
			
	}


	private void set_listview() {
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		for(int i=0;i<data_attribute.size();i++){
			final HashMap<String, String> map = new HashMap<String, String>();				
			final View view = inflater.inflate(R.layout.item_attribute, null);    
			TextView name_Attribute = (TextView)view.findViewById(R.id.txt_attribute);
			name_Attribute.setText(data_attribute.get(i).get("aname"));
			name_Attribute.setTextSize(30);
			map.put("aname", data_attribute.get(i).get("aname"));
			map.put("aid", data_attribute.get(i).get("aid"));
			count+=2;
			((ViewGroup) listview).addView(view,listview.getChildCount(), new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
			
			ArrayList<HashMap<String, String>> data_child = new ArrayList<HashMap<String,String>>();
			data_child = get_child(data_attribute.get(i).get("aid"));
					
			
			for(int j=0;j<data_child.size();j++){
					
				    final View view2 = inflater.inflate(R.layout.item_seekbar, null);
					TextView name_child = (TextView)view2.findViewById(R.id.attribute_name);
					name_child.setText(data_child.get(j).get("cname"));
					name_child.setTextSize(25);
					map.put("cname_"+String.valueOf(j), data_child.get(j).get("cname"));
					map.put("cid_"+String.valueOf(j), data_child.get(j).get("cid"));
					count+=3;
					LinearLayout parent_scale = (LinearLayout)view2.findViewById(R.id.parent_scale);	
			 
						for(int k=0;k<15;k++)
				    	{	
				    		final RelativeLayout child = (RelativeLayout)inflater.inflate(R.layout.scale, null);
							LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
				                    LayoutParams.MATCH_PARENT,
				                    LayoutParams.MATCH_PARENT, 1.0f);		
				    		param.gravity = Gravity.TOP | Gravity.END |Gravity.RIGHT;
				    		
				    		child.setLayoutParams(param);
				    		
						    TextView point = (TextView)child.findViewById(R.id.txt_scale);
						    point.setText(String.valueOf(k+1));
						    point.setTextSize(18);
						
						    if(k==0)
						    	 parent_scale.addView(child, 1);
						    else
						    	 parent_scale.addView(child, parent_scale.getChildCount());		   
				    	} 
						
					
					final TextView display_point = (TextView)view2.findViewById(R.id.display_point);	
				    	
				    display_point.setText("0.0");
				    
					display_point.setTextSize(22);
					final int index = j;			
					
					SeekBar seekBar = (SeekBar)view2.findViewById(R.id.seekBar);
					seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
				        @SuppressLint("ResourceAsColor") public void onProgressChanged(SeekBar seekBar,int progress, boolean fromUser){
				            //Do something here with new value
				        	double point = (double)progress;
				        	point = Math.round(point*15/10)/10.0;		        	
				        	display_point.setText(String.valueOf(point));	
				        	display_point.setTextSize(32);
				        	display_point.setTextColor(Color.RED);
				        	
				        	map.put("point_"+String.valueOf(index),String.valueOf(point));
				        	
				        }

						public void onStartTrackingTouch(SeekBar arg0) {
							// TODO Auto-generated method stub
							
						}

						public void onStopTrackingTouch(SeekBar seekBar) {
							// TODO Auto-generated method stub
							display_point.setTextSize(22);
							display_point.setTextColor(Color.BLACK);
						}
				    });
					((ViewGroup) listview).addView(view2, listview.getChildCount(), new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));	
			}
			Log.d("0000000000000", "0000000000 add : "+String.valueOf(map.size()) );
			data.add(map);	
		}
	}

	private void set_button() {
		// TODO Auto-generated method stub
		done.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				int size=0;
				for(int i=0;i<data.size();i++)
				{
					for(int j=0;j<data.get(i).size();j++)
					{
						size++;
					}
				}
				
				if(size==count || bundle.getSerializable("data") != null){
				Intent intent = new Intent(Attribute.this,Result.class);
				intent.putExtra("data", data);
				intent.putExtra("uid", uid);
				intent.putExtra("tid", tid);
				intent.putExtra("page",Attribute.class);
				startActivity(intent);
				}
				else
					Toast.makeText(context, "��س�����ṹ���ú", Toast.LENGTH_LONG).show();
			}
		});
	}

	private void initial() {
		// TODO Auto-generated method stub
		expandableListView = (ExpandableListView)findViewById(R.id.expandableListView);
		done = (Button)findViewById(R.id.attribute_done);
		listview = (LinearLayout)findViewById(R.id.listview);
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		finish();
	}

}
