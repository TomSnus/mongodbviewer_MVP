package com.mongodb.sentes.mongodbviewer;

import android.support.annotation.NonNull;

/**
 * Created by Faßreiter on 18.04.2017.
 */

public class ConnectionPresenter extends BasePresenter<ConnectionContract.View> implements ConnectionContract.ViewActions {
    @Override
    public void loadConnection(boolean forceUpdate) {

    }

    @Override
    public void addConnection() {

    }

    @Override
    public void openConnection(@NonNull Connection requestedConnection) {
        mView.showConnectionDetailUi(requestedConnection.getDbname());
    }
}
