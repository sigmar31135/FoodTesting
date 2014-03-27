package attribute_inTest;

import pie.app.foodtesting.R;
import Adapter.Adapter_result;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ExpandableListView;

public class Result extends Activity{

	ExpandableListView expandableListView_result;
	Button done;
	Context context = this;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.result);
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
			Adapter_result adapter_result = new Adapter_result(context);
			expandableListView_result.setAdapter(adapter_result);
		}

		private void initial() {
			// TODO Auto-generated method stub
			expandableListView_result = (ExpandableListView)findViewById(R.id.result_expendableList);
			done = (Button)findViewById(R.id.result_done);
			
		}
}
