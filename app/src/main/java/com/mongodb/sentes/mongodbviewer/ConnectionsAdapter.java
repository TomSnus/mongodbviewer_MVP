package com.mongodb.sentes.mongodbviewer;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Faßreiter on 17.04.2017.
 */

public class ConnectionsAdapter extends ArrayAdapter<Connection>{
    public ConnectionsAdapter(Activity act, ArrayList<Connection> connections) {
        super(act, 0, connections);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Connection currentConnection = (Connection) getItem(position);
        View listItemView = convertView;
        if(convertView == null) {
            listItemView = LayoutInflater.from(this.getContext()).inflate(R.layout.item_list_connections, parent, false);
        }

        TextView connectionName = (TextView) listItemView.findViewById(R.id.item_connections_database);
        TextView connectionDesc = (TextView) listItemView.findViewById(R.id.item_connections_desc);

        connectionName.setText(currentConnection.getDbname());
        connectionDesc.setText(currentConnection.getServer() + " " + currentConnection.getPort());


        return listItemView;
    }
}
