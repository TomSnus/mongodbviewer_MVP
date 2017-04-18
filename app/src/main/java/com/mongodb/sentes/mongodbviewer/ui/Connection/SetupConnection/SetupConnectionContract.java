package com.mongodb.sentes.mongodbviewer.ui.Connection.SetupConnection;

import android.support.annotation.NonNull;

import com.mongodb.sentes.mongodbviewer.data.Database.Classes.ConnectionClass;

import java.sql.Connection;

/**
 * Created by Faßreiter on 18.04.2017.
 */

public class SetupConnectionContract {

    interface View {


        void showEditConnections(Connection connections);

    }

    interface ViewActions {

        void loadConnection(boolean forceUpdate);



        void saveConnection(@NonNull ConnectionClass requestedConnection);

    }
}
