package com.softserve.db.services;

import com.softserve.db.dao.IDaoCrud;
import com.softserve.db.dao.IDaoRead;
import com.softserve.db.dao.UserDao;
import com.softserve.db.dao.UserRoleDao;
import com.softserve.db.dto.RoleRequest;
import com.softserve.db.dto.UserRequest;
import com.softserve.db.entity.Role;
import com.softserve.db.entity.User;
import com.softserve.db.entity.UserRole;
import com.softserve.db.services.converter.ConverterService;

import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService {
    private IDaoCrud<User>  userDao;
    private IDaoRead<UserRole> userRoleDao;
    //private RoleService roleSrvice;

    public UserService() {
        userDao = new UserDao();
        userRoleDao = new UserRoleDao();
    }

    public void addUser(UserRequest userRequest) {
        User user = ConverterService.get().convertToEntity(userRequest);
        List<User> userMaxId = userDao.getMaxId();
        if (userMaxId.size() == 0) {
            user.setId(1);
        } else {
            user.setId(userMaxId.get(0).getId() + 1);
        }
        userDao.insertByEntity(user);
    }

    private User getUserDB(UserRequest userRequest) {
        User user = ConverterService.get().convertToEntity(userRequest);
        List<User> users =  userDao.getByFieldName("email", user.getEmail());
        if (users.size() == 0) {
            // Develop Custom Exception
            throw new RuntimeException("user not found, email = " + user.getEmail());  // TODO use Const
        }
        return users.get(0);
    }

    public void updateUser(UserRequest userRequest) {
        userDao.updateByEntity(getUserDB(userRequest));
    }

    public void deleteUser(UserRequest userRequest) {
        userDao.updateByEntity(getUserDB(userRequest));
    }

    public List<UserRequest> getAllUser() {
        List<UserRequest> result = new ArrayList<>();
        for (UserRole userRole : userRoleDao.getAll()) {
            result.add(ConverterService.get().convertToDto(userRole));
        }
        return result;
    }

}
