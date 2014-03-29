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
import android.app.Activity;
import android.app.ExpandableListActivity;
import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.content.Intent;
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
	
	ArrayList<HashMap<String, String>> data,information = new ArrayList<HashMap<String,String>>();
	String tid;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.attribute);
		
		initial();
		request_data();
		set_listview();
		
		
		//Log.d("66666666666666", "66666666666 : "+information.get(0).get("aid"));
		set_button();
		//Toast.makeText(context, String.valueOf(information.size()), Toast.LENGTH_LONG).show();
	}


	private void request_data() {
		http_post post = new http_post(context);
		String url = "http://food.tartecake.com/getatt.php";
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("tid","15"));
		information = post.get_data(url, params);
	}
	
	private Integer count_child(int i) {
		Integer count = 0;
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		String url = "http://food.tartecake.com/countch.php";
		http_post post = new http_post(context);
		params.add(new BasicNameValuePair("tid",information.get(i).get("aid")));
		Log.d("66666666666666", "66666666666 : "+information.get(i).get("aid"));
		count = Integer.parseInt(post.request(url, params));
		return count;
	}
	
	private Integer count_Attribute() {
		Integer count = 1;
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		String url = "http://food.tartecake.com/countatt.php";
		http_post post = new http_post(context);
		params.add(new BasicNameValuePair("tid","15"));
		String test = post.request(url, params);	
		count = Integer.parseInt(test.toString());	
		Toast.makeText(context,params.get(0).getValue() , Toast.LENGTH_LONG).show();
		return count;
	}


	private void set_listview() {
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		for(int i=0;i<count_Attribute();i++){
			final HashMap<String, String> map = new HashMap<String, String>();
			map.put("Attribute_name", "name_attribute");
			
			final View view = inflater.inflate(R.layout.item_attribute, null);    
			TextView name_Attribute = (TextView)view.findViewById(R.id.txt_attribute);
			//name_Attribute.setText(information.get(i).get("aname"));
			
			((ViewGroup) listview).addView(view,listview.getChildCount(), new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
		
			for(int j=0;j<count_child(i);j++){
				
				    final View view2 = inflater.inflate(R.layout.item_seekbar, null);
					//TextView name_child = (TextView)view2.findViewById(R.id.attribute_name);
					/*name_child.setText("test "+ String.valueOf(j));
					map.put("child_name_"+String.valueOf(j), "name child");
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
						    
						    if(k==0)
						    	 parent_scale.addView(child, 1);
						    else
						    	 parent_scale.addView(child, parent_scale.getChildCount());		   
				    	} 
						
					final TextView display_point = (TextView)view2.findViewById(R.id.display_point);	
					
					final int index = j;
				
					SeekBar seekBar = (SeekBar)view2.findViewById(R.id.seekBar);
					seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
				        public void onProgressChanged(SeekBar seekBar,int progress, boolean fromUser){
				            //Do something here with new value
				        	double point = (double)progress;
				        	point = Math.round(point*15/10)/10.0;		        	
				        	display_point.setText(String.valueOf(point));	        	
				        	map.put("child_"+String.valueOf(index), String.valueOf(point));
				        }

						public void onStartTrackingTouch(SeekBar arg0) {
							// TODO Auto-generated method stub
							
						}

						public void onStopTrackingTouch(SeekBar seekBar) {
							// TODO Auto-generated method stub
						}
				    });*/
					((ViewGroup) listview).addView(view2, listview.getChildCount(), new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));				
					
			}
			//data.add(map);
		}
	}

	private void set_button() {
		// TODO Auto-generated method stub
		done.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Attribute.this,Result.class);
				intent.putExtra("data", data);
				startActivity(intent);
				
				/*for(int i=0;i<data.size();i++)
				{
					Log.d("item ", "item Attribute: "+data.get(i).get("Attribute"));
					for(int j=0;j<data.get(i).size()-1;j++)
					{	
						Log.d("item ","item Child : "+data.get(i).get("child_"+j));
						Toast.makeText(context, String.valueOf(data.get(i).size()), Toast.LENGTH_LONG).show();
					}
				}*/
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
