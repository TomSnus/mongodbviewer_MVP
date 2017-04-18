package com.mongodb.sentes.mongodbviewer.ui.Connection;

import android.content.Context;
import android.support.annotation.NonNull;

import com.mongodb.sentes.mongodbviewer.data.Database.Classes.ConnectionClass;

import java.util.ArrayList;

/**
 * Created by Faßreiter on 18.04.2017.
 */

public class ConnectionContract {

    interface View {


        void showConnections(ArrayList<ConnectionClass> connections);

        void showAddConnection();

        void showConnectionDetailUi(ConnectionClass connectionId);


    }

    interface ViewActions {

        void loadConnection(boolean forceUpdate);

        void newConnection(Context context, Class cls);

        void openConnection(@NonNull ConnectionClass requestedNote);


    }
}
