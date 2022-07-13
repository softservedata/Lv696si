package com.softserve.db.dao;

import com.softserve.db.entity.Role;

public class RoleDao extends ADaoCrud<Role> {

    public RoleDao() {
        super();
    }

    protected void init() {
        for (Role.Queries query : Role.Queries.values()) {
            sqlQueries.put(query.getSqlQuery(), query);
        }
    }

    protected Role createInstance(String[] args) {
        return Role.createInstance(args);
    }

    protected String[] getFields(Role entity) {
        return Role.getFields(entity);
    }

}
