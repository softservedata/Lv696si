package com.softserve.db.services.converter;

import com.softserve.db.dao.IDaoCrud;
import com.softserve.db.dao.RoleDao;
import com.softserve.db.dto.RoleRequest;
import com.softserve.db.dto.UserRequest;
import com.softserve.db.entity.Role;
import com.softserve.db.entity.User;
import com.softserve.db.entity.UserRole;
import com.softserve.db.services.RoleService;
import com.softserve.db.tools.ConnectionManager;
import com.softserve.db.tools.DataSource;
import com.softserve.db.tools.DataSourceRepository;

import java.util.List;

public final class ConverterService {
    private static volatile ConverterService instance = null;
    private IDaoCrud<Role> roleDao;;

    private ConverterService() {
        roleDao = new RoleDao();
    }

    public static ConverterService get() {
        if (instance == null) {
            synchronized (ConverterService.class) {
                if (instance == null) {
                    instance = new ConverterService();
                }
            }
        }
        return instance;
    }

    private int getIdRole(String roleName) {
        int result = 0;
        List<Role> roles = roleDao.getByFieldName("name", roleName); // TODO use Const
        if (roles.size() > 0) {
            result = roles.get(0).getId();
        }
        return result;
    }

    public UserRequest convertToDto(UserRole userRole) {
        return new UserRequest(userRole.getUser().getName(), userRole.getUser().getEmail(),
                userRole.getUser().getPassword(), userRole.getRole().getName());
    }

    public RoleRequest convertToDto(Role role) {
        return new RoleRequest(role.getName(), role.getDescription());
    }

    public User convertToEntity(UserRequest userRequest) {
        return new User(userRequest.getName(), userRequest.getEmail(),
                userRequest.getPassword(), getIdRole(userRequest.getRole()));
    }

    public Role convertToEntity(RoleRequest roleRequest) {
        return new Role(getIdRole(roleRequest.getName()),
                roleRequest.getName(), roleRequest.getDescription());
    }

}
