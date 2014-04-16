package Database;

import pie.app.foodtesting.R;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DialogSetUrl extends Dialog {

	public DialogSetUrl(final Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		final Dialog objDialog = new Dialog(context);
		objDialog.setContentView(R.layout.set_url);
		objDialog.setTitle("Change url");
		
		
		final EditText objEditText = (EditText) objDialog
				.findViewById(R.id.edtSetUrl);
		
		objEditText.setHint("current url : " + new UrlTable(context).getUrl());
		Button btnOK = (Button) objDialog.findViewById(R.id.btnSetUrlOK);
		Button btnCancel = (Button) objDialog
				.findViewById(R.id.btnSetUrlCancel);

		btnCancel.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				objDialog.cancel();
			}
		});

		btnOK.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(objEditText.getText().toString().equals(""))
				{
					Toast.makeText(context, "Please Insert url.", Toast.LENGTH_SHORT).show();
				}
				else{
					new UrlTable(context).setUrl(objEditText.getText().toString());
				}
			}
		});
		
		objDialog.show();

	}

}
