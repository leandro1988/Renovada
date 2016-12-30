package info.androidhive.renovada.database;

/**
 * Created by leandro on 20/12/16.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Membros";


    public DataBaseHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate( SQLiteDatabase db ) {

        db.execSQL(ScripSQL.getCreateContato());

    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL( "DROP TABLE IF EXISTS MEMBROS"  );

        // Create tables again
        onCreate( db );

    }



}
