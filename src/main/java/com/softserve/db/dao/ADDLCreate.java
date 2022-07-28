package com.softserve.db.dao;

import com.softserve.db.entity.IModel;
import com.softserve.db.entity.SqlQueries;
import com.softserve.db.tools.ConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ADDLCreate<TEntity> implements IDDLCreate<TEntity>{

    protected final String QUERY_NOT_FOUND = "Query not found %s";
    protected final String DATABASE_INPUT_ERROR = "Database Input Error";
    //protected final String EMPTY_RESULTSET = "Empty ResultSet by Query %s";
    //protected final String DATABASE_READING_ERROR = "Database Reading Error";
    //
    protected final Map<SqlQueries, Enum<?>> sqlQueries;

    protected ADDLCreate() {
        this.sqlQueries = new HashMap<SqlQueries, Enum<?>>();
        init();
    }

    // TODO Create abstract method init
    protected abstract void init();

    protected List<TEntity> getEntities(Statement statement) {
        if (true) {
            // TODO Develop Custom Exceptions
            throw new RuntimeException(DATABASE_INPUT_ERROR);
        }
        return null;
    }

    protected List<TEntity> executeQuery(String query, SqlQueries sqlQueries) {
        List<TEntity> entities = null;
        if (query == null) {
            // TODO Develop Custom Exceptions
            throw new RuntimeException(String.format(QUERY_NOT_FOUND, sqlQueries.name()));
        }
        //
        Connection con = ConnectionManager.getInstance().getConnection();
        Statement statement2 = null;
        try {
             statement2 = con.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                statement2.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        //
        try (Statement statement = ConnectionManager.getInstance().getConnection().createStatement()) {
            boolean isSelect = statement.execute(query);
            if (isSelect) {
                entities = getEntities(statement);
            }
        } catch (SQLException e) {
            System.out.println("query = " + query);
            // TODO Develop Custom Exceptions
            throw new RuntimeException(DATABASE_INPUT_ERROR, e);
        }
        return entities;
    }


    public void updateTable() {
        create("");
    }

    // Create database, Create table
    public void create(String name) {
        String query = String.format(sqlQueries.get(SqlQueries.CREATE).toString(), name);
        executeQuery(query, SqlQueries.CREATE);
    }

}
