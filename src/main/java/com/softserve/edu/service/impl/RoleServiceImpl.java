package com.softserve.edu.service.impl;

import com.softserve.edu.dto.RoleProfile;
import com.softserve.edu.service.RoleService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

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
