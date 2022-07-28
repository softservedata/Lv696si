package com.softserve.db.entity;

import java.util.Objects;

public class Role implements IModel {

    public static enum Queries {
        //CREATE(SqlQueries.CREATE, "CREATE TABLE IF NOT EXISTS roles (id int not null primary key, name varchar(20), description varchar(100));"),
        CREATE(SqlQueries.CREATE, "CREATE TABLE public.roles (id integer not null, name character varying(20), description character varying(100));"),
        INSERT(SqlQueries.INSERT, "INSERT INTO roles (id, name, description) VALUES (%s, '%s', '%s');"),
        GET_BY_ID(SqlQueries.GET_BY_ID, "SELECT id, name, description FROM roles WHERE id = %s;"),
        GET_BY_FIELD(SqlQueries.GET_BY_FIELD, "SELECT id, name, description FROM roles WHERE %s = '%s';"),
        GET_ALL(SqlQueries.GET_ALL, "SELECT id, name, description FROM roles;"),
        //GET_MAX_ID(SqlQueries.GET_MAX_ID, "SELECT max(id) FROM roles;"),
        GET_MAX_ID(SqlQueries.GET_MAX_ID, " SELECT  * FROM roles ORDER BY id DESC LIMIT 1;"),
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

    public static Role createInstance(String[] args) {
        return new Role()
                .setId(args[0] == null ? 0 : Integer.parseInt(args[0]))
                .setName(args[1] == null ? "" : args[1])
                .setDescription(args[2] == null ? "" : args[2]);
    }

    public static String[] getFields(Role entity) {
        String[] result = new String[3];
        result[0] = String.valueOf(entity.getId());
        result[1] = entity.getName();
        result[2] = entity.getDescription();
        return result;
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
