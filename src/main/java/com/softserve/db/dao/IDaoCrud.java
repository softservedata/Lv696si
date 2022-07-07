package com.softserve.db.dao;

import com.softserve.db.entity.IModel;

public interface IDaoCrud<TEntity extends IModel> extends IDaoRead<TEntity> {

    // Create
    boolean insertByEntity(TEntity entity);

    // Update
    boolean updateByEntity(TEntity entity);

    boolean updateByFieldName(String fieldName, String text, String fieldCondition, String textCondition);

    // Delete
    boolean deleteById(int id);

    boolean deleteByEntity(TEntity entity);

    boolean deleteByFieldName(String fieldCondition, String textCondition);

}
