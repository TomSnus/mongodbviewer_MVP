package com.mongodb.sentes.mongodbviewer.ui.Connection.ConnectionDetail;

import com.mongodb.sentes.mongodbviewer.data.Database.Classes.ConnectionClass;
import com.mongodb.sentes.mongodbviewer.ui.Connection.Base.BasePresenter;

/**
 * Created by Faßreiter on 18.04.2017.
 */

public class ConnectionDetailsPresenter extends BasePresenter<ConnectionDetailContract.View> implements ConnectionDetailContract.ViewActions {

    @Override
    public void openConnection(ConnectionClass connection) {

    }

    @Override
    public void editConnection(ConnectionClass connection) {

    }

    @Override
    public void deleteConnection(ConnectionClass connection) {

    }

    @Override
    public void loadConnection(ConnectionClass connection) {
        mView.loadIU(connection);
    }
}
