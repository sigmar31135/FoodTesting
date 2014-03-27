package attribute_inTest;

import pie.app.foodtesting.R;
import Adapter.Adapter_attribute;
import android.app.Activity;
import android.app.ExpandableListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ExpandableListView;

public class Attribute extends Activity{
	
	ExpandableListView expandableListView;
	Button done;
	Context context = this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.attribute);
		initial();
		set_expendableList();
		set_button();
	}


	private void set_button() {
		// TODO Auto-generated method stub
		done.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Attribute.this,Result.class);
				startActivity(intent);
			}
		});
	}


	private void set_expendableList() {
		// TODO Auto-generated method stub
		Adapter_attribute adapter_attribute = new Adapter_attribute(context);
		expandableListView.setAdapter(adapter_attribute);
	}


	private void initial() {
		// TODO Auto-generated method stub
		expandableListView = (ExpandableListView)findViewById(R.id.expandableListView);
		done = (Button)findViewById(R.id.attribute_done);
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		finish();
	}
}
