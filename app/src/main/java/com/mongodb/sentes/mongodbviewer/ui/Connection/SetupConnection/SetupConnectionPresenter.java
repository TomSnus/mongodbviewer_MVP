package com.mongodb.sentes.mongodbviewer.ui.Connection.SetupConnection;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import com.mongodb.sentes.mongodbviewer.data.Database.Classes.ConnectionClass;
import com.mongodb.sentes.mongodbviewer.data.Database.ConnectionsDbContract.ConnectionsDbEntry;
import com.mongodb.sentes.mongodbviewer.data.Database.ConnectionsDbHelper;
import com.mongodb.sentes.mongodbviewer.ui.Connection.Base.BasePresenter;

/**
 * Created by Faßreiter on 18.04.2017.
 */

public class SetupConnectionPresenter extends BasePresenter<SetupConnectionContract.View> implements SetupConnectionContract.ViewActions {

    private ConnectionsDbHelper mDbHelper;

    public SetupConnectionPresenter(ConnectionsDbHelper mDbHelper) {
        this.mDbHelper = mDbHelper;
    }

    @Override
    public void loadConnection(boolean forceUpdate) {

    }

    @Override
    public void saveConnection(@NonNull ConnectionClass requestedConnection) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ConnectionsDbEntry.COLUMN_DB_NAME, requestedConnection.getDbname());
        values.put(ConnectionsDbEntry.COLUMN_SERVER, requestedConnection.getServer());
        values.put(ConnectionsDbEntry.COLUMN_PORT, requestedConnection.getPort());
        values.put(ConnectionsDbEntry.COLUMN_USERNAME, requestedConnection.getUsername());
        values.put(ConnectionsDbEntry.COLUMN_PW, requestedConnection.getPassword());
        long newRodId = db.insert("condb", (String)null, values);
    }


}
