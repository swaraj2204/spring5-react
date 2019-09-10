package com.clari5.services;

import com.clari5.entity.User;
import com.clari5.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUser(String username) {
        return userRepository.getUserByUsername(username);
    }

    public boolean updateUser(User user) {
        try{
            userRepository.save(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
