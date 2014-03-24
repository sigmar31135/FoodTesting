package attribute_inTest;

import pie.app.foodtesting.R;
import Adapter.Adapter_attribute;
import android.app.Activity;
import android.app.ExpandableListActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ExpandableListView;

public class Attribute extends Activity{
	
	ExpandableListView expandableListView;
	Context context = this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.attribute);
		initial();
		set_expendableList();
	}


	private void set_expendableList() {
		// TODO Auto-generated method stub
		Adapter_attribute adapter_attribute = new Adapter_attribute(context);
		expandableListView.setAdapter(adapter_attribute);
	}


	private void initial() {
		// TODO Auto-generated method stub
		expandableListView = (ExpandableListView)findViewById(R.id.expandableListView);
	
	}

}
