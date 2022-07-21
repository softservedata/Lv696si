package com.softserve.db.entity;

import java.util.Objects;

// id, name, email, password, id_role
public class User implements IModel {

    public static enum Queries {
        CREATE(SqlQueries.CREATE, "CREATE TABLE IF NOT EXISTS roles ( id int not null primary key, name varchar(20), email varchar(100), email varchar(100), password varchar(100), id_role int not null);"),
        INSERT(SqlQueries.INSERT, "INSERT INTO users (name, email, password, id_role) VALUES ('%s', '%s', '%s', %s);"),
        GET_BY_ID(SqlQueries.GET_BY_ID, "SELECT id, name, email, password, id_role FROM users WHERE id = %s;"),
        GET_BY_FIELD(SqlQueries.GET_BY_FIELD, "SELECT id, name, email, password, id_role FROM users WHERE %s = '%s';"),
        GET_ALL(SqlQueries.GET_ALL, "SELECT id, name, email, password, id_role FROM users;"),
        UPDATE_BY_ID(SqlQueries.UPDATE_BY_ID, "UPDATE users SET name = '%s', email = '%s', password = '%s', id_role = %s WHERE id = %s;"),
        UPDATE_BY_FIELD(SqlQueries.UPDATE_BY_FIELD, "UPDATE users SET %s = '%s' WHERE %s = '%s';"),
        DELETE_BY_ID(SqlQueries.DELETE_BY_ID, "DELETE FROM users WHERE id = %s;"),
        DELETE_BY_FIELD(SqlQueries.DELETE_BY_FIELD, "DELETE FROM users WHERE %s = '%s';");
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
    private String email;
    private String password;
    private int idRole;

    public User() {
        id = 0;
        name = "";
        email = "";
        password = "";
        idRole = 0;
    }

    public User(String name, String email, String password, int idRole) {
        id = 0;
        this.name = name;
        this.email = email;
        this.password = password;
        this.idRole = idRole;
    }

    public User(int id, String name, String email, String password, int idRole) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.idRole = idRole;
    }

    public static User createInstance(String[] args) {
        return new User()
                .setId(args[0] == null ? 0 : Integer.parseInt(args[0]))
                .setName(args[1] == null ? "" : args[1])
                .setEmail(args[2] == null ? "" : args[2])
                .setPassword(args[3] == null ? "" : args[2])
                .setIdRole(args[4] == null ? 0 : Integer.parseInt(args[0]));
    }

    public static String[] getFields(User entity) {
        String[] result = new String[5];
        result[0] = String.valueOf(entity.getId());
        result[1] = entity.getName();
        result[2] = entity.getEmail();
        result[3] = entity.getPassword();
        result[4] = String.valueOf(entity.getIdRole());
        return result;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getIdRole() {
        return idRole;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public User setIdRole(int idRole) {
        this.idRole = idRole;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return (getId() == user.getId()) && (getIdRole() == user.getIdRole())
                    && Objects.equals(getName(), user.getName())
                    && Objects.equals(getEmail(), user.getEmail())
                    && Objects.equals(getPassword(), user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmail(), getPassword(), getIdRole());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", idRole=" + idRole +
                '}';
    }
}
