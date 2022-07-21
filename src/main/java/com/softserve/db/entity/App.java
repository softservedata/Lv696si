package com.softserve.db.entity;

public class App {

    public static enum Queries {
        CREATE(SqlQueries.CREATE, "CREATE DATABASE IF NOT EXISTS %s character set utf8 collate utf8_bin;");
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

    @Override
    public String toString() {
        return "App{" +
                "Queries.CREATE=" + Queries.CREATE.toString() +
                '}';
    }
}
