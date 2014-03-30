package Adapter;

import java.util.ArrayList;

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
import android.widget.ImageView;
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
		test_id.setText("Test ID : " + TestId.get(index)[0]);
		
		TextView test_attribute = (TextView)convertView.findViewById(R.id.test_attribute);
		test_attribute.setText("Attribute : " + TestId.get(index)[2]);
		
		TextView test_create = (TextView)convertView.findViewById(R.id.test_create);
		test_create.setText("Create : " + TestId.get(index)[3].substring(0,9));
		
		
		
		
		// set id
		Button btn_test = (Button)convertView.findViewById(R.id.btn_test);
		if(TestId.get(position)[1].equals("0")){
			btn_test.setText("TEST");
			btn_test.setBackgroundResource(R.drawable.test_btn);
		}else{
			btn_test.setText("EDIT");
			btn_test.setBackgroundResource(R.drawable.edit_btn);
		}
		
	
		
		
		btn_test.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(context,Attribute.class);
				intent.putExtra("user_id", user_id);
				intent.putExtra("test_id", TestId.get(index)[0]);
				context.startActivity(intent);
			}
		});
		
		
		return convertView;
	}

}
