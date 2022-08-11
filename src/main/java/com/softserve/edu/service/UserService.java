package com.softserve.edu.service;

import com.softserve.edu.dto.UserProfile;

import java.util.List;

public interface UserService {

    UserProfile saveUser(UserProfile userProfile);

    UserProfile findById(Long id);

    UserProfile findByEMail(String email);

    List<UserProfile> getAllUsers();

    UserProfile updateUser(UserProfile userProfile);

    boolean deleteUser(UserProfile userProfile);
}
