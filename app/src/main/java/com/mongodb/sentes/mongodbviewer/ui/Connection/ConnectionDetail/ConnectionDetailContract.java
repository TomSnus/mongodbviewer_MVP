package com.mongodb.sentes.mongodbviewer.ui.Connection.ConnectionDetail;

import com.mongodb.sentes.mongodbviewer.data.Database.Classes.ConnectionClass;

/**
 * Created by Faßreiter on 18.04.2017.
 */

public class ConnectionDetailContract {

    interface View {
        void loadIU(ConnectionClass connection);
    }

    interface ViewActions {
        void openConnection(ConnectionClass connection);

        void editConnection(ConnectionClass connection);

        void deleteConnection(ConnectionClass connection);

        void loadConnection(ConnectionClass connection);
    }
}
