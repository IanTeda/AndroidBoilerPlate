package au.id.teda.androidboilerplate.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

public class BoilerTable1Adapter {
	
	//private static final String DEBUG_TAG = BaseActivity.DEBUG_TAG;
	
	// Set variables for adapter
	public static final String TABLE_NAME = "boiler_table_1";
	public static final String KEY_ROWID = "_id";
	public static final String ROW1 = "row1";
	public static final String ROW2 = "row2";
	public static final String ROW3 = "row3";
    
	public static final String TABLE_CREATE = 
			"create table " + TABLE_NAME +
			" (" + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ ROW1 + " TEXT NOT NULL, "
			+ ROW2 + " INTEGER UNIQUE, "
			+ ROW3 + " INTEGER NOT NULL);";
	
    private SQLiteDatabase mDatabase;
    private DatabaseOpenHelper mDatabaseHelper;
    
	/**
	 * BoilerTable1Adapter constructor 
	 * @param context
	 */
    public BoilerTable1Adapter (Context context){
    	mDatabaseHelper = new DatabaseOpenHelper(context);
	}
    
    /**
     * Open database. If it cannot be opened, try to create a new. 
     * If it cannot be created, throw an exception to signal the failure
     * @throws SQLException
     */
    public void open() throws SQLException {
    	mDatabase = mDatabaseHelper.getWritableDatabase();
	}
    
    /**
     * Close database
     */
    public void close() {
    	mDatabaseHelper.close();
	}
 
 	public Long addReplaceEntry (String row1, String row2, String row3){
 		String comma = ", ";
 		SQLiteStatement statement = null;
 		
 		String INSERT_STATEMENT = "INSERT OR REPLACE INTO " + TABLE_NAME +
        		" (" + ROW1 + comma + ROW2 + comma + ROW3 + ")" +
        		" VALUES (?,?,?,?,?,?,?)";
 		
 		statement = mDatabase.compileStatement(INSERT_STATEMENT);
 		statement.bindString(1, row1);
        statement.bindString(2, row2);
        statement.bindString(3, row3);
 		
 		// Insert the new row, returning the primary key value of the new row
 		long newRowId;
 		newRowId = statement.executeInsert();
 		statement.close();
 		
 		return newRowId;
 	}

 	
}
