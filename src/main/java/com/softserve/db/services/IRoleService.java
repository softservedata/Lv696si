package com.softserve.db.services;

import com.softserve.db.dto.RoleRequest;

import java.util.List;

public interface IRoleService {

    public void addRole(RoleRequest roleRequest);

    public void updateRole(RoleRequest roleRequest);

    public void deleteRole(RoleRequest roleRequest);

    public List<RoleRequest> getAllRoles();

}
