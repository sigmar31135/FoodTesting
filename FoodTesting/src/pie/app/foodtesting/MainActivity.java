package pie.app.foodtesting;

import Adapter.Adapter_test;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

public class MainActivity extends Activity {
	Context context = this;
	GridView gridView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initial();
		set_test();
	}
	
	private void set_test() {
		// TODO Auto-generated method stub
		Adapter_test adapter_test = new Adapter_test(context);
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

}
