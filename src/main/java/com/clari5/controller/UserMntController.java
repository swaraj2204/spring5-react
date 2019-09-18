package com.clari5.controller;

import com.clari5.datasource.CurrentTenantCtx;
import com.clari5.datasource.TenantDataSource;
import com.clari5.entity.User;
import com.clari5.services.UserMaintenance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/mnt")
public class UserMntController {

    @Autowired
    private UserMaintenance userMaintenance;

    @GetMapping("/user/{userId}")
    public User getUser(@PathVariable String userId, Principal principal, @RequestHeader("X_Tenant") String tenantId) {
        CurrentTenantCtx.setCurrentTenant(tenantId);
        System.out.println(principal.getName());
        User user = userMaintenance.getUser(userId);
        return user;
    }

    @PutMapping("/user")
    public boolean updateUser(@Valid @RequestBody User user) {
        return userMaintenance.updateUser(null, user);
    }

    @PostMapping("/user")
    public boolean addUser(@Valid @RequestBody User user) {
        return userMaintenance.addUser(user);
    }

}
