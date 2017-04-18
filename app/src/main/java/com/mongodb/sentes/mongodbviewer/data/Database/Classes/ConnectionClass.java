package com.mongodb.sentes.mongodbviewer.data.Database.Classes;

import java.io.Serializable;

/**
 * Created by Faßreiter on 17.04.2017.
 */

public class ConnectionClass implements Serializable {

    private String dbname;
    private String server;
    private String port;
    private String username;
    private String password;

    public ConnectionClass(String dbname, String server, String port, String username, String password) {
        this.dbname = dbname;
        this.server = server;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    public ConnectionClass(String dbname, String server, String port) {
        this.dbname = dbname;
        this.server = server;
        this.port = port;
    }



    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
