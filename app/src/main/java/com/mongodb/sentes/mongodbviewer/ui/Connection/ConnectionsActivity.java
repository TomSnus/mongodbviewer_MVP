package com.mongodb.sentes.mongodbviewer.ui.Connection;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.mongodb.sentes.mongodbviewer.R;
import com.mongodb.sentes.mongodbviewer.data.Database.Classes.ConnectionClass;
import com.mongodb.sentes.mongodbviewer.data.Database.ConnectionsDbHelper;
import com.mongodb.sentes.mongodbviewer.ui.Connection.SetupConnection.SetupConnectionActivity;

import java.util.ArrayList;

public class ConnectionsActivity extends AppCompatActivity implements ConnectionContract.View{
    private ListView mListView;
    private ArrayList<ConnectionClass> list;
    private ConnectionPresenter mActionListener;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connections);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.mListView = (ListView)this.findViewById(R.id.list);
        mActionListener = new ConnectionPresenter(new ConnectionsDbHelper(this));
        mActionListener.attachView(this);
        mActionListener.loadConnection(true);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mActionListener.newConnection(ConnectionsActivity.this, SetupConnectionActivity.class);
            }
        });
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ConnectionClass current = (ConnectionClass) mListView.getItemAtPosition(position);
                mActionListener.openConnection(current);
            }
        });
    }



    public ArrayList<ConnectionClass> getList() {
        return list;
    }

    @Override
    public void showConnections(ArrayList<ConnectionClass> connections) {
        ConnectionsAdapter conAdapt = new ConnectionsAdapter(this, connections);
        if(this.mListView != null) {
            this.mListView.setAdapter(conAdapt);
        }
    }

    @Override
    public void showAddConnection() {

    }

    @Override
    public void showConnectionDetailUi(ConnectionClass connection) {

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        mActionListener.loadConnection(true);
    }
}
