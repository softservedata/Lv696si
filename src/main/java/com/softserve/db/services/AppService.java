package com.softserve.db.services;

import com.softserve.db.dao.AppDDL;
import com.softserve.db.dao.RoleDao;
import com.softserve.db.dao.UserDao;
import com.softserve.db.tools.ConnectionManager;
import com.softserve.db.tools.DataSource;

public class AppService {
    private AppDDL appDDL;
    private RoleDao roleDao;
    private UserDao userDao;

    public AppService() {
        appDDL = new AppDDL();
        roleDao = new RoleDao();
        userDao = new UserDao();
    }

    private void updateTables() {
        roleDao.updateTable();
        userDao.updateTable();
    }

    public void checkDatabase() {
        try {
            ConnectionManager.getInstance().getConnection();
        } catch (Exception e) {
            appDDL.updateDatabase();
            updateTables();
        }
        //updateTables();  // TODO
    }
}
