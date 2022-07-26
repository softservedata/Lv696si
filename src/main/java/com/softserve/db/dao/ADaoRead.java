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

abstract class ADaoRead<TEntity extends IModel> extends ADDLCreate<TEntity> implements IDaoRead<TEntity> {

    protected ADaoRead() {
        super();
    }

    // TODO Use Builder
    // TODO Use List<String>
    protected abstract TEntity createInstance(String[] args);

    @Override
    protected List<TEntity> getEntities(Statement statement) {
        List<TEntity> entities = new ArrayList<TEntity>();
        try (ResultSet resultSet = statement.getResultSet()) {
            String[] queryResult = new String[resultSet.getMetaData().getColumnCount()];
            while (resultSet.next()) {
                for (int i = 0; i < queryResult.length; i++) {
                    queryResult[i] = resultSet.getString(i + 1);
                }
                entities.add(createInstance(queryResult));
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

    public List<TEntity> getMaxId() {
        return executeQuery(
                sqlQueries.get(SqlQueries.GET_MAX_ID).toString(), SqlQueries.GET_MAX_ID);
    }
}
