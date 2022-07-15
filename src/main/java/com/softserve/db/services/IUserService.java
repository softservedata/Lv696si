package com.softserve.db.services;

import com.softserve.db.dto.UserRequest;

import java.util.List;

public interface IUserService {

    public void addUser(UserRequest userRequest);

    public void updateUser(UserRequest userRequest);

    public void deleteUser(UserRequest userRequest);

    public List<UserRequest> getAllUser();

}
