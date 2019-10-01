package com.clari5;

import com.clari5.crud.UserCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ExampleUserDetailsService implements UserDetailsService {

    @Autowired
    private UserCrud userCrud;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        String[] userAndTenant = StringUtils.split(userId, String.valueOf(Character.LINE_SEPARATOR));
        if (userAndTenant == null || userAndTenant.length != 2) {
            throw new UsernameNotFoundException("Username and tenant must be provided");
        }
        return userCrud.findByUserIdAndTenantFetchRoleEagerly(userAndTenant[0], userAndTenant[1]);
    }

}
