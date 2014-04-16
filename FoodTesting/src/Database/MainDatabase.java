package Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MainDatabase  extends SQLiteOpenHelper{
	
	private static final String DATABASE_NAME = "foodtesting.db";
	private static final int DATABASE_VERSION = 1;
	
	public MainDatabase(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
		
		arg0.execSQL("CREATE TABLE URL ( url TEXT);");
		arg0.execSQL("INSERT INTO url VALUES('http://food.tartecake.com');");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
