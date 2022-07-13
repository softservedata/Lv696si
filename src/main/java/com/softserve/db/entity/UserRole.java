package com.softserve.db.entity;

import java.util.Objects;

public class UserRole implements IModel {

    public static enum Queries {
        GET_BY_ID(SqlQueries.GET_BY_ID, "SELECT users.id, users.name, users.email, users.password, id_role, roles.id, roles.name, roles.description FROM users INNER JOIN roles ON users.id_role = roles.id WHERE users.id = %s;"),
        GET_BY_FIELD(SqlQueries.GET_BY_FIELD, "SELECT users.id, users.name, users.email, users.password, id_role, roles.id, roles.name, roles.description FROM users INNER JOIN roles ON users.id_role = roles.id WHERE %s = '%s';"),
        GET_ALL(SqlQueries.GET_ALL, "SELECT users.id, users.name, users.email, users.password, id_role, roles.id, roles.name, roles.description FROM users INNER JOIN roles ON users.id_role = roles.id;");
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

    private User user;
    private Role role;

    public UserRole() {
        user = new User();
        role = new Role();
    }

    public UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
    }

    public static UserRole createInstance(String[] args) {
        User user = User.createInstance(args);
        Role role = Role.createInstance(new String[]{args[5], args[6], args[7]});
        return new UserRole(user, role);
    }

    public int getId() {
        return getUser().getId();
    }

    public User getUser() {
        return user;
    }

    public Role getRole() {
        return role;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return Objects.equals(getUser(), userRole.getUser())
                && Objects.equals(getRole(), userRole.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser(), getRole());
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "user=" + user +
                ", role=" + role +
                '}';
    }

}
