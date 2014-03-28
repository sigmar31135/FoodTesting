package attribute_inTest;

import java.util.ArrayList;
import java.util.HashMap;

import pie.app.foodtesting.R;
import Adapter.Adapter_result;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ExpandableListView;

public class Result extends Activity{

	ExpandableListView expandableListView_result;
	Button done;
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
			set_button();
			
		}

		private void set_button() {
			// TODO Auto-generated method stub
			done.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
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
