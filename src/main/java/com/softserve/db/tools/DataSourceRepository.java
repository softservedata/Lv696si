package com.softserve.db.tools;

import java.sql.Driver;
import java.sql.SQLException;

public final class DataSourceRepository {

    private final static String FAILED_JDBC_DRIVER = "Failed to Create JDBC Driver";

    private DataSourceRepository() {
    }

    public static DataSource getDefault() {
        return getMySqlVM();
    }

    public static DataSource getMySqlVM() {
        Driver sqlDriver;
        try {
            sqlDriver = new com.mysql.jdbc.Driver();
            //sqlDriver = new com.mysql.cj.jdbc.Driver();
        } catch (SQLException e) {
            // TODO Develop Custom Exceptions
            throw new RuntimeException(FAILED_JDBC_DRIVER);
        }
        return new DataSource(sqlDriver,
                "jdbc:mysql://192.168.198.128:3306/lv696?useSSL=false",
                "lv696",
                "Lv-696.Si");
        // System.getenv().get("MY_SQL_PASSWORD"));
    }

    public static DataSource getPostgreLocalHost() {
        Driver sqlDriver = new org.postgresql.Driver();
        return new DataSource(sqlDriver,
                "jdbc:postgresql://localhost:5432/lv696",
                "postgres",
                "root");
    }

    public static DataSource getMySqlProperties() {
        return getMySqlProperties("db.properties");
    }
    public static DataSource getMySqlProperties(String filename) {
        Driver sqlDriver;
        try {
            sqlDriver = new com.mysql.jdbc.Driver();
            //sqlDriver = new com.mysql.cj.jdbc.Driver();
        } catch (SQLException e) {
            // TODO Develop Custom Exceptions
            throw new RuntimeException(FAILED_JDBC_DRIVER);
        }
        return new ExternalProperties(filename)
                .readProperties()
                .setJdbcDriver(sqlDriver);
    }

}
