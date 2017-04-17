package com.mongodb.sentes.mongodbviewer;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by Faßreiter on 18.04.2017.
 */

public class ConnectionContract {

    interface View {


        void showConnections(List<Connection> connections);

        void showAddConnection();

        void showConnectionDetailUi(String connectionId);


    }

    interface ViewActions {

        void loadConnection(boolean forceUpdate);

        void addConnection();

        void openConnection(@NonNull Connection requestedNote);
    }
}
