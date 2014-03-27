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
	
	public ArrayList<String[]> GetTestIdFormUserId(String user_id){
		
		ArrayList<String[]> output = new ArrayList<String[]>();
		String test_id,score;
		Cursor objCursor = ReadData.query(MainDatabase.UserTestTableName, new String[]{MainDatabase.UserTestTableColTestId , "MAX(" + MainDatabase.UserTestTableColScore + ")" }, MainDatabase.UserTestTableColUserId + " ='" + user_id +"'", null , MainDatabase.UserTestTableColTestId , null, null);
		objCursor.moveToFirst();
		while(true){
			
			test_id = objCursor.getString(objCursor.getColumnIndex(MainDatabase.UserTestTableColTestId));
			score = objCursor.getString(1);
			output.add(new String[]{test_id,score});
			if(objCursor.isLast())
				break;
			objCursor.moveToNext();
		}
		
		return output;
	}
	
	
	
}
