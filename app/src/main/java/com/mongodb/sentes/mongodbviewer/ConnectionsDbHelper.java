package com.mongodb.sentes.mongodbviewer;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Faßreiter on 17.04.2017.
 */

public class ConnectionsDbHelper extends SQLiteOpenHelper{
    private static ConnectionsDbHelper mInstance = null;

    public ConnectionsDbHelper(Context context) {
        super(context, "condb.db", (CursorFactory) null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_CONNECTIONS_TABLE = "CREATE TABLE condb" +
                " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConnectionsDbContract.ConnectionsDbEntry.COLUMN_DB_NAME +" TEXT NOT NULL, " +
                ConnectionsDbContract.ConnectionsDbEntry.COLUMN_SERVER +" TEXT NOT NULL, " +
                ConnectionsDbContract.ConnectionsDbEntry.COLUMN_PORT +" TEXT NOT NULL, " +
                ConnectionsDbContract.ConnectionsDbEntry.COLUMN_USERNAME +" TEXT, " +
                ConnectionsDbContract.ConnectionsDbEntry.COLUMN_PW +" TEXT);";
        db.execSQL(SQL_CREATE_CONNECTIONS_TABLE);
    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int old, int newVersion) {
    }

    public static ConnectionsDbHelper getInstance(Context context){
        if (mInstance == null) {
            mInstance = new ConnectionsDbHelper(context.getApplicationContext());
        }
        return mInstance;
    }
}
