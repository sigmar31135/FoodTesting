package pie.app.foodtesting;

import java.util.ArrayList;

import Adapter.Adapter_test;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Context context = this;
	private GridView gridView;
	private static ArrayList<String[]> TestId;
	private static String user_id;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			user_id = extras.getString("user_id");
		}
		if(!user_id.isEmpty()){
			
			
			
			initial();
			set_test();
		}
		
	}
	
	private void set_test() {
		// TODO Auto-generated method stub
		Adapter_test adapter_test = new Adapter_test(MainActivity.this, user_id, TestId);
		gridView.setAdapter(adapter_test);
	}

	private void initial() {
		// TODO Auto-generated method stub
		gridView = (GridView)findViewById(R.id.gridView);
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// TODO Auto-generated method stub
		
		switch(item.getItemId()){
			case R.id.refesh : 
				Toast.makeText(MainActivity.this, "Sorry, we will have this feature soon.",Toast.LENGTH_SHORT).show(); 
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

}
