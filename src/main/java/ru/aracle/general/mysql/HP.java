package ru.aracle.general.mysql;

import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class HP {
    private HikariDataSource hikari;

    private String serverName;
    private String databaseName;
    private String user;
    private String password;
    private String sourceClassName;
    private int port;
    private int maxPoolSize;
    private int maxLifeTime;

    public HP(String serverName, String databaseName, String user, String password, String sourceClassName, int port, int maxPoolSize, int maxLifeTime) {
        this.serverName = serverName;
        this.databaseName = databaseName;
        this.user = user;
        this.password = password;
        this.sourceClassName = sourceClassName;
        this.port = port;
        this.maxPoolSize = maxPoolSize;
        this.maxLifeTime = maxLifeTime;
        this.hikari = new HikariDataSource();

        hikari.setDataSourceClassName(sourceClassName);
        hikari.addDataSourceProperty("serverName", serverName);
        hikari.addDataSourceProperty("port", port);
        hikari.addDataSourceProperty("databaseName", databaseName);
        hikari.addDataSourceProperty("user", user);
        hikari.addDataSourceProperty("password", password);
        hikari.setMaximumPoolSize(maxPoolSize);
        hikari.setMaxLifetime(maxLifeTime);
        hikari.addDataSourceProperty("cachePrepStmts", "true");
        hikari.addDataSourceProperty("prepStmtCacheSize", "250");
        hikari.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
    }

    public HikariDataSource getHikari() {
        return hikari;
    }
    public void setHikari(HikariDataSource hikari) {
        this.hikari = hikari;
    }
    public String getServerName() {
        return serverName;
    }
    public void setServerName(String serverName) {
        this.serverName = serverName;
    }
    public String getDatabaseName() {
        return databaseName;
    }
    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getSourceClassName() {
        return sourceClassName;
    }
    public void setSourceClassName(String sourceClassName) {
        this.sourceClassName = sourceClassName;
    }
    public int getPort() {
        return port;
    }
    public void setPort(int port) {
        this.port = port;
    }
    public int getMaxPoolSize() {
        return maxPoolSize;
    }
    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }
    public int getMaxLifeTime() {
        return maxLifeTime;
    }
    public void setMaxLifeTime(int maxLifeTime) {
        this.maxLifeTime = maxLifeTime;
    }
    private void validate() { if (hikari == null) { throw new IllegalStateException("Please call build() before running pool operations!"); } }
    public void closePool() { if (hikari != null && !hikari.isClosed()) { hikari.close(); } }
    public Connection getConnection() throws SQLException { validate();return hikari.getConnection(); }
}
