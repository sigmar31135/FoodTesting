package database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ProductTable {

	private MainDatabase objMainDatabase;
	private SQLiteDatabase ReadData;
	
	public ProductTable(Context context) {
		// TODO Auto-generated constructor stub
		objMainDatabase = new MainDatabase(context);
		ReadData = objMainDatabase.getReadableDatabase();
	}
	
	public Cursor GetDataFormProductId(String product_id){
		
		
		Cursor objCursor = ReadData.query(MainDatabase.ProductTableName, new String[]{MainDatabase.ProductTableColProductId,MainDatabase.ProductTableColImagePath},  null, null, null, null, null);
		objCursor.moveToFirst();
		return objCursor;
	}
	
	
	
}
