package Adapter;

import java.util.ArrayList;

import database.MainDatabase;
import pie.app.foodtesting.R;
import android.content.Context;
import android.content.Intent;
import android.sax.StartElementListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import attribute_inTest.Attribute;

public class Adapter_test extends BaseAdapter{

	private Context context;
	private static ArrayList<String[]> TestId;
	private static String user_id;
	
	public Adapter_test(Context context, String user_id, ArrayList<String[]> TestId){
		this.context = context;
		this.TestId = TestId;
		this.user_id = user_id;
		
		Log.d("GGGGGG", String.valueOf(TestId.size()));
		
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return TestId.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		convertView = inflater.inflate(R.layout.block_test, null); 
		final int index = position;
		TextView test_id = (TextView)convertView.findViewById(R.id.test_id);
		test_id.setText(TestId.get(index)[0]);
		// set id
		Button btn_test = (Button)convertView.findViewById(R.id.btn_test);
		btn_test.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(context,Attribute.class);
				intent.putExtra(MainDatabase.UserTestTableColUserId, user_id);
				intent.putExtra(MainDatabase.UserTestTableColTestId, TestId.get(index)[0]);
				//intent.putExtra("test_id",test_id);

				context.startActivity(intent);
				//Toast.makeText(context, "sad", Toast.LENGTH_LONG).show();
			}
		});
		
		
		return convertView;
	}

}
