package au.id.teda.androidboilerplate.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseOpenHelper extends SQLiteOpenHelper {
	
	// Debug tag
	//private final String DEBUG_TAG = BaseActivity.DEBUG_TAG;
	
	// If you change the database schema, you must increment the database version.
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "boiler.db";
    
    private static final String BOILER_TABLE_1_CREATE = BoilerTable1Adapter.TABLE_CREATE;
    private static final String BOILER_TABLE_1_DELETE = "DROP TABLE IF EXISTS " + BoilerTable1Adapter.TABLE_NAME;
	
    /**
     * Load database
     * @param context
     */
	public DatabaseOpenHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	/**
	 * Create new database
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(BOILER_TABLE_1_CREATE);

	}

	/**
	 * Upgrade database
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// This can get a lot more complicated if maintaining data with database structure change
		db.execSQL(BOILER_TABLE_1_DELETE);
        onCreate(db);
	}
	
	/**
	 * Downgrade database
	 */
	public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}
