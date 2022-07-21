package com.softserve.db;

import com.softserve.db.services.AppService;
import com.softserve.db.tools.ConnectionManager;
import com.softserve.db.tools.DataSourceRepository;

public class MainDB {

    public static void main(String[] args) {
        AppService appService = new AppService();
        ConnectionManager.getInstance(DataSourceRepository.getMySqlProperties());
        appService.checkDatabase();
    }
}
