package com.softserve.db.tools;

import java.sql.Driver;
import java.sql.SQLException;

public final class DataSourceRepository {

    private final static String FAILED_JDBC_DRIVER = "Failed to Create JDBC Driver";

    private DataSourceRepository() {
    }

    private static Driver getMySqlDriver() {
        Driver sqlDriver = null;
        try {
            sqlDriver = new com.mysql.jdbc.Driver();
            //sqlDriver = new com.mysql.cj.jdbc.Driver();
        } catch (SQLException e) {
            // TODO Develop Custom Exceptions
            throw new RuntimeException(FAILED_JDBC_DRIVER);
        }
        return sqlDriver;
    }

    private static Driver getPostgreSqlDriver() {
        Driver sqlDriver = null;
        try {
            sqlDriver = new org.postgresql.Driver();
        } catch (Exception e) {
            // TODO Develop Custom Exceptions
            throw new RuntimeException(FAILED_JDBC_DRIVER);
        }
        return sqlDriver;
    }

    public static DataSource getDefault() {
        return getMySqlVM();
    }

    public static DataSource getMySqlVM() {
        return new DataSource(getMySqlDriver(),
                "jdbc:mysql://192.168.198.128:3306/lv696b?useSSL=false",
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
        return new ExternalProperties(filename)
                .readProperties()
                .setJdbcDriver(getMySqlDriver());
    }

    public static DataSource getPostgreSqlProperties() {
        return getPostgreSqlProperties("db.properties");
    }

    public static DataSource getPostgreSqlProperties(String filename) {
        return new ExternalProperties(filename)
                .readProperties()
                .setJdbcDriver(getPostgreSqlDriver());
    }

}
