package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MainDatabase extends SQLiteOpenHelper{
	
	private static final String DatabaseName = "FoodTestingDB";
	private static final int DatabaseVersion = 1;
	
	public static final String ProductTableName = "Product";
	public static final String ProductTableColProductId = "product_id";
	public static final String ProductTableColImagePath = "image_path";
	
	public static final String TestTableName = "Test";
	public static final String TestTableColTestId = "test_id";
	public static final String TestTableColProductId = "product_id";
	
	public static final String AttributeOfTestTableName = "AttibuteOfTest";
	public static final String AttributeOfTestTableColTestId = "test_id";
	public static final String AttributeOfTestTableColAttributeId = "attribute_id";
	public static final String AttributeOfTestTableColMinAv = "min_av";
	public static final String AttributeOfTestTableColMaxAv = "max_av";
	public static final String AttributeOfTestTableColMax = "max";
	
	public static final String AttributeTableName = "Attribute";
	public static final String AttributeTableColAttributeId = "attribute_id";
	public static final String AttributeTableColAttributeName = "attribute_name";
	public static final String AttributeTableColAttributeDetail = "attribute_detail";
	public static final String AttributeTableColAttributeGroup = "group_id";
	
	public static final String UserTestTableName = "UserTest";
	public static final String UserTestTableColUserId = "user_id";
	public static final String UserTestTableColTestId = "test_id";
	public static final String UserTestTableColAttributeId = "attribute_id";
	public static final String UserTestTableColScore = "score";
	
	public static final String UserTableName = "User";
	public static final String UserTableColUserId = "user_id";
	public static final String UserTableColUser = "user";
	public static final String UserTableColPassword = "password";
	
	public static final String AttributeGroupTableName = "AttributeGroup";
	public static final String AttributeGroupTableColGroupId = "group_id";
	public static final String AttributeGroupTableColGroupName = "group_name";
	
	

	public MainDatabase(Context context) {
		super(context, DatabaseName, null, DatabaseVersion);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE " + ProductTableName + " (" + ProductTableColProductId + " TEXT PRIMARY KEY," + ProductTableColImagePath + " TEXT);");
		db.execSQL("INSERT INTO " + ProductTableName + " (" + ProductTableColProductId + ", " + ProductTableColImagePath + ") VALUES ('1024','http://3.bp.blogspot.com/-joQ3GftyrT0/UEoK6CxLjzI/AAAAAAAABWw/X-FYXyJqhWw/s1600/%E0%B8%A3%E0%B8%B9%E0%B9%89%E0%B8%AB%E0%B8%A3%E0%B8%B7%E0%B8%AD%E0%B8%A2%E0%B8%B1%E0%B8%87%E0%B8%81%E0%B8%B4%E0%B8%99%E0%B9%82%E0%B8%A2%E0%B9%80%E0%B8%81%E0%B8%B4%E0%B8%A3%E0%B9%8C%E0%B8%95%E0%B8%A1%E0%B8%B5%E0%B8%9B%E0%B8%A3%E0%B8%B0%E0%B9%82%E0%B8%A2%E0%B8%8A%E0%B8%99%E0%B9%8C%E0%B8%AD%E0%B8%A2%E0%B9%88%E0%B8%B2%E0%B8%87%E0%B9%84%E0%B8%A3.jpg');");
		db.execSQL("INSERT INTO " + ProductTableName + " (" + ProductTableColProductId + ", " + ProductTableColImagePath + ") VALUES ('2028','http://www.doyouknow.in.th/wp-content/uploads/2013/05/yogurt-101.jpg');");
		
		db.execSQL("CREATE TABLE " + TestTableName + " (" + TestTableColTestId + " TEXT PRIMARY KEY," + TestTableColProductId + " TEXT);");
		db.execSQL("INSERT INTO " + TestTableName + " (" + TestTableColTestId + ", " + TestTableColProductId + ") VALUES ('101','1024');");
		db.execSQL("INSERT INTO " + TestTableName + " (" + TestTableColTestId + ", " + TestTableColProductId + ") VALUES ('102','1024');");
		db.execSQL("INSERT INTO " + TestTableName + " (" + TestTableColTestId + ", " + TestTableColProductId + ") VALUES ('201','2028');");
		
		db.execSQL("CREATE TABLE " + AttributeOfTestTableName + " (" + AttributeOfTestTableColTestId + " TEXT," + AttributeOfTestTableColAttributeId + " TEXT," + AttributeOfTestTableColMinAv + " FLOAT," + AttributeOfTestTableColMaxAv + " FLOAT," + AttributeOfTestTableColMax + " INT);");	
		db.execSQL("INSERT INTO " + AttributeOfTestTableName + " (" + AttributeOfTestTableColTestId + ", " + AttributeOfTestTableColAttributeId + ", " + AttributeOfTestTableColMinAv + ", " + AttributeOfTestTableColMaxAv + ", " + AttributeOfTestTableColMax + ") VALUES ('101','1',4,10,15);");
		db.execSQL("INSERT INTO " + AttributeOfTestTableName + " (" + AttributeOfTestTableColTestId + ", " + AttributeOfTestTableColAttributeId + ", " + AttributeOfTestTableColMinAv + ", " + AttributeOfTestTableColMaxAv + ", " + AttributeOfTestTableColMax + ") VALUES ('101','2',3.5,12,15);");
		db.execSQL("INSERT INTO " + AttributeOfTestTableName + " (" + AttributeOfTestTableColTestId + ", " + AttributeOfTestTableColAttributeId + ", " + AttributeOfTestTableColMinAv + ", " + AttributeOfTestTableColMaxAv + ", " + AttributeOfTestTableColMax + ") VALUES ('101','3',6,9,15);");
		db.execSQL("INSERT INTO " + AttributeOfTestTableName + " (" + AttributeOfTestTableColTestId + ", " + AttributeOfTestTableColAttributeId + ", " + AttributeOfTestTableColMinAv + ", " + AttributeOfTestTableColMaxAv + ", " + AttributeOfTestTableColMax + ") VALUES ('101','4',3,7,15);");
		db.execSQL("INSERT INTO " + AttributeOfTestTableName + " (" + AttributeOfTestTableColTestId + ", " + AttributeOfTestTableColAttributeId + ", " + AttributeOfTestTableColMinAv + ", " + AttributeOfTestTableColMaxAv + ", " + AttributeOfTestTableColMax + ") VALUES ('101','5',5,7,15);");
		db.execSQL("INSERT INTO " + AttributeOfTestTableName + " (" + AttributeOfTestTableColTestId + ", " + AttributeOfTestTableColAttributeId + ", " + AttributeOfTestTableColMinAv + ", " + AttributeOfTestTableColMaxAv + ", " + AttributeOfTestTableColMax + ") VALUES ('101','6',5,5,15);");
		db.execSQL("INSERT INTO " + AttributeOfTestTableName + " (" + AttributeOfTestTableColTestId + ", " + AttributeOfTestTableColAttributeId + ", " + AttributeOfTestTableColMinAv + ", " + AttributeOfTestTableColMaxAv + ", " + AttributeOfTestTableColMax + ") VALUES ('101','7',4,4,15);");
		db.execSQL("INSERT INTO " + AttributeOfTestTableName + " (" + AttributeOfTestTableColTestId + ", " + AttributeOfTestTableColAttributeId + ", " + AttributeOfTestTableColMinAv + ", " + AttributeOfTestTableColMaxAv + ", " + AttributeOfTestTableColMax + ") VALUES ('101','8',2.5,2.5,15);");
		db.execSQL("INSERT INTO " + AttributeOfTestTableName + " (" + AttributeOfTestTableColTestId + ", " + AttributeOfTestTableColAttributeId + ", " + AttributeOfTestTableColMinAv + ", " + AttributeOfTestTableColMaxAv + ", " + AttributeOfTestTableColMax + ") VALUES ('102','1',4,10,15);");
		db.execSQL("INSERT INTO " + AttributeOfTestTableName + " (" + AttributeOfTestTableColTestId + ", " + AttributeOfTestTableColAttributeId + ", " + AttributeOfTestTableColMinAv + ", " + AttributeOfTestTableColMaxAv + ", " + AttributeOfTestTableColMax + ") VALUES ('102','2',3.5,12,15);");
		db.execSQL("INSERT INTO " + AttributeOfTestTableName + " (" + AttributeOfTestTableColTestId + ", " + AttributeOfTestTableColAttributeId + ", " + AttributeOfTestTableColMinAv + ", " + AttributeOfTestTableColMaxAv + ", " + AttributeOfTestTableColMax + ") VALUES ('102','3',6,9,15);");
		db.execSQL("INSERT INTO " + AttributeOfTestTableName + " (" + AttributeOfTestTableColTestId + ", " + AttributeOfTestTableColAttributeId + ", " + AttributeOfTestTableColMinAv + ", " + AttributeOfTestTableColMaxAv + ", " + AttributeOfTestTableColMax + ") VALUES ('102','4',3,7,15);");
		db.execSQL("INSERT INTO " + AttributeOfTestTableName + " (" + AttributeOfTestTableColTestId + ", " + AttributeOfTestTableColAttributeId + ", " + AttributeOfTestTableColMinAv + ", " + AttributeOfTestTableColMaxAv + ", " + AttributeOfTestTableColMax + ") VALUES ('102','5',5,7,15);");
		db.execSQL("INSERT INTO " + AttributeOfTestTableName + " (" + AttributeOfTestTableColTestId + ", " + AttributeOfTestTableColAttributeId + ", " + AttributeOfTestTableColMinAv + ", " + AttributeOfTestTableColMaxAv + ", " + AttributeOfTestTableColMax + ") VALUES ('102','6',5,5,15);");
		db.execSQL("INSERT INTO " + AttributeOfTestTableName + " (" + AttributeOfTestTableColTestId + ", " + AttributeOfTestTableColAttributeId + ", " + AttributeOfTestTableColMinAv + ", " + AttributeOfTestTableColMaxAv + ", " + AttributeOfTestTableColMax + ") VALUES ('102','7',4,4,15);");
		db.execSQL("INSERT INTO " + AttributeOfTestTableName + " (" + AttributeOfTestTableColTestId + ", " + AttributeOfTestTableColAttributeId + ", " + AttributeOfTestTableColMinAv + ", " + AttributeOfTestTableColMaxAv + ", " + AttributeOfTestTableColMax + ") VALUES ('102','8',2.5,2.5,15);");
		db.execSQL("INSERT INTO " + AttributeOfTestTableName + " (" + AttributeOfTestTableColTestId + ", " + AttributeOfTestTableColAttributeId + ", " + AttributeOfTestTableColMinAv + ", " + AttributeOfTestTableColMaxAv + ", " + AttributeOfTestTableColMax + ") VALUES ('201','1',4,10,15);");
		db.execSQL("INSERT INTO " + AttributeOfTestTableName + " (" + AttributeOfTestTableColTestId + ", " + AttributeOfTestTableColAttributeId + ", " + AttributeOfTestTableColMinAv + ", " + AttributeOfTestTableColMaxAv + ", " + AttributeOfTestTableColMax + ") VALUES ('201','2',3.5,12,15);");
		db.execSQL("INSERT INTO " + AttributeOfTestTableName + " (" + AttributeOfTestTableColTestId + ", " + AttributeOfTestTableColAttributeId + ", " + AttributeOfTestTableColMinAv + ", " + AttributeOfTestTableColMaxAv + ", " + AttributeOfTestTableColMax + ") VALUES ('201','3',6,9,15);");
		db.execSQL("INSERT INTO " + AttributeOfTestTableName + " (" + AttributeOfTestTableColTestId + ", " + AttributeOfTestTableColAttributeId + ", " + AttributeOfTestTableColMinAv + ", " + AttributeOfTestTableColMaxAv + ", " + AttributeOfTestTableColMax + ") VALUES ('201','4',3,7,15);");
		db.execSQL("INSERT INTO " + AttributeOfTestTableName + " (" + AttributeOfTestTableColTestId + ", " + AttributeOfTestTableColAttributeId + ", " + AttributeOfTestTableColMinAv + ", " + AttributeOfTestTableColMaxAv + ", " + AttributeOfTestTableColMax + ") VALUES ('201','5',5,7,15);");
		db.execSQL("INSERT INTO " + AttributeOfTestTableName + " (" + AttributeOfTestTableColTestId + ", " + AttributeOfTestTableColAttributeId + ", " + AttributeOfTestTableColMinAv + ", " + AttributeOfTestTableColMaxAv + ", " + AttributeOfTestTableColMax + ") VALUES ('201','6',5,5,15);");
		db.execSQL("INSERT INTO " + AttributeOfTestTableName + " (" + AttributeOfTestTableColTestId + ", " + AttributeOfTestTableColAttributeId + ", " + AttributeOfTestTableColMinAv + ", " + AttributeOfTestTableColMaxAv + ", " + AttributeOfTestTableColMax + ") VALUES ('201','7',4,4,15);");
		db.execSQL("INSERT INTO " + AttributeOfTestTableName + " (" + AttributeOfTestTableColTestId + ", " + AttributeOfTestTableColAttributeId + ", " + AttributeOfTestTableColMinAv + ", " + AttributeOfTestTableColMaxAv + ", " + AttributeOfTestTableColMax + ") VALUES ('201','8',2.5,2.5,15);");
		db.execSQL("INSERT INTO " + AttributeOfTestTableName + " (" + AttributeOfTestTableColTestId + ", " + AttributeOfTestTableColAttributeId + ", " + AttributeOfTestTableColMinAv + ", " + AttributeOfTestTableColMaxAv + ", " + AttributeOfTestTableColMax + ") VALUES ('201','21',3.5,3.5,15);");
		db.execSQL("INSERT INTO " + AttributeOfTestTableName + " (" + AttributeOfTestTableColTestId + ", " + AttributeOfTestTableColAttributeId + ", " + AttributeOfTestTableColMinAv + ", " + AttributeOfTestTableColMaxAv + ", " + AttributeOfTestTableColMax + ") VALUES ('201','22',2.5,6,15);");
		db.execSQL("INSERT INTO " + AttributeOfTestTableName + " (" + AttributeOfTestTableColTestId + ", " + AttributeOfTestTableColAttributeId + ", " + AttributeOfTestTableColMinAv + ", " + AttributeOfTestTableColMaxAv + ", " + AttributeOfTestTableColMax + ") VALUES ('201','23',5,5,15);");
		db.execSQL("INSERT INTO " + AttributeOfTestTableName + " (" + AttributeOfTestTableColTestId + ", " + AttributeOfTestTableColAttributeId + ", " + AttributeOfTestTableColMinAv + ", " + AttributeOfTestTableColMaxAv + ", " + AttributeOfTestTableColMax + ") VALUES ('201','24',4.5,9,15);");
		db.execSQL("INSERT INTO " + AttributeOfTestTableName + " (" + AttributeOfTestTableColTestId + ", " + AttributeOfTestTableColAttributeId + ", " + AttributeOfTestTableColMinAv + ", " + AttributeOfTestTableColMaxAv + ", " + AttributeOfTestTableColMax + ") VALUES ('201','25',4,6.5,15);");
		db.execSQL("INSERT INTO " + AttributeOfTestTableName + " (" + AttributeOfTestTableColTestId + ", " + AttributeOfTestTableColAttributeId + ", " + AttributeOfTestTableColMinAv + ", " + AttributeOfTestTableColMaxAv + ", " + AttributeOfTestTableColMax + ") VALUES ('201','26',7,7,15);");
		db.execSQL("INSERT INTO " + AttributeOfTestTableName + " (" + AttributeOfTestTableColTestId + ", " + AttributeOfTestTableColAttributeId + ", " + AttributeOfTestTableColMinAv + ", " + AttributeOfTestTableColMaxAv + ", " + AttributeOfTestTableColMax + ") VALUES ('201','27',1,7,15);");
		db.execSQL("INSERT INTO " + AttributeOfTestTableName + " (" + AttributeOfTestTableColTestId + ", " + AttributeOfTestTableColAttributeId + ", " + AttributeOfTestTableColMinAv + ", " + AttributeOfTestTableColMaxAv + ", " + AttributeOfTestTableColMax + ") VALUES ('201','28',4,7,15);");
		
		db.execSQL("CREATE TABLE " + AttributeTableName + " (" + AttributeTableColAttributeId + " TEXT PRIMARY KEY," + AttributeTableColAttributeName + " TEXT," + AttributeTableColAttributeDetail+ " TEXT," + AttributeTableColAttributeGroup + " TEXT);");	
		db.execSQL("INSERT INTO " + AttributeTableName + " (" + AttributeTableColAttributeId + ", " + AttributeTableColAttributeName + ", " + AttributeTableColAttributeDetail + ", " + AttributeTableColAttributeGroup + ") VALUES ('1','สีครีม/off white','ggnsogo','1');");
		db.execSQL("INSERT INTO " + AttributeTableName + " (" + AttributeTableColAttributeId + ", " + AttributeTableColAttributeName + ", " + AttributeTableColAttributeDetail + ", " + AttributeTableColAttributeGroup + ") VALUES ('2','ความมันวาว','ggnsogo','1');");
		db.execSQL("INSERT INTO " + AttributeTableName + " (" + AttributeTableColAttributeId + ", " + AttributeTableColAttributeName + ", " + AttributeTableColAttributeDetail + ", " + AttributeTableColAttributeGroup + ") VALUES ('3','Dairy product','ggnsogo','2');");
		db.execSQL("INSERT INTO " + AttributeTableName + " (" + AttributeTableColAttributeId + ", " + AttributeTableColAttributeName + ", " + AttributeTableColAttributeDetail + ", " + AttributeTableColAttributeGroup + ") VALUES ('4','หวาน','ggnsogo','2');");
		db.execSQL("INSERT INTO " + AttributeTableName + " (" + AttributeTableColAttributeId + ", " + AttributeTableColAttributeName + ", " + AttributeTableColAttributeDetail + ", " + AttributeTableColAttributeGroup + ") VALUES ('5','เปรี้ยว','ggnsogo','2');");
		db.execSQL("INSERT INTO " + AttributeTableName + " (" + AttributeTableColAttributeId + ", " + AttributeTableColAttributeName + ", " + AttributeTableColAttributeDetail + ", " + AttributeTableColAttributeGroup + ") VALUES ('6','Butyric acid','ggnsogo','2');");
		db.execSQL("INSERT INTO " + AttributeTableName + " (" + AttributeTableColAttributeId + ", " + AttributeTableColAttributeName + ", " + AttributeTableColAttributeDetail + ", " + AttributeTableColAttributeGroup + ") VALUES ('7','Fermented','ggnsogo','2');");
		db.execSQL("INSERT INTO " + AttributeTableName + " (" + AttributeTableColAttributeId + ", " + AttributeTableColAttributeName + ", " + AttributeTableColAttributeDetail + ", " + AttributeTableColAttributeGroup + ") VALUES ('8','Floral','ggnsogo','2');");
		db.execSQL("INSERT INTO " + AttributeTableName + " (" + AttributeTableColAttributeId + ", " + AttributeTableColAttributeName + ", " + AttributeTableColAttributeDetail + ", " + AttributeTableColAttributeGroup + ") VALUES ('21','Brown','ggnsogo','3');");
		db.execSQL("INSERT INTO " + AttributeTableName + " (" + AttributeTableColAttributeId + ", " + AttributeTableColAttributeName + ", " + AttributeTableColAttributeDetail + ", " + AttributeTableColAttributeGroup + ") VALUES ('22','Fruity','ggnsogo','3');");
		db.execSQL("INSERT INTO " + AttributeTableName + " (" + AttributeTableColAttributeId + ", " + AttributeTableColAttributeName + ", " + AttributeTableColAttributeDetail + ", " + AttributeTableColAttributeGroup + ") VALUES ('23','Chemical','ggnsogo','3');");
		db.execSQL("INSERT INTO " + AttributeTableName + " (" + AttributeTableColAttributeId + ", " + AttributeTableColAttributeName + ", " + AttributeTableColAttributeDetail + ", " + AttributeTableColAttributeGroup + ") VALUES ('24','Citrus','ggnsogo','3');");
		db.execSQL("INSERT INTO " + AttributeTableName + " (" + AttributeTableColAttributeId + ", " + AttributeTableColAttributeName + ", " + AttributeTableColAttributeDetail + ", " + AttributeTableColAttributeGroup + ") VALUES ('25','วานิลา','ggnsogo','3');");
		db.execSQL("INSERT INTO " + AttributeTableName + " (" + AttributeTableColAttributeId + ", " + AttributeTableColAttributeName + ", " + AttributeTableColAttributeDetail + ", " + AttributeTableColAttributeGroup + ") VALUES ('26','Musty','ggnsogo','3');");
		db.execSQL("INSERT INTO " + AttributeTableName + " (" + AttributeTableColAttributeId + ", " + AttributeTableColAttributeName + ", " + AttributeTableColAttributeDetail + ", " + AttributeTableColAttributeGroup + ") VALUES ('27','ความหนืด/Viscosity','ggnsogo','4');");
		db.execSQL("INSERT INTO " + AttributeTableName + " (" + AttributeTableColAttributeId + ", " + AttributeTableColAttributeName + ", " + AttributeTableColAttributeDetail + ", " + AttributeTableColAttributeGroup + ") VALUES ('28','ความรู้สึกมัน','ggnsogo','4');");
		
		db.execSQL("CREATE TABLE " + UserTestTableName + " (" + UserTestTableColUserId + " TEXT," + UserTestTableColTestId + " TEXT," + UserTestTableColAttributeId+ " TEXT," + UserTestTableColScore + " FLOAT);");
		db.execSQL("INSERT INTO " + UserTestTableName + " (" + UserTestTableColUserId + ", " + UserTestTableColTestId + ", " + UserTestTableColAttributeId+ ", " + UserTestTableColScore + ") VALUES('10','101','1',2);");	
		db.execSQL("INSERT INTO " + UserTestTableName + " (" + UserTestTableColUserId + ", " + UserTestTableColTestId + ", " + UserTestTableColAttributeId+ ", " + UserTestTableColScore + ") VALUES('10','101','2',8);");		
		db.execSQL("INSERT INTO " + UserTestTableName + " (" + UserTestTableColUserId + ", " + UserTestTableColTestId + ", " + UserTestTableColAttributeId+ ", " + UserTestTableColScore + ") VALUES('10','101','3',4.5);");		
		db.execSQL("INSERT INTO " + UserTestTableName + " (" + UserTestTableColUserId + ", " + UserTestTableColTestId + ", " + UserTestTableColAttributeId+ ", " + UserTestTableColScore + ") VALUES('10','101','4',2.5);");		
		db.execSQL("INSERT INTO " + UserTestTableName + " (" + UserTestTableColUserId + ", " + UserTestTableColTestId + ", " + UserTestTableColAttributeId+ ", " + UserTestTableColScore + ") VALUES('10','101','5',3);");		
		db.execSQL("INSERT INTO " + UserTestTableName + " (" + UserTestTableColUserId + ", " + UserTestTableColTestId + ", " + UserTestTableColAttributeId+ ", " + UserTestTableColScore + ") VALUES('10','101','6',2);");		
		db.execSQL("INSERT INTO " + UserTestTableName + " (" + UserTestTableColUserId + ", " + UserTestTableColTestId + ", " + UserTestTableColAttributeId+ ", " + UserTestTableColScore + ") VALUES('10','101','7',2.5);");		
		db.execSQL("INSERT INTO " + UserTestTableName + " (" + UserTestTableColUserId + ", " + UserTestTableColTestId + ", " + UserTestTableColAttributeId+ ", " + UserTestTableColScore + ") VALUES('10','101','8',1);");
		db.execSQL("INSERT INTO " + UserTestTableName + " (" + UserTestTableColUserId + ", " + UserTestTableColTestId + ", " + UserTestTableColAttributeId+ ", " + UserTestTableColScore + ") VALUES('10','201','1',0);");		
		db.execSQL("INSERT INTO " + UserTestTableName + " (" + UserTestTableColUserId + ", " + UserTestTableColTestId + ", " + UserTestTableColAttributeId+ ", " + UserTestTableColScore + ") VALUES('10','201','2',0);");		
		db.execSQL("INSERT INTO " + UserTestTableName + " (" + UserTestTableColUserId + ", " + UserTestTableColTestId + ", " + UserTestTableColAttributeId+ ", " + UserTestTableColScore + ") VALUES('10','201','3',0);");		
		db.execSQL("INSERT INTO " + UserTestTableName + " (" + UserTestTableColUserId + ", " + UserTestTableColTestId + ", " + UserTestTableColAttributeId+ ", " + UserTestTableColScore + ") VALUES('10','201','4',0);");		
		db.execSQL("INSERT INTO " + UserTestTableName + " (" + UserTestTableColUserId + ", " + UserTestTableColTestId + ", " + UserTestTableColAttributeId+ ", " + UserTestTableColScore + ") VALUES('10','201','5',0);");		
		db.execSQL("INSERT INTO " + UserTestTableName + " (" + UserTestTableColUserId + ", " + UserTestTableColTestId + ", " + UserTestTableColAttributeId+ ", " + UserTestTableColScore + ") VALUES('10','201','6',0);");		
		db.execSQL("INSERT INTO " + UserTestTableName + " (" + UserTestTableColUserId + ", " + UserTestTableColTestId + ", " + UserTestTableColAttributeId+ ", " + UserTestTableColScore + ") VALUES('10','201','7',0);");		
		db.execSQL("INSERT INTO " + UserTestTableName + " (" + UserTestTableColUserId + ", " + UserTestTableColTestId + ", " + UserTestTableColAttributeId+ ", " + UserTestTableColScore + ") VALUES('10','201','8',0);");		
		db.execSQL("INSERT INTO " + UserTestTableName + " (" + UserTestTableColUserId + ", " + UserTestTableColTestId + ", " + UserTestTableColAttributeId+ ", " + UserTestTableColScore + ") VALUES('10','201','21',0);");		
		db.execSQL("INSERT INTO " + UserTestTableName + " (" + UserTestTableColUserId + ", " + UserTestTableColTestId + ", " + UserTestTableColAttributeId+ ", " + UserTestTableColScore + ") VALUES('10','201','22',0);");		
		db.execSQL("INSERT INTO " + UserTestTableName + " (" + UserTestTableColUserId + ", " + UserTestTableColTestId + ", " + UserTestTableColAttributeId+ ", " + UserTestTableColScore + ") VALUES('10','201','23',0);");		
		db.execSQL("INSERT INTO " + UserTestTableName + " (" + UserTestTableColUserId + ", " + UserTestTableColTestId + ", " + UserTestTableColAttributeId+ ", " + UserTestTableColScore + ") VALUES('10','201','24',0);");		
		db.execSQL("INSERT INTO " + UserTestTableName + " (" + UserTestTableColUserId + ", " + UserTestTableColTestId + ", " + UserTestTableColAttributeId+ ", " + UserTestTableColScore + ") VALUES('10','201','25',0);");		
		db.execSQL("INSERT INTO " + UserTestTableName + " (" + UserTestTableColUserId + ", " + UserTestTableColTestId + ", " + UserTestTableColAttributeId+ ", " + UserTestTableColScore + ") VALUES('10','201','26',0);");		
		db.execSQL("INSERT INTO " + UserTestTableName + " (" + UserTestTableColUserId + ", " + UserTestTableColTestId + ", " + UserTestTableColAttributeId+ ", " + UserTestTableColScore + ") VALUES('10','201','27',0);");		
		db.execSQL("INSERT INTO " + UserTestTableName + " (" + UserTestTableColUserId + ", " + UserTestTableColTestId + ", " + UserTestTableColAttributeId+ ", " + UserTestTableColScore + ") VALUES('10','101','28',0);");
		db.execSQL("INSERT INTO " + UserTestTableName + " (" + UserTestTableColUserId + ", " + UserTestTableColTestId + ", " + UserTestTableColAttributeId+ ", " + UserTestTableColScore + ") VALUES('20','102','1',0);");		
		db.execSQL("INSERT INTO " + UserTestTableName + " (" + UserTestTableColUserId + ", " + UserTestTableColTestId + ", " + UserTestTableColAttributeId+ ", " + UserTestTableColScore + ") VALUES('20','102','2',0);");		
		db.execSQL("INSERT INTO " + UserTestTableName + " (" + UserTestTableColUserId + ", " + UserTestTableColTestId + ", " + UserTestTableColAttributeId+ ", " + UserTestTableColScore + ") VALUES('20','102','3',0);");		
		db.execSQL("INSERT INTO " + UserTestTableName + " (" + UserTestTableColUserId + ", " + UserTestTableColTestId + ", " + UserTestTableColAttributeId+ ", " + UserTestTableColScore + ") VALUES('20','102','4',0);");		
		db.execSQL("INSERT INTO " + UserTestTableName + " (" + UserTestTableColUserId + ", " + UserTestTableColTestId + ", " + UserTestTableColAttributeId+ ", " + UserTestTableColScore + ") VALUES('20','102','5',0);");		
		db.execSQL("INSERT INTO " + UserTestTableName + " (" + UserTestTableColUserId + ", " + UserTestTableColTestId + ", " + UserTestTableColAttributeId+ ", " + UserTestTableColScore + ") VALUES('20','102','6',0);");		
		db.execSQL("INSERT INTO " + UserTestTableName + " (" + UserTestTableColUserId + ", " + UserTestTableColTestId + ", " + UserTestTableColAttributeId+ ", " + UserTestTableColScore + ") VALUES('20','102','7',0);");		
		db.execSQL("INSERT INTO " + UserTestTableName + " (" + UserTestTableColUserId + ", " + UserTestTableColTestId + ", " + UserTestTableColAttributeId+ ", " + UserTestTableColScore + ") VALUES('20','102','8',0);");
		
		db.execSQL("CREATE TABLE " + UserTableName + " (" + UserTableColUserId + " TEXT PRIMARY KEY," + UserTableColUser + " TEXT," + UserTableColPassword + " TEXT);");
		db.execSQL("INSERT INTO " + UserTableName + " (" + UserTableColUserId + ", " + UserTableColUser + ", " + UserTableColPassword + ") VALUES('10','sigmar','gggggggg');");
		db.execSQL("INSERT INTO " + UserTableName + " (" + UserTableColUserId + ", " + UserTableColUser + ", " + UserTableColPassword + ") VALUES('20','test','test');");
		
		db.execSQL("CREATE TABLE " + AttributeGroupTableName + " (" + AttributeGroupTableColGroupId + " TEXT PRIMARY KEY," + AttributeGroupTableColGroupName + " TEXT);");
		db.execSQL("INSERT INTO " + AttributeGroupTableName + " (" + AttributeGroupTableColGroupId + ", " + AttributeGroupTableColGroupName + ") VALUES('1','ลักษณะปรากฏ');");
		db.execSQL("INSERT INTO " + AttributeGroupTableName + " (" + AttributeGroupTableColGroupId + ", " + AttributeGroupTableColGroupName + ") VALUES('2','กลิ่น');");
		db.execSQL("INSERT INTO " + AttributeGroupTableName + " (" + AttributeGroupTableColGroupId + ", " + AttributeGroupTableColGroupName + ") VALUES('3','กลิ่นรส');");
		db.execSQL("INSERT INTO " + AttributeGroupTableName + " (" + AttributeGroupTableColGroupId + ", " + AttributeGroupTableColGroupName + ") VALUES('4','เนื้อสัมผัส');");
		
		
		
		Log.d("GGGGGG","DatabaseCreated");
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
	
		db.execSQL("DROP TABLE IF EXISTS");
		onCreate(db);
	}

}
