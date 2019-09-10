package com.clari5.resources;

import com.clari5.entity.User;
import com.clari5.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserResources {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{uname}")
    public User getUser(@PathVariable String uname) {
        User user = userService.getUser(uname);
        return user;
    }

    @PutMapping("/user")
    public boolean updateUser(@Valid @RequestBody User user){
        return userService.updateUser(user);
    }
}
