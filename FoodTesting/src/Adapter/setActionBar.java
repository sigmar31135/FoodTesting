package Adapter;

import pie.app.foodtesting.R;
import android.app.ActionBar;

public class setActionBar {
	
	public setActionBar(ActionBar objActionBar,String message) {
		// TODO Auto-generated constructor stub
		objActionBar.setTitle("   " + message);
		objActionBar.setIcon(R.drawable.topbar_logo);
		
	}

}
