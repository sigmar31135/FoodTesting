package database;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class UserTest {

	
	private MainDatabase objMainDatabase;
	private SQLiteDatabase ReadData;
	
	public UserTest(Context context) {
		// TODO Auto-generated constructor stub
		objMainDatabase = new MainDatabase(context);
		ReadData = objMainDatabase.getReadableDatabase();
	}
	
	public ArrayList<String> GetTestIdFormUserId(String user_id){
		
		ArrayList<String> output = new ArrayList<String>(); 
		Cursor objCursor = ReadData.query(MainDatabase.UserTestTableName, new String[]{MainDatabase.UserTestTableColTestId	}, MainDatabase.UserTestTableColUserId + " ='" + user_id +"'", null , MainDatabase.UserTestTableColTestId , null, null);
		objCursor.moveToFirst();
		while(true){
			output.add(objCursor.getString(objCursor.getColumnIndex(MainDatabase.UserTestTableColTestId)));
			if(objCursor.isLast())
				break;
			objCursor.moveToNext();
		}
		return output;
	}
	
	
	
}
