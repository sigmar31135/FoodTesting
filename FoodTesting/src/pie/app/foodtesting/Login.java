package pie.app.foodtesting;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {

	private static Button SignIn;
	private static EditText edtUsername, edtPassword;
	private static String username, password, user_id;
	private static ArrayList<String[]> test;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		initial();
		set_button();

		edtUsername.setText("tester01");
		edtPassword.setText("123456");

	}

	private void set_button() {
		// TODO Auto-generated method stub
		SignIn.setOnClickListener(listener);
	}

	private void initial() {
		// TODO Auto-generated method stub
		SignIn = (Button) findViewById(R.id.btn_signin);
		edtUsername = (EditText) findViewById(R.id.login_username);
		edtPassword = (EditText) findViewById(R.id.login_password);
	}

	OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.btn_signin:
				username = edtUsername.getText().toString().trim();
				password = edtPassword.getText().toString().trim();
				if (!(username.isEmpty() || password.isEmpty())) {
					new CheckUser().execute();
				} else {
					Toast.makeText(getApplicationContext(),
							"Please insert username or password.",
							Toast.LENGTH_SHORT).show();
				}
				break;

			default:
				break;
			}
		}
	};

	private class CheckUser extends AsyncTask<Void, Void, String> {

		@Override
		protected String doInBackground(Void... params) {
			// TODO Auto-generated method stub

			HttpClient client = new DefaultHttpClient();
			HttpPost httpPost = new HttpPost("http://food.tartecake.com/checklogin.php?username=" + username + "&password=" + password);
			
			
			/* I can't use it
			List<NameValuePair> request = new ArrayList<NameValuePair>();
			request.add(new BasicNameValuePair("username", "tester01"));
			request.add(new BasicNameValuePair("password", "123456"));
			httpPost.setEntity(new UrlEncodedFormEntity(request, "UTF-8"));
			*/
			
			String Gabumon = "error";
			try {
				HttpResponse response = client.execute(httpPost);
				StatusLine statusLine = response.getStatusLine();
				int statusCode = statusLine.getStatusCode();
				if (statusCode == 200) { // Status OK
					HttpEntity entity = response.getEntity();
					InputStream content = entity.getContent();
					BufferedReader reader = new BufferedReader(
							new InputStreamReader(content));
					String line;
					Gabumon = "";
					while ((line = reader.readLine()) != null) {
						Gabumon += line;
					}
				}
			} catch (ClientProtocolException e) {
				Log.e("ClientProtocolException", "error " + e.toString());
			} catch (IOException e) {
				Log.e("IOException", "error" + e.toString());
			}

			return Gabumon;
		}
		
		
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			
			
			if(result.equals("fail")){
				Toast.makeText(Login.this,
						"Invalid username or password.",
						Toast.LENGTH_SHORT).show();
				return ;
			}
			else if(result.equals("error")){
				Toast.makeText(Login.this,
						"Sorry, Have an internet's problem.",
						Toast.LENGTH_SHORT).show();
				return ;
			}
			
			JSONObject data,data3;
			JSONArray data2;
			test = new ArrayList<String[]>();
			
			try {
				data = new JSONObject(result);
				data2 = data.getJSONArray("test");
				user_id = data.getString("uid");
				
				for(int i=0;i<data2.length();i++){
					if(!data2.getJSONObject(i).getString("work").equals(""))
						test.add(new String[]{data2.getJSONObject(i).getString("tid"), data2.getJSONObject(i).getString("work")});
				}
				
				if(test.size()==0){
					Toast.makeText(Login.this, "Don't have any work you can do.", Toast.LENGTH_LONG).show();
					return ;
					
				}
				Intent intent = new Intent(Login.this,
						MainActivity.class);
				intent.putExtra("user_id", user_id);
				intent.putExtra("TestId", test);
				startActivity(intent);
				edtUsername.setText("");
				edtPassword.setText("");
				
				
			} catch (JSONException e) {
				e.printStackTrace();

			}
		}
		
	

	}

}
