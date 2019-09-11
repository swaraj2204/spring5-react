package com.clari5.services;

import com.clari5.crud.UserModCrud;
import com.clari5.entity.User;
import com.clari5.crud.UserCrud;
import com.clari5.entity.mod.UserMod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserMaintenance {

    @Autowired
    private UserCrud userCrud;

    @Autowired
    private UserModCrud userModCrud;

    public User getUser(String userId) {
        return userCrud.getUserByUserId(userId);
    }

    public boolean addUser(User user){
        try {
            userCrud.save(user);
            return true;
        }
        catch(RuntimeException ex){
            return false;
        }
    }

    public boolean updateUser(String currentUserId, User user) {
        UserMod userMod = UserMod.from(user);
        userMod.setLastUpdatedBy(currentUserId);
        try {
            userModCrud.save(userMod);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Transactional( )
    public boolean accept(String userId, String authUserId, String remarks){
        UserMod userMod = userModCrud.getUserByUserId(userId);
        try {
            // TODO - commit
            userCrud.save((User) userMod);
            userModCrud.delete(userMod);
            // Audit
        }
        catch(Exception ex){

        }
        return false;
    }

    public boolean reject(String userId, String authUserId, String remarks){
        return false;
    }
}
