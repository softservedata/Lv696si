package com.softserve.db.dao;

import com.softserve.db.entity.User;
import com.softserve.db.entity.UserRole;

public class UserRoleDao extends ADaoRead<UserRole> {

    public UserRoleDao() {
        super();
    }

    protected void init() {
        for (UserRole.Queries query : UserRole.Queries.values()) {
            sqlQueries.put(query.getSqlQuery(), query);
        }
    }

    protected UserRole createInstance(String[] args) {
        return UserRole.createInstance(args);
    }

}
