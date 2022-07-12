package com.softserve.db.dao;

import com.softserve.db.entity.IModel;
import com.softserve.db.entity.SqlQueries;
import com.softserve.db.tools.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class ADaoRead<TEntity extends IModel> implements IDaoRead<TEntity> {

    protected final String QUERY_NOT_FOUND = "Query not found %s";
    protected final String DATABASE_INPUT_ERROR = "Database Input Error";
    //protected final String EMPTY_RESULTSET = "Empty ResultSet by Query %s";
    //protected final String DATABASE_READING_ERROR = "Database Reading Error";
    //
    protected final Map<SqlQueries, Enum<?>> sqlQueries;

    protected ADaoRead() {
        this.sqlQueries = new HashMap<SqlQueries, Enum<?>>();
        init();
    }

    // TODO Use Builder
    // TODO Use List<String>
    protected abstract TEntity createInstance(String[] args);

    // TODO Create abstract method init
    protected abstract void init();

    protected List<TEntity> executeQuery(String query, SqlQueries sqlQueries) {
        List<TEntity> entities = null;
        if (query == null) {
            // TODO Develop Custom Exceptions
            throw new RuntimeException(String.format(QUERY_NOT_FOUND, sqlQueries.name()));
        }
        try (Statement statement = ConnectionManager.getInstance().getConnection().createStatement()) {
            boolean isSelect = statement.execute(query);
            if (isSelect) {
                ResultSet resultSet = statement.getResultSet();
                entities = new ArrayList<TEntity>();
                String[] queryResult = new String[resultSet.getMetaData().getColumnCount()];
                while (resultSet.next()) {
                    for (int i = 0; i < queryResult.length; i++) {
                        queryResult[i] = resultSet.getString(i + 1);
                    }
                    entities.add(createInstance(queryResult));
                }
                resultSet.close();
            }
        } catch (SQLException e) {
            // TODO Develop Custom Exceptions
            throw new RuntimeException(DATABASE_INPUT_ERROR, e);
        }
        return entities;
    }

    public TEntity getById(int id) {
        return executeQuery(String.format(sqlQueries.get(SqlQueries.GET_BY_ID).toString(), id),
                SqlQueries.GET_BY_ID).get(0); // TODO throw Exception if size == 0
    }

    public List<TEntity> getByFieldName(String fieldName, String text) {
        return executeQuery(String.format(sqlQueries.get(SqlQueries.GET_BY_FIELD).toString(), fieldName, text),
                SqlQueries.GET_BY_FIELD);
    }

    public List<TEntity> getAll() {
        return executeQuery(
                sqlQueries.get(SqlQueries.GET_ALL).toString(), SqlQueries.GET_ALL);
    }

}
