package com.softserve.edu.service;

import com.softserve.edu.dto.RoleProfile;

import java.util.List;

public interface RoleService {

    RoleProfile saveRole(RoleProfile roleProfile);

    RoleProfile findByName(String name);

    List<RoleProfile> getAllRoles();

    boolean updateRole(RoleProfile roleProfile);

    boolean deleteRole(RoleProfile roleProfile);
}
