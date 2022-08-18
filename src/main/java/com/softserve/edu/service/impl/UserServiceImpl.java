package com.softserve.edu.service.impl;

import com.softserve.edu.dto.UserProfile;
import com.softserve.edu.model.Role;
import com.softserve.edu.model.User;
import com.softserve.edu.repository.UserRepository;
import com.softserve.edu.service.RoleService;
import com.softserve.edu.service.UserService;
import com.softserve.edu.service.converter.ConverterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleService roleService;
    private ConverterDto converterDto;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleService roleService, ConverterDto converterDto) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.converterDto = converterDto;
    }

    public UserProfile saveUser(UserProfile userProfile) {
        User user = converterDto.convertToEntity(userProfile, new User())
                .withRole(roleService.getByName(userProfile.getRoleName()));
        userRepository.save(user);

        userProfile.setPassword("******");
        return findByEMail(userProfile.getEmail());
    }

    public UserProfile findById(Long id) {
        Role tempRole = new Role(0L, "roleName", "description");
        User tempUser = new User(0L, "temp@gmail.com", "temp", "**********", tempRole);
        User user = userRepository.findById(id).orElse(tempUser);
        //
        UserProfile userProfile = converterDto.convertToDto(user, UserProfile.class);
        return userProfile;
        //return new UserProfile(id,"ivan","a@gmail.ua","**********", "admin");
        //return null;
    }

    public UserProfile findByEMail(String email) {
        Role tempRole = new Role(0L, "roleName", "description");
        User tempUser = new User(0L, "temp@gmail.com", "temp", "**********", tempRole);
        User user = userRepository.findByEmail(email).orElse(tempUser);
        //
        UserProfile userProfile = converterDto.convertToDto(user, UserProfile.class);
        return userProfile;
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
