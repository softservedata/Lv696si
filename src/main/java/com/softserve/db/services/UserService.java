package com.softserve.db.services;

import com.softserve.db.dao.UserDao;
import com.softserve.db.dto.UserRequest;

import java.util.List;

public class UserService {
    private UserDao UserDao;
    private UserDao UserRoleDao;
    private RoleService roleSrvice;

    public void addUser(UserRequest userRequest) {
    }

    public void updateUser(UserRequest userRequest) {
    }

    public void deleteUser(UserRequest userRequest) {
    }

    public List<UserRequest> getAllUser() {
        return null;
    }

}
