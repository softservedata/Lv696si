package com.softserve.web.services.converter;

import com.softserve.db.dto.RoleRequest;
import com.softserve.db.dto.UserRequest;
import com.softserve.db.entity.Role;
import com.softserve.db.entity.UserRole;
import com.softserve.web.dto.RoleProfile;

public final class ConverterWebService {

    private ConverterWebService() {
    }

    public static RoleRequest convertToDto(RoleProfile roleProfile) {
        return new RoleRequest(roleProfile.getName(), roleProfile.getDescription());
    }
}
