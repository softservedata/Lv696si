package com.softserve.db.entity;

import java.util.Objects;

public class Role implements IModel {

    public static enum Queries {
        INSERT(SqlQueries.INSERT, "INSERT INTO roles (name, description) VALUES ('%s', '%s');"),
        GET_BY_ID(SqlQueries.GET_BY_ID, "SELECT id, name, description FROM roles WHERE id = %s;"),
        GET_BY_FIELD(SqlQueries.GET_BY_FIELD, "SELECT id, name, description FROM roles WHERE %s = '%s';"),
        GET_ALL(SqlQueries.GET_ALL, "SELECT id, name, description FROM roles;"),
        UPDATE_BY_ID(SqlQueries.UPDATE_BY_ID, "UPDATE roles SET name = '%s', description = '%s' WHERE id = %s;"),
        UPDATE_BY_FIELD(SqlQueries.UPDATE_BY_FIELD, "UPDATE roles SET %s = '%s' WHERE %s = '%s';"),
        DELETE_BY_ID(SqlQueries.DELETE_BY_ID, "DELETE FROM roles WHERE id = %s;"),
        DELETE_BY_FIELD(SqlQueries.DELETE_BY_FIELD, "DELETE FROM roles WHERE %s = '%s';");
        //
        private SqlQueries sqlQuery;
        private String query;

        private Queries(SqlQueries sqlQuery, String query) {
            this.sqlQuery = sqlQuery;
            this.query = query;
        }

        public SqlQueries getSqlQuery() {
            return sqlQuery;
        }

        @Override
        public String toString() {
            return query;
        }
    }

    // --------------------------------------------------------------------------------
    private int id;
    private String name;
    private String description;

    public Role() {
        id = 0;
        name = "";
        description = "";
    }

    public Role(String name, String description) {
        id = 0;
        this.name = name;
        this.description = description;
    }

    public Role(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Role setId(int id) {
        this.id = id;
        return this;
    }

    public Role setName(String name) {
        this.name = name;
        return this;
    }

    public Role setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return (getId() == role.getId())
                && Objects.equals(getName(), role.getName())
                && Objects.equals(getDescription(), role.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription());
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
