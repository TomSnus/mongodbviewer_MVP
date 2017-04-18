package com.mongodb.sentes.mongodbviewer.ui.Connection.Base;

import android.support.annotation.NonNull;

/**
 * Created by Faßreiter on 18.04.2017.
 */

public abstract class BasePresenter<V> {

    protected V mView;

    public final void attachView(@NonNull V view) {
        mView = view;
    }

    public final void detachView() {
        mView = null;
    }

    protected final boolean isViewAttached() {
        return mView != null;
    }
}
