package com.clari5.controller;

import com.clari5.entity.User;
import com.clari5.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController("/mnt")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{userId}")
    public User getUser(@PathVariable String userId) {
        User user = userService.getUser(userId);
        return user;
    }

    @PutMapping("/user")
    public boolean updateUser(@Valid @RequestBody User user){
        return userService.updateUser(null, user);
    }

    @PostMapping("/user")
    public boolean addUser(@Valid @RequestBody User user){
        return userService.addUser(user);
    }
}
