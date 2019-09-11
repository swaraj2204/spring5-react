package com.clari5.controller;

import com.clari5.entity.User;
import com.clari5.services.UserMaintenance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController("/mnt")
public class UserMntController {

    @Autowired
    private UserMaintenance userMaintenance;

    @GetMapping("/user/{userId}")
    public User getUser(@PathVariable String userId) {
        User user = userMaintenance.getUser(userId);
        return user;
    }

    @PutMapping("/user")
    public boolean updateUser(@Valid @RequestBody User user){
        return userMaintenance.updateUser(null, user);
    }

    @PostMapping("/user")
    public boolean addUser(@Valid @RequestBody User user){
        return userMaintenance.addUser(user);
    }
}
