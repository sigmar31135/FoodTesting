package Adapter;

import pie.app.foodtesting.R;
import android.content.Context;
import android.content.Intent;
import android.sax.StartElementListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import Attribute_inTest.Attribute;

public class Adapter_test extends BaseAdapter{

	Context context;
	
	public Adapter_test(Context context){
		this.context = context;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 5;
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
		
		TextView test_id = (TextView)convertView.findViewById(R.id.test_id);
		// set id
		Button btn_test = (Button)convertView.findViewById(R.id.btn_test);
		btn_test.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(context,Attribute.class);
				//intent.putExtra("test_id",test_id);

				context.startActivity(intent);
			}
		});
		
		
		return convertView;
	}

}
