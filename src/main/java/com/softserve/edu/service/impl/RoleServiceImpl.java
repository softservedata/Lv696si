package com.softserve.edu.service.impl;

import com.softserve.edu.dto.RoleProfile;
import com.softserve.edu.model.Role;
import com.softserve.edu.repository.RoleRepository;
import com.softserve.edu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl( RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    public Role getByName(String name) {
        Role tempRole = new Role(1L, "roleName", "description");
        Role role = roleRepository.findByName(name).orElse(tempRole);
        return role;
    }

    public RoleProfile saveRole(RoleProfile roleProfile) {
        return null;
    }

    public RoleProfile findByName(String name) {
        return null;
    }

    public List<RoleProfile> getAllRoles() {
        return null;
    }

    public boolean updateRole(RoleProfile roleProfile) {
        return true;
    }

    public boolean deleteRole(RoleProfile roleProfile) {
        return true;
    }
}
