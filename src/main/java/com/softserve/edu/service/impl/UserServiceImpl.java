package com.softserve.edu.service.impl;

import com.softserve.edu.dto.UserProfile;
import com.softserve.edu.service.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    public UserProfile saveUser(UserProfile userProfile) {
        userProfile.setPassword("******");
        return userProfile;
        //return null;
    }

    public UserProfile findById(Long id) {
        return new UserProfile(id,"ivan","a@gmail.ua","**********", "admin");
        //return null;
    }

    public UserProfile findByEMail(String email) {
        return null;
    }

    public List<UserProfile> getAllUsers() {
        return null;
    }

    public UserProfile updateUser(UserProfile userProfile) {
        return null;
    }

    public boolean deleteUser(UserProfile userProfile) {
        return true;
    }
}
