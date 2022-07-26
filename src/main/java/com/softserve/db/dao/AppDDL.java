package com.softserve.db.dao;

import com.softserve.db.entity.App;
import com.softserve.db.entity.UserRole;
import com.softserve.db.tools.ConnectionManager;
import com.softserve.db.tools.DataSource;

public class AppDDL extends ADDLCreate<App> {

    public AppDDL() {
        super();
    }

    protected void init() {
        for (App.Queries query : App.Queries.values()) {
            sqlQueries.put(query.getSqlQuery(), query);
        }
    }

    public void updateDatabase() {
        ConnectionManager.closeAllConnections();
        //
        DataSource dbDataSource = ConnectionManager.getInstance().getDataSource();
        String connectionUrl = dbDataSource.getConnectionUrl();
        String dbname = dbDataSource.getDbname();
        //
        dbDataSource.setConnectionUrl(dbDataSource.getConnectionDb());
        ConnectionManager.getInstance().setDataSource(dbDataSource);
        create(dbname);
        ConnectionManager.closeAllConnections();
        //
        dbDataSource.setConnectionUrl(connectionUrl);
        ConnectionManager.getInstance().setDataSource(dbDataSource);
    }
}
