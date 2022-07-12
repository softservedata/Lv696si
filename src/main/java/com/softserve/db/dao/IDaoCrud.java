package com.softserve.db.dao;

import com.softserve.db.entity.IModel;

public interface IDaoCrud<TEntity extends IModel> extends IDaoRead<TEntity> {

    // Create
    void insertByEntity(TEntity entity);

    // Update
    void updateByEntity(TEntity entity);

    void updateByFieldName(String fieldName, String text, String fieldCondition, String textCondition);

    // Delete
    void deleteById(int id);

    void deleteByEntity(TEntity entity);

    void deleteByFieldName(String fieldCondition, String textCondition);

}
