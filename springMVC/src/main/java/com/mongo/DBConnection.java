package com.mongo;

/**
 * @author huangy on 2018/7/24
 */
public class DBConnection {
    public enum DriverName {
        oracle, db2, sqlserver, mysql, sybase, postgresql, mongodb
    }

    private String dbConnectionName;
    private DriverName driverName;
    private String serverHost;
    private String serverPort;
    private String source;
    private String dbName;
    private String userName;
    private String password;

    public String getDbConnectionName() {
        return dbConnectionName;
    }

    public void setDbConnectionName(String dbConnectionName) {
        this.dbConnectionName = dbConnectionName;
    }

    public DriverName getDriverName() {
        return driverName;
    }

    public void setDriverName(DriverName driverName) {
        this.driverName = driverName;
    }

    public String getServerHost() {
        return serverHost;
    }

    public void setServerHost(String serverHost) {
        this.serverHost = serverHost;
    }

    public String getServerPort() {
        return serverPort;
    }

    public void setServerPort(String serverPort) {
        this.serverPort = serverPort;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
