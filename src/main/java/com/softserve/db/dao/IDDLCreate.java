package com.softserve.db.dao;

import com.softserve.db.entity.IModel;

import java.sql.Statement;
import java.util.List;

public interface IDDLCreate<TEntity> {

    // Create database, Create table
    void updateTable();

    void create(String name);

    // Verify if database, table exist
    //boolean isExist();

}
