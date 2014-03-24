package pie.app.foodtesting;

import database.ProductTable;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Login extends Activity{

	Button SignIn,SignUp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		initial();
		set_button();
		
		
		//Make Table in first open
		ProductTable MakeTable = new ProductTable(this);
		
	}

	private void set_button() {
		// TODO Auto-generated method stub
		SignIn.setOnClickListener(listener);
	}

	private void initial() {
		// TODO Auto-generated method stub
		SignIn = (Button)findViewById(R.id.btn_signin);
		SignUp = (Button)findViewById(R.id.btn_signup);
	}
	
	OnClickListener listener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.btn_signin:
						Intent intent = new Intent(Login.this,MainActivity.class);
						startActivity(intent);
				break;

			default:
				break;
			}
		}
	};
}
