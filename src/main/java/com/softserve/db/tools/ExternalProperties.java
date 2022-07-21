package com.softserve.db.tools;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Driver;
import java.util.Properties;

public class ExternalProperties {
    protected final String PATH_SEPARATOR = "/";
    private String filename;
    private String path;

    public ExternalProperties(String filename) {
        this.filename = filename;
        path = this.getClass().getResource(PATH_SEPARATOR + filename).getPath(); //.substring(1);
    }

    public DataSource readProperties() {
        return readProperties(path);
    }

    public DataSource readProperties(String path) {
        DataSource dataSource = new DataSource();
        try (InputStream input = new FileInputStream(path)) {
            Properties prop = new Properties();
            // load a properties file
            prop.load(input);
            // get the property value and print it out
            dataSource.setConnectionUrl(prop.getProperty("db.url"))
                    .setUsername(prop.getProperty("db.user"))
                    .setPassword(prop.getProperty("db.password"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dataSource;
    }
}
