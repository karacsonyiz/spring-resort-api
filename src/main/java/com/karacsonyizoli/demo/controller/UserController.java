package com.karacsonyizoli.demo.controller;


import com.karacsonyizoli.demo.model.User;
import com.karacsonyizoli.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    public List<User> listUsers() {
        return userService.listUsers();
    }

    @RequestMapping("/api/user/{name}")
    public User findUserByUserName(String name) {
        return userService.findUserByUserName(name).get();
    }

    @RequestMapping("/api/user")
    public User getUser(Authentication authentication) {
        if (authentication == null) {
            return null;
        }
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String name = userDetails.getUsername();
        String role = new ArrayList<GrantedAuthority>(userDetails.getAuthorities()).get(0).getAuthority();
        User foundUser = userService.findUserByUserName(name).get();
        return new User(foundUser.getId(),foundUser.getName(),foundUser.getPassword(),foundUser.getEmail(),foundUser.getRole());
    }
}
