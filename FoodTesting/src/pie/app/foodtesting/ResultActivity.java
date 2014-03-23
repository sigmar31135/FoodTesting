package pie.app.foodtesting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class ResultActivity extends Activity{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result_activity);
	}	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
        case R.id.MainActivity:
            startActivity(new Intent(this,MainActivity.class));
            return true;
        case R.id.ResultActivity:
            startActivity(new Intent(this,ResultActivity.class));
            return true;
        case R.id.WaitingActivity:
            startActivity(new Intent(this,WaitingActivity.class));
            return true;
        case R.id.WorkActivity:
            startActivity(new Intent(this,WorkActivity.class));
            return true;
        default:
            return super.onOptionsItemSelected(item);
    }
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
