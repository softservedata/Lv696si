package com.softserve.web.services;

import com.softserve.db.services.RoleService;
import com.softserve.db.services.UserService;
import com.softserve.web.dto.ResponceDto;
import com.softserve.web.dto.RoleProfile;
import com.softserve.web.dto.UserProfile;
import com.softserve.web.services.converter.ConverterWebService;

public class UserWebService {
    private UserService userService;

    public UserWebService() {
        userService = new UserService();
    }

    public ResponceDto getAllUsers() {
        ResponceDto responceDto = null;
        try {
            responceDto = new ResponceDto("Users");
            responceDto.setData(userService.getAllUser()); // TODO Convert DTO
        } catch (Exception e) {
            responceDto = new ResponceDto("ERROR: " + e.getMessage());
        }
        return responceDto;
    }

    public ResponceDto addUser(UserProfile userProfile) {
        ResponceDto responceDto = null;
        try {
            userService.addUser(ConverterWebService.convertToDto(userProfile));
            responceDto = new ResponceDto("Successful");
        } catch (Exception e) {
            responceDto = new ResponceDto("ERROR: " + e.getMessage());
        }
        return responceDto;
    }

    public ResponceDto updateUser(UserProfile userProfile) {
        ResponceDto responceDto = null;
        try {
            userService.updateUser(ConverterWebService.convertToDto(userProfile));
            responceDto = new ResponceDto("User updated");
        } catch (Exception e) {
            responceDto = new ResponceDto("ERROR: " + e.getMessage());
        }
        return responceDto;
    }

    public ResponceDto deleteUser(UserProfile userProfile) {
        ResponceDto responceDto = null;
        try {
            userService.deleteUser(ConverterWebService.convertToDto(userProfile));
            responceDto = new ResponceDto("User deleted");
        } catch (Exception e) {
            responceDto = new ResponceDto("ERROR: " + e.getMessage());
        }
        return responceDto;
    }
}
