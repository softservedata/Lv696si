package com.softserve.db.dao;

import com.softserve.db.entity.User;

public class UserDao extends ADaoCrud<User> {

    public UserDao() {
        super();
    }

    protected void init() {
        for (User.Queries query : User.Queries.values()) {
            sqlQueries.put(query.getSqlQuery(), query);
        }
    }

    protected User createInstance(String[] args) {
        return null; // TODO
    }

    protected String[] getFields(User entity) {
        return null; // TODO
    }

    protected String[] getUpdateFields(User entity) {
        return null; // TODO
    }

}
