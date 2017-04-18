package com.mongodb.sentes.mongodbviewer.ui.Connection;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import com.mongodb.sentes.mongodbviewer.data.Database.Classes.ConnectionClass;
import com.mongodb.sentes.mongodbviewer.data.Database.ConnectionsDbContract;
import com.mongodb.sentes.mongodbviewer.data.Database.ConnectionsDbHelper;
import com.mongodb.sentes.mongodbviewer.ui.Connection.Base.BasePresenter;

import java.util.ArrayList;

/**
 * Created by Faßreiter on 18.04.2017.
 */

public class ConnectionPresenter extends BasePresenter<ConnectionContract.View> implements ConnectionContract.ViewActions {

    ConnectionsDbHelper mDbHelper;

    public ConnectionPresenter(@NonNull ConnectionsDbHelper mDbHelper) {
        this.mDbHelper = mDbHelper;
    }
    @Override
    public void loadConnection(boolean forceUpdate) {
        if(!isViewAttached())
            return;
        ArrayList<ConnectionClass> list = new ArrayList<ConnectionClass>();
        SQLiteDatabase database = mDbHelper.getReadableDatabase();
        String[] projection = new String[]{"_id", ConnectionsDbContract.ConnectionsDbEntry.COLUMN_DB_NAME, ConnectionsDbContract.ConnectionsDbEntry.COLUMN_SERVER, ConnectionsDbContract.ConnectionsDbEntry.COLUMN_PORT,
                ConnectionsDbContract.ConnectionsDbEntry.COLUMN_USERNAME, ConnectionsDbContract.ConnectionsDbEntry.COLUMN_PW};
        Cursor cursor = database.query("condb", projection, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        try {
            while (cursor.moveToNext()) {
                int idColumnIndex = cursor.getColumnIndex("_id");
                int dbPickColumnIndex = cursor.getColumnIndex(ConnectionsDbContract.ConnectionsDbEntry.COLUMN_DB_NAME);
                int serverPickColumnIndex = cursor.getColumnIndex(ConnectionsDbContract.ConnectionsDbEntry.COLUMN_SERVER);
                int portColumnIndex = cursor.getColumnIndex(ConnectionsDbContract.ConnectionsDbEntry.COLUMN_PORT);
                int usernameColumnIndex = cursor.getColumnIndex(ConnectionsDbContract.ConnectionsDbEntry.COLUMN_USERNAME);
                int pwColumnIndex = cursor.getColumnIndex(ConnectionsDbContract.ConnectionsDbEntry.COLUMN_PW);
                int currentID = cursor.getInt(idColumnIndex);
                String currentDbName = cursor.getString(dbPickColumnIndex);
                String currentServer = cursor.getString(serverPickColumnIndex);
                String currentPort = cursor.getString(portColumnIndex);
                String currentUsername = cursor.getString(usernameColumnIndex);
                String currentPw = cursor.getString(pwColumnIndex);
                list.add(new ConnectionClass(currentDbName, currentServer, currentPort, currentUsername, currentPw));
            }
        } finally {
            cursor.close();
        }
        mView.showConnections(list);

    }

    @Override
    public void newConnection(Context context, Class cls) {
        Intent i = new Intent(context, cls);
        context.startActivity(i);
    }


    @Override
    public void openConnection(@NonNull ConnectionClass requestedConnection) {
        mView.showConnectionDetailUi(requestedConnection);
    }
}
