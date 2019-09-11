package com.clari5;

import com.clari5.crud.UserCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ExampleUserDetailsService implements UserDetailsService {

    @Autowired
    private UserCrud userCrud;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        return userCrud.findByUserIdFetchRoleEagerly(userId);
    }

}
