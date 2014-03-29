package attribute_inTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
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

public class Result extends Activity{

	JSONArray array = new JSONArray();
	
	ExpandableListView expandableListView_result;
	Button done;
	String tid = "15";
	String uid = "2";
	Context context = this;
	List<NameValuePair> params = new ArrayList<NameValuePair>();
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
			for(int i=0;i<data.size();i++)
			{
				
				Log.d("item : "+String.valueOf(i), "item Attribute: "+data.get(i).get("aname"));
				Log.d("item ","item child size : "+String.valueOf(data.get(i).size()));
				for(int j=0;j<((data.get(i).size())-2)/3;j++)
				{	
					params.add(new BasicNameValuePair("tid",tid));
					params.add(new BasicNameValuePair("uid",uid));
					params.add(new BasicNameValuePair("cid",data.get(i).get("cid_"+String.valueOf(j))));
					params.add(new BasicNameValuePair("aid",data.get(i).get("aid_"+String.valueOf(j))));
					params.add(new BasicNameValuePair("point",data.get(i).get("point_"+String.valueOf(j))));
					
					array.put(params);
					Log.d("item ","item Child : "+data.get(i).get("cname_"+String.valueOf(j)));
				}
			}
		}

		private void set_button() {
			// TODO Auto-generated method stub
			done.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					String url = "http://food.tartecake.com/summary.php";
					http_post post = new http_post(context);			
					post.send(url, array);
					
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
