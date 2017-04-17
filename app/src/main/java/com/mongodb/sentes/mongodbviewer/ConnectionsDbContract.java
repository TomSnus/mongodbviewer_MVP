package com.mongodb.sentes.mongodbviewer;

import android.provider.BaseColumns;

/**
 * Created by Faßreiter on 17.04.2017.
 */

public class ConnectionsDbContract {
    public ConnectionsDbContract() {
    }

    public class ConnectionsDbEntry implements BaseColumns {
        public static final String TABLE_NAME = "condb";
        public static final String _ID = "_id";
        public static final String COLUMN_DB_NAME = "DBNAME";
        public static final String COLUMN_USERNAME = "USERNAME";
        public static final String COLUMN_PW = "PW";
        public static final String COLUMN_SERVER = "SERVER";
        public static final String COLUMN_PORT = "PORT";



        public ConnectionsDbEntry() {

        }
    }
}
