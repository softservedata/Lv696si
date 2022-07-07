package com.softserve.db.dao;


import com.softserve.db.entity.IModel;

import java.util.List;

public interface IDaoRead<TEntity extends IModel> {

    // Read
    TEntity getById(int id);

    List<TEntity> getByFieldName(String fieldName, String text);

    List<TEntity> getAll();

}
