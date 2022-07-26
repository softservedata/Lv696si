package com.softserve.db;

import com.softserve.db.dto.RoleRequest;
import com.softserve.db.dto.UserRequest;
import com.softserve.db.services.*;
import com.softserve.db.tools.ConnectionManager;
import com.softserve.db.tools.DataSourceRepository;

public class MainDB {

    public static void main(String[] args) {
        AppService appService = new AppService();
        //ConnectionManager.getInstance(DataSourceRepository.getMySqlProperties());
        ConnectionManager.getInstance(DataSourceRepository.getPostgreSqlProperties());
        appService.checkDatabase();
        //
        /*
        //RoleRequest roleRequest = new RoleRequest("admin", "description admin");
        RoleRequest roleRequest = new RoleRequest("customer", "description customer");
        IRoleService roleService = new RoleService();
        roleService.addRole(roleRequest);
        */
        /*
        //UserRequest userRequest = new UserRequest("Ivan", "a@com.com", "qwerty", "customer");
        UserRequest userRequest = new UserRequest("Petro", "pet@com.com", "qwerty", "user");
        IUserService userService = new UserService();
        userService.addUser(userRequest);
        */
        /*
        IUserService userService = new UserService();
        for (UserRequest userRequest : userService.getAllUser()) {
            System.out.println("userRequest = " + userRequest);
        }
        */
        /*
        IRoleService roleService = new RoleService();
        for (RoleRequest roleRequest : roleService.getAllRoles()) {
            System.out.println("roleRequest = " + roleRequest);
        }
        */
        System.out.println("done");
    }
}
