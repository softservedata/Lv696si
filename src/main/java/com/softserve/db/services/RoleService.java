package com.softserve.db.services;

import com.softserve.db.dao.IDaoCrud;
import com.softserve.db.dao.RoleDao;
import com.softserve.db.dto.RoleRequest;
import com.softserve.db.entity.Role;
import com.softserve.db.entity.User;
import com.softserve.db.services.converter.ConverterService;

import java.util.ArrayList;
import java.util.List;

public class RoleService implements IRoleService {
    private IDaoCrud<Role> roleDao;

    public RoleService() {
        roleDao = new RoleDao();
    }

    public void addRole(RoleRequest roleRequest) {
        Role role = ConverterService.get().convertToEntity(roleRequest);
        List<Role> userMaxId = roleDao.getMaxId();
        if (userMaxId.size() == 0) {
            role.setId(1);
        } else {
            role.setId(userMaxId.get(0).getId() + 1);
        }
        roleDao.insertByEntity(role);
    }

    public void updateRole(RoleRequest roleRequest) {
        Role role = ConverterService.get().convertToEntity(roleRequest);
        roleDao.updateByEntity(role);
    }

    public void deleteRole(RoleRequest roleRequest) {
        Role role = ConverterService.get().convertToEntity(roleRequest);
        roleDao.deleteByEntity(role);
    }

    public List<RoleRequest> getAllRoles() {
        List<RoleRequest> result = new ArrayList<>();
        for (Role role : roleDao.getAll()) {
            result.add(ConverterService.get().convertToDto(role));
        }
        return result;
    }
}
