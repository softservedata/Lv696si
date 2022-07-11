package com.softserve.db.tools;

import java.sql.Driver;
import java.util.Objects;

public class DataSource {

    private Driver jdbcDriver;
    private String connectionUrl;
    private String username;
    private String password;

    public DataSource(Driver jdbcDriver, String connectionUrl,
                      String username, String password) {
        this.jdbcDriver = jdbcDriver;
        this.connectionUrl = connectionUrl;
        this.username = username;
        this.password = password;
    }

    // setters

    public DataSource setJdbcDriver(Driver jdbcDriver) {
        this.jdbcDriver = jdbcDriver;
        return this;
    }

    public DataSource setConnectionUrl(String connectionUrl) {
        this.connectionUrl = connectionUrl;
        return this;
    }

    public DataSource setUsername(String username) {
        this.username = username;
        return this;
    }

    public DataSource setPassword(String password) {
        this.password = password;
        return this;
    }

    // getters

    public Driver getJdbcDriver() {
        return jdbcDriver;
    }

    public String getConnectionUrl() {
        return connectionUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    /*
    @Override
    public boolean equals(Object dataSource) {
        boolean result = false;
        if (dataSource instanceof DataSource) {
            result = getJdbcDriver().getClass().getName()
                        .equals(((DataSource) dataSource).getJdbcDriver().getClass().getName())
                    && getConnectionUrl().equals(((DataSource) dataSource).getConnectionUrl())
                    && getUsername().equals(((DataSource) dataSource).getUsername())
                    && getPassword().equals(((DataSource) dataSource).getPassword());
        }
        return result;
    }
    */

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DataSource that = (DataSource) o;
        return Objects.equals(getJdbcDriver(), that.getJdbcDriver())
                && Objects.equals(getConnectionUrl(), that.getConnectionUrl())
                && Objects.equals(getUsername(), that.getUsername())
                && Objects.equals(getPassword(), that.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getJdbcDriver(), getConnectionUrl(), getUsername(), getPassword());
    }

    @Override
    public String toString() {
        return "isExists jdbcDriver: " + (jdbcDriver != null)
                + " connectionUrl: " + connectionUrl
                + " username: " + username
                + " password: " + password;
    }
}
