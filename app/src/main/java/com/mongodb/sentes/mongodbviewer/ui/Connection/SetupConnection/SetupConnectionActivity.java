package com.mongodb.sentes.mongodbviewer.ui.Connection.SetupConnection;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mongodb.sentes.mongodbviewer.R;
import com.mongodb.sentes.mongodbviewer.data.Database.Classes.ConnectionClass;
import com.mongodb.sentes.mongodbviewer.data.Database.ConnectionsDbHelper;

import java.sql.Connection;

public class SetupConnectionActivity extends AppCompatActivity implements SetupConnectionContract.View{
    private TextView dbnameView;
    private TextView serverView;
    private TextView portView;
    private TextView usernameView;
    private TextView pwView;
    private Button cancelBtn;
    private Button okBtn;

    private ConnectionsDbHelper mDbHelper;
    private SetupConnectionPresenter mActionListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_connection);
        mDbHelper = new ConnectionsDbHelper(this);
        mActionListener = new SetupConnectionPresenter(mDbHelper);
        mActionListener.attachView(this);
        //getActionBar().setDisplayHomeAsUpEnabled(true);

        dbnameView = (TextView) this.findViewById(R.id.setup_db);
        serverView = (TextView) this.findViewById(R.id.setup_server);
        portView = (TextView) this.findViewById(R.id.setup_port);
        usernameView = (TextView) this.findViewById(R.id.setup_username);
        pwView = (TextView) this.findViewById(R.id.setup_pw);
        cancelBtn = (Button) this.findViewById(R.id.setup_button_cancel);
        okBtn = (Button) this.findViewById(R.id.setup_button_ok);


        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dbname = dbnameView.getText().toString();
                String server = serverView.getText().toString();
                String port = portView.getText().toString();
                String username = usernameView.getText().toString();
                String pw  = pwView.getText().toString();
                ConnectionClass newConnection = new ConnectionClass(dbname, server, port, username, pw);
                mActionListener.saveConnection(newConnection);
                finish();
            }
        });
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void showEditConnections(Connection connections) {

    }
}
