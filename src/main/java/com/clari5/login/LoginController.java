package com.clari5.login;

import com.clari5.ExampleUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private ExampleUserDetailsService userDetailsService;

    @PostMapping("/basic")
    public LoginResponse basicAuth(@RequestBody LoginRequest request) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername() + "|" + request.getTenant());
        if (new BCryptPasswordEncoder().matches(request.getPassword(), userDetails.getPassword())) {
            return new LoginResponse(request.getUsername(), request.getTenant());
        }
        throw new BadCredentialsException("Invalid Credentials");
    }
}
