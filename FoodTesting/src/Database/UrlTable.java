package Database;

import android.R.bool;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UrlTable {
	
	private static MainDatabase objMainDataBase;
	private static SQLiteDatabase ReadDatabase;
	private static SQLiteDatabase WriteDatabase;
	
	public UrlTable(Context context) {
		// TODO Auto-generated constructor stub
		objMainDataBase = new MainDatabase(context);
		ReadDatabase = objMainDataBase.getReadableDatabase();
		WriteDatabase = objMainDataBase.getWritableDatabase();
	}
	
	public String getUrl(){
		
		Cursor objCursor = ReadDatabase.query("URL", new String[]{"url"}, null, null, null, null, null);
		objCursor.moveToFirst();
		if(objCursor.getCount()!=0)
			return objCursor.getString(objCursor.getColumnIndex("url"));
		else
			return "error";
		
	}
	
	public boolean setUrl(String url){
		
		ContentValues values = new ContentValues();
		values.put("url", url);
		WriteDatabase.update("URL", values, null, null);
		
		return false;
		
	}

}
