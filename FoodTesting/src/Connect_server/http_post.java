package Connect_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;
import attribute_inTest.Attribute;

public class http_post {

	Context context;
	
	ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
	
	
	 public http_post(Context context)
	 {
		 if (android.os.Build.VERSION.SDK_INT > 9) {
	            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
	            StrictMode.setThreadPolicy(policy);
	        }
		 this.context = context;
	 }
	
	 public ArrayList<HashMap<String, String>> get_data(String url,List<NameValuePair> params)
	    {				
		 Log.d("222222222", "222222222 1");
			try {
				String input = request(url, params);
				Log.d("222222222", "22222222 4 "+ input);
				JSONArray data = new JSONArray(input);
				HashMap<String, String> map;
				for(int i = 0; i < data.length(); i++){
	                JSONObject c = data.getJSONObject(i);
	    			map = new HashMap<String, String>();
	    			map.put("aid", c.getString("aid"));
	    			map.put("aname", c.getString("aname"));
	    			map.put("cid", c.getString("cid"));	
	    			map.put("cname", c.getString("cname"));
	    			
	    			
	    			MyArrList.add(map);
	    		}
			} catch (JSONException e) {
				Log.d("getJSON", "getJSON fail");
			}
			return MyArrList;	
	    }
	
	 public Integer get_count(String url,List<NameValuePair> params)
	    {	
		 	Integer count=0;
			try {
				JSONArray data = new JSONArray(request(url,params));		
				HashMap<String, String> map;
				for(int i = 0; i < data.length(); i++){
	                JSONObject c = data.getJSONObject(i);
	    			count = Integer.parseInt(c.getString("count"));	

	    		}
			} catch (JSONException e) {
				Log.d("getJSON", "getJSON fail");
			}
			return count;	
	    }
	
	
	public String request(String url ,List<NameValuePair> params)
	{
		StringBuilder str = new StringBuilder();
		HttpClient client = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		Log.d("client", "client 0");
		try {
		
			httpPost.setEntity(new UrlEncodedFormEntity(params));
			HttpResponse response = client.execute(httpPost);
			StatusLine statusLine = response.getStatusLine();
			int statusCode = statusLine.getStatusCode();

			if (statusCode == 200) { // Status OK
				
				
				HttpEntity entity = response.getEntity();
				InputStream content = entity.getContent();
				BufferedReader reader = new BufferedReader(new InputStreamReader(content));
				String line;
			
				while ((line = reader.readLine()) != null) {
					str.append(line);
				}
				Log.d("111111111111111 : ", "11111111111111 : "  + str.toString().substring(68));
				
			}
		}
		 catch (ClientProtocolException e) {
			Log.e("client","error ProtocolException");
		} catch (IOException e) {
			Log.e("client","error IOexception");
		}
		return str.toString().substring(68);
	}
}
