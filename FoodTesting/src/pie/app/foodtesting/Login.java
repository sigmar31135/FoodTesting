package pie.app.foodtesting;

import database.MainDatabase;
import database.ProductTable;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity{

	private static Button SignIn,SignUp;
	private static EditText edtUsername,edtPassword;
	private static String username,password;
	
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
		edtUsername = (EditText) findViewById(R.id.login_username);
		edtPassword = (EditText) findViewById(R.id.login_password);
	}
	
	OnClickListener listener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.btn_signin:
						username = edtUsername.getText().toString().trim();
						password  = edtPassword.getText().toString().trim();
						if(!(username.isEmpty()||password.isEmpty())){
							String passValue = CheckUser();
							if(passValue.equals("error"))
								Toast.makeText(Login.this, "Invalid username or password.", Toast.LENGTH_SHORT).show();
							else{
								Intent intent = new Intent(Login.this,MainActivity.class);
								intent.putExtra(MainDatabase.UserTableColUserId, passValue);
								startActivity(intent);
							}
						}else{
							Toast.makeText(getApplicationContext(),"Please insert username or password.",Toast.LENGTH_SHORT).show();
						}
				break;

			default:
				break;
			}
		}

		private String CheckUser() {
			// TODO Auto-generated method stub
			SQLiteDatabase objSQL = new MainDatabase(Login.this).getReadableDatabase();
			Cursor Data = objSQL.query(MainDatabase.UserTableName, new String[]{MainDatabase.UserTableColUserId}, MainDatabase.UserTableColUser + " = '" + username + "' AND " + MainDatabase.UserTableColPassword + " ='"+ password + "'", null, null, null, null);
			Data.moveToFirst();
			if(Data.getCount()!=0){
				return Data.getString(Data.getColumnIndex(MainDatabase.UserTableColUserId));
			}
			return "error";
		}
	};
}
