package com.mongodb.sentes.mongodbviewer.ui.Connection.ConnectionDetail;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.sentes.mongodbviewer.R;
import com.mongodb.sentes.mongodbviewer.data.Database.Classes.ConnectionClass;

import java.net.UnknownHostException;
import java.util.Arrays;

public class ConnectionDetailsActivity extends AppCompatActivity implements ConnectionDetailContract.View {
    private ConnectionDetailsPresenter mActionListener;

    private TextView dbnameView;
    private TextView serverView;
    private TextView portView;

    private String dbname;
    private String server;
    private String port;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection_details);
        Intent i = getIntent();
        ConnectionClass connection = (ConnectionClass) i.getSerializableExtra("connection");

        dbnameView = (TextView) this.findViewById(R.id.details_database);
        serverView = (TextView) this.findViewById(R.id.details_server);
        portView = (TextView) this.findViewById(R.id.details_port);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        mActionListener = new ConnectionDetailsPresenter();
        mActionListener.attachView(this);
        mActionListener.loadConnection(connection);

        MongoCredential credential = MongoCredential.createCredential(connection.getUsername(), connection.getDbname(), connection.getPassword().toCharArray());
        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient(new ServerAddress(connection.getServer(), Integer.parseInt(connection.getPort())), Arrays.asList(credential));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


        DB db = mongoClient.getDB(connection.getDbname());
        Log.v("DB NAME", db.getName());
        DBCollection coll = db.getCollection("test");
        DBCursor cursor = coll.find();
        try {
            while(cursor.hasNext()) {
                System.out.println(cursor.next());
                Log.v("MONGODB", cursor.next().toString());
            }
        } finally {
            cursor.close();
        }



    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu_details, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit_connection:

            case R.id.action_delete_connection:
                ;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void loadIU(ConnectionClass connection) {
        dbnameView.setText(connection.getDbname());
        serverView.setText(connection.getServer());
        portView.setText(connection.getPort());
    }
}
