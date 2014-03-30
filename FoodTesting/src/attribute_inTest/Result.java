package attribute_inTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import pie.app.foodtesting.R;
import Adapter.Adapter_result;
import Connect_server.http_post;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Toast;

public class Result extends Activity{

	List<NameValuePair> params = new ArrayList<NameValuePair>();
	
	ExpandableListView expandableListView_result;
	Button done;
	String json = "[";
	String tid = "15";
	String uid = "2";
	Context context = this;
	ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String,String>>();
	
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.result);
			Bundle bundle = getIntent().getExtras();
			data = (ArrayList<HashMap<String, String>>) bundle.getSerializable("data");
			
			for(int i=0;i<data.size();i++)
			{
				Log.d("item ", "item Attribute: "+data.get(i).get("Attribute"));
				for(int j=0;j<data.get(i).size()-1;j++)
				{	
					Log.d("item ","item Child : "+data.get(i).get("child_"+j));
				}
			}
			initial();
			set_expendablelist();
			set_information();
			set_button();
			
		}

		private void set_information() {
			//Log.d("aaaaaaaaaa", "aaaaaaaaaaa data size : "+String.valueOf(data.size()));
			
			//Toast.makeText(context, json, Toast.LENGTH_LONG).show();
			
			for(int i=0;i<data.size();i++)
			{
				
				for(int j=0;j<( (data.get(i).size())-2 )/3;j++)
				{
					
					json += "{";
					String cid = data.get(i).get("cid_"+String.valueOf(j));
					String aid = data.get(i).get("aid");
					String point = data.get(i).get("point_"+String.valueOf(j));
					Log.d("aaaaaaaaaa", "aaaaaaaaaaa cid : "+cid);
					Log.d("aaaaaaaaaa", "aaaaaaaaaaa aid : "+aid);
					Log.d("aaaaaaaaaa", "aaaaaaaaaaa tid : "+tid);
					Log.d("aaaaaaaaaa", "aaaaaaaaaaa point : "+point);
					
					json += "\"tid\":" + tid + ",";
					json += "\"uid\":" + uid + ",";
					json += "\"cid\":" + cid + ",";
					json += "\"aid\":" + aid + ",";
					json += "\"point\":" + point;
					
					if(j != (data.get(i).size()-2)/3 -1)
						json += "},";
					else
						json += "}";
				
				}
			
			}
			json = json+"]";
			Log.d("xxxxxxxxxxx", "xxxxxxxxx : "+json);
			
		}

		private void set_button() {
			// TODO Auto-generated method stub
			done.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					String url = "http://food.tartecake.com/summary.php";
					http_post post = new http_post(context);		
					params.add(new BasicNameValuePair("array", json));
					post.send(url, params);
					
					finish();
				}
			});
		}

		private void set_expendablelist() {
			// TODO Auto-generated method stub
			Adapter_result adapter_result = new Adapter_result(context,data);
			expandableListView_result.setAdapter(adapter_result);
		}

		private void initial() {
			// TODO Auto-generated method stub
			expandableListView_result = (ExpandableListView)findViewById(R.id.result_expendableList);
			done = (Button)findViewById(R.id.result_done);
			
		}
}
