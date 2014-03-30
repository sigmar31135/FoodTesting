package pie.app.foodtesting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Adapter.Adapter_test;
import Adapter.setActionBar;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Context context = this;
	private GridView gridView;
	private static ArrayList<String[]> TestId;
	private static String user_id;
	
	private int CheckPause = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Log.d("GGGGGG", "ON CREATE");
		
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			user_id = extras.getString("user_id");
			TestId = (ArrayList<String[]>) extras.get("TestId");
		}

		new setActionBar(getActionBar(), "MY TEST");

		if (!user_id.isEmpty()) {
			initial();
			set_test();
		}

	}
	
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.d("GGGGGG", "ON PAUSE");
		CheckPause = 1;
		
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		if(CheckPause == 1)
			new Refesh().execute();
	}

	private void set_test() {
		// TODO Auto-generated method stub

		Adapter_test adapter_test = new Adapter_test(MainActivity.this,
				user_id, TestId);
		gridView.setAdapter(adapter_test);

	}

	private void initial() {
		// TODO Auto-generated method stub
		gridView = (GridView) findViewById(R.id.gridView);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity_menu, menu);
		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// TODO Auto-generated method stub

		switch (item.getItemId()) {
		case R.id.refesh:
			new Refesh().execute();
			break;
		case R.id.sing_out:
			finish();
			break;

		}

		return super.onMenuItemSelected(featureId, item);
	}

	@Override
	public void onBackPressed() {
		new AlertDialog.Builder(this)
				.setIcon(android.R.drawable.ic_dialog_alert)
				.setTitle("FoodTesting")
				.setMessage("Do you want to \"SIGN OUT\" ")
				.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								finish();
							}

						}).setNegativeButton("No", null).show();
	}

	private class Refesh extends AsyncTask<Void, Void, String> {

		ProgressDialog objLoading;

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			objLoading = new ProgressDialog(MainActivity.this);
			objLoading.setCancelable(false);
			objLoading.setMessage("Please wait...");
			objLoading.show();

		}

		@Override
		protected String doInBackground(Void... params) {
			// TODO Auto-generated method stub

			HttpClient client = new DefaultHttpClient();
			HttpPost httpPost = new HttpPost(
					"http://food.tartecake.com/refresh.php?uid=" + user_id);

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
			
			objLoading.cancel();

			if (result.equals("error")) {
				Toast.makeText(MainActivity.this,
						"Sorry, Have an internet's problem.",
						Toast.LENGTH_SHORT).show();
				return;
			}

			JSONObject data, data3;
			JSONArray data2;
			TestId = new ArrayList<String[]>();

			try {
				data = new JSONObject(result);
				data2 = data.getJSONArray("test");

				for (int i = 0; i < data2.length(); i++) {
					if (!data2.getJSONObject(i).getString("work").equals(""))
						TestId.add(new String[] {
								data2.getJSONObject(i).getString("tid"),
								data2.getJSONObject(i).getString("work"),
								data2.getJSONObject(i).getString("attribute"),
								data2.getJSONObject(i).getString("create") });
				}

				Intent intent = new Intent(MainActivity.this,
						MainActivity.class);
				intent.putExtra("user_id", user_id);
				intent.putExtra("TestId", TestId);
				finish();
				startActivity(intent);

			} catch (JSONException e) {
				e.printStackTrace();

			}
		}

	}

}
