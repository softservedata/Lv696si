package com.softserve.web.services;

import com.softserve.db.services.RoleService;
import com.softserve.web.dto.ResponceDto;
import com.softserve.web.dto.RoleProfile;
import com.softserve.web.services.converter.ConverterWebService;

public class RoleWebService {
    private RoleService roleService;

    public RoleWebService() {
        roleService = new RoleService();
    }

    public ResponceDto getAllRoles() {
        ResponceDto responceDto = null;
        try {
            responceDto = new ResponceDto("Roles");
            responceDto.setData(roleService.getAllRoles()); // TODO Convert DTO
        } catch (Exception e) {
            responceDto = new ResponceDto("ERROR: " + e.getMessage());
        }
        return responceDto;
    }

    public ResponceDto addRole(RoleProfile roleProfile) {
        ResponceDto responceDto = null;
        try {
            roleService.addRole(ConverterWebService.convertToDto(roleProfile));
            responceDto = new ResponceDto("Successful");
        } catch (Exception e) {
            responceDto = new ResponceDto("ERROR: " + e.getMessage());
        }
        return responceDto;
    }

    public ResponceDto updateRole(RoleProfile roleProfile) {
        ResponceDto responceDto = null;
        try {
            roleService.updateRole(ConverterWebService.convertToDto(roleProfile));
            responceDto = new ResponceDto("Role updated");
        } catch (Exception e) {
            responceDto = new ResponceDto("ERROR: " + e.getMessage());
        }
        return responceDto;
    }

    public ResponceDto deleteRole(RoleProfile roleProfile) {
        ResponceDto responceDto = null;
        try {
            roleService.deleteRole(ConverterWebService.convertToDto(roleProfile));
            responceDto = new ResponceDto("Role deleted");
        } catch (Exception e) {
            responceDto = new ResponceDto("ERROR: " + e.getMessage());
        }
        return responceDto;
    }
}
