package com.mongodb.sentes.mongodbviewer;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mongodb.sentes.mongodbviewer.ConnectionsDbContract.ConnectionsDbEntry;

public class SetupConnectionActivity extends AppCompatActivity {
    private TextView dbnameView;
    private TextView serverView;
    private TextView portView;
    private TextView usernameView;
    private TextView pwView;
    private Button cancelBtn;
    private Button okBtn;

    private ConnectionsDbHelper mDbHelper;
    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_connection);
        mDbHelper = new ConnectionsDbHelper(this);

        //getActionBar().setDisplayHomeAsUpEnabled(true);

        dbnameView = (TextView) this.findViewById(R.id.setup_db);
        serverView = (TextView) this.findViewById(R.id.setup_server);
        portView = (TextView) this.findViewById(R.id.setup_port);
        usernameView = (TextView) this.findViewById(R.id.setup_username);
        pwView = (TextView) this.findViewById(R.id.setup_pw);
        cancelBtn = (Button) this.findViewById(R.id.setup_button_cancel);
        okBtn = (Button) this.findViewById(R.id.setup_button_ok);
        db = this.mDbHelper.getWritableDatabase();

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dbname = dbnameView.getText().toString();
                String server = serverView.getText().toString();
                String port = portView.getText().toString();
                String username = usernameView.getText().toString();
                String pw  = pwView.getText().toString();

                ContentValues values = new ContentValues();
                values.put(ConnectionsDbEntry.COLUMN_DB_NAME, dbname);
                values.put(ConnectionsDbEntry.COLUMN_SERVER, server);
                values.put(ConnectionsDbEntry.COLUMN_PORT, port);
                values.put(ConnectionsDbEntry.COLUMN_USERNAME, username);
                values.put(ConnectionsDbEntry.COLUMN_PW, pw);
                long newRodId = db.insert("condb", (String)null, values);
               //.add(new Connection(dbname, server, port, username, pw));
            }
        });
    }
}
