package com.mongodb.sentes.mongodbviewer;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class ConnectionsActivity extends AppCompatActivity {
    private ListView mListView;
    private ArrayList<Connection> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connections);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.list = initConnections();
        this.mListView = (ListView)this.findViewById(R.id.list);
        ConnectionsAdapter conAdapt = new ConnectionsAdapter(this, list);
        if(this.mListView != null) {
            this.mListView.setAdapter(conAdapt);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ConnectionsActivity.this, SetupConnectionActivity.class);
                startActivity(i);

            }
        });
    }

    private ArrayList<Connection> initConnections() {
        list = new ArrayList<Connection>();
        ConnectionsDbHelper db = ConnectionsDbHelper.getInstance(this);
        SQLiteDatabase database = db.getReadableDatabase();
        String[] projection = new String[]{"_id", ConnectionsDbContract.ConnectionsDbEntry.COLUMN_DB_NAME, ConnectionsDbContract.ConnectionsDbEntry.COLUMN_SERVER, ConnectionsDbContract.ConnectionsDbEntry.COLUMN_PORT};
        Cursor cursor = database.query("condb", projection, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        try {
            while (cursor.moveToNext()) {
                int idColumnIndex = cursor.getColumnIndex("_id");
                int dbPickColumnIndex = cursor.getColumnIndex(ConnectionsDbContract.ConnectionsDbEntry.COLUMN_DB_NAME);
                int serverPickColumnIndex = cursor.getColumnIndex(ConnectionsDbContract.ConnectionsDbEntry.COLUMN_SERVER);
                int portColumnIndex = cursor.getColumnIndex(ConnectionsDbContract.ConnectionsDbEntry.COLUMN_PORT);
                int currentID = cursor.getInt(idColumnIndex);
                String currentDbName = cursor.getString(dbPickColumnIndex);
                String currentServer = cursor.getString(serverPickColumnIndex);
                String currentPort = cursor.getString(portColumnIndex);
                list.add(new Connection(currentDbName, currentServer, currentPort));
            }
        } finally {
            cursor.close();
        }
        return list;
    }

    public ArrayList<Connection> getList() {
        return list;
    }
}
