package com.softserve.edu.controller;

import java.util.List;

import com.softserve.edu.dto.UserProfile;
import com.softserve.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;

@RestController
@Slf4j
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public UserProfile addUser(
            @Valid
            @RequestBody
            UserProfile userProfile) {
        log.info("*** UserController @PostMapping /user addUser = " + userProfile);
        return userService.saveUser(userProfile);
    }

    @GetMapping("/user/{id}")
    public UserProfile getUserById(
            @PathVariable
            Long id) {
        log.info("*** UserController  @GetMapping /user/{" + id + "} getUserById");
        return userService.findById(id);
    }

    @PutMapping("/user/{id}")
    public UserProfile updateUserById(
            @PathVariable
            Long id,
            @Valid
            @RequestBody
            UserProfile userProfile) {
        log.info("*** UserController  @PutMapping /user/{" + id + "} updateUserById");
        userProfile.setId(id);
        return userService.updateUser(userProfile);
    }

    @DeleteMapping("/user/{id}")
    public UserProfile deleteUserById(
            @PathVariable
            Long id,
            @Valid
            @RequestBody
            UserProfile userProfile) {
        log.info("*** UserController  @DeleteMapping /user/{" + id + "} deleteUserById");
        userProfile.setId(id);
        return userService.updateUser(userProfile);
    }
}
