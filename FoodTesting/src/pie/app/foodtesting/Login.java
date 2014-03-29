package pie.app.foodtesting;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

import org.apache.http.client.HttpClient;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {

	private static Button SignIn;
	private static EditText edtUsername, edtPassword;
	private static String username, password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		initial();
		set_button();

		edtUsername.setText("sigmar");
		edtPassword.setText("gggggggg");

	}

	private void set_button() {
		// TODO Auto-generated method stub
		SignIn.setOnClickListener(listener);
	}

	private void initial() {
		// TODO Auto-generated method stub
		SignIn = (Button) findViewById(R.id.btn_signin);
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
				password = edtPassword.getText().toString().trim();
				if (!(username.isEmpty() || password.isEmpty())) {
					String passValue = "error";
					new CheckUser().execute();
					if (passValue.equals("error"))
						Toast.makeText(Login.this,
								"Invalid username or password.",
								Toast.LENGTH_SHORT).show();
					else {
						Intent intent = new Intent(Login.this,
								MainActivity.class);
						intent.putExtra("user_id", passValue);
						startActivity(intent);

						edtUsername.setText("");
						edtPassword.setText("");
					}
				} else {
					Toast.makeText(getApplicationContext(),
							"Please insert username or password.",
							Toast.LENGTH_SHORT).show();
				}
				break;

			default:
				break;
			}
		}
	};

	private class CheckUser extends AsyncTask<Void, Void, String> {

		@Override
		protected String doInBackground(Void... params) {
			// TODO Auto-generated method stub

			try {
				HttpURLConnection connectWeb = null;
				String url = "http://food.tartecake.com/checklogin.php";

				connectWeb = (HttpURLConnection)new URL(url).openConnection();
				connectWeb.setRequestMethod("GET");
				connectWeb.addRequestProperty("username", username);
				connectWeb.addRequestProperty("password", password);

				int resultServer;

				resultServer = connectWeb.getResponseCode();

				if (resultServer == HttpURLConnection.HTTP_OK) {

					InputStream objInpuStream = connectWeb.getInputStream();
					ByteArrayOutputStream bos = new ByteArrayOutputStream();

					int read = 0;
					while ((read = objInpuStream.read()) != -1) {
						bos.write(read);
					}
					byte[] result = bos.toByteArray();
					bos.close();

					String data = new String(result);
					Log.d("GGGGGG", data);
					return data;
				} else {
					return "error";

				}
			} catch (ProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return null;
		}

	}

}
