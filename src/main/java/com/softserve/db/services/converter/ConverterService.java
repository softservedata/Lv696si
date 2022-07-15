package com.softserve.db.services.converter;

import com.softserve.db.dto.RoleRequest;
import com.softserve.db.dto.UserRequest;
import com.softserve.db.entity.Role;
import com.softserve.db.entity.User;
import com.softserve.db.entity.UserRole;

public class ConverterService {

    public UserRequest convertToDto(UserRole userRole) {
        return new UserRequest(userRole.getUser().getName(), userRole.getUser().getName(),
                userRole.getUser().getPassword(), userRole.getRole().getName());
    }

    public RoleRequest convertToDto(Role role) {
        return new RoleRequest(role.getName(), role.getDescription());
    }

    public User convertToEntity(UserRequest userRequest) {
        return null;
    }

    public Role convertToEntity(RoleRequest roleRequest) {
        return null;
    }

}
