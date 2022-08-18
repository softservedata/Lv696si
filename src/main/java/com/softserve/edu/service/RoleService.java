package com.softserve.edu.service;

import com.softserve.edu.dto.RoleProfile;
import com.softserve.edu.model.Role;

import java.util.List;

public interface RoleService {

    Role getByName(String name);
    
    RoleProfile saveRole(RoleProfile roleProfile);

    RoleProfile findByName(String name);

    List<RoleProfile> getAllRoles();

    boolean updateRole(RoleProfile roleProfile);

    boolean deleteRole(RoleProfile roleProfile);
}
