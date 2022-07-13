package com.softserve.db.dao;

import com.softserve.db.entity.IModel;
import com.softserve.db.entity.SqlQueries;

import java.util.Arrays;

abstract class ADaoCrud<TEntity extends IModel> extends ADaoRead<TEntity> implements IDaoCrud<TEntity> {

    protected ADaoCrud() {
        super();
    }

    // TODO Use List<String>
    protected abstract String[] getFields(TEntity entity);

    // TODO Use List<String>
    protected String[] getUpdateFields(TEntity entity) {
        String[] fields = getFields(entity);
        String id = fields[0];
        for (int i = 0; i < fields.length - 1; i++) {
            fields[i] = fields[i + 1];
        }
        fields[fields.length - 1] = id;
        return fields;
    }

    // Insert
    public void insertByEntity(TEntity entity) {
        String query = String.format(sqlQueries.get(SqlQueries.INSERT).toString(),
                (Object[]) Arrays.copyOfRange(getFields(entity), 1, getFields(entity).length));
        //System.out.println("query = " + query);
        executeQuery(query, SqlQueries.INSERT);
    }

    // Update
    public void updateByEntity(TEntity entity) {
        String query = String.format(sqlQueries.get(SqlQueries.UPDATE_BY_ID).toString(),
                (Object[]) getUpdateFields(entity));
        executeQuery(query, SqlQueries.UPDATE_BY_FIELD);
    }

    public void updateByFieldName(String fieldName, String text, String fieldCondition, String textCondition) {
        String query = String.format(sqlQueries.get(SqlQueries.UPDATE_BY_FIELD).toString(),
                fieldName, text, fieldCondition, textCondition);
        executeQuery(query, SqlQueries.UPDATE_BY_FIELD);
    }

    // Delete
    public void deleteById(int id) {
        String query = String.format(sqlQueries.get(SqlQueries.DELETE_BY_ID).toString(), id);
        executeQuery(query, SqlQueries.DELETE_BY_ID);
    }

    public void deleteByFieldName(String fieldCondition, String textCondition) {
        String query = String.format(sqlQueries.get(SqlQueries.DELETE_BY_FIELD).toString(),
                fieldCondition, textCondition);
        executeQuery(query, SqlQueries.DELETE_BY_FIELD);
    }

    public void deleteByEntity(TEntity entity) {
        deleteById(entity.getId());
    }

}
