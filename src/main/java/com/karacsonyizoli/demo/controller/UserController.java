package com.karacsonyizoli.demo.controller;

import com.karacsonyizoli.demo.entity.UserEntity;
import com.karacsonyizoli.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    public List<UserEntity> listUsers() {
        return userService.listUsers();
    }

    @RequestMapping(value = "/api/user/{name}", method = RequestMethod.GET)
    public UserEntity findUserByUserName(@PathVariable String name) {
        return userService.findUserByUserName(name);
    }

    @RequestMapping(value ="/api/user", method = RequestMethod.GET)
    public UserEntity getUser(Authentication authentication) {
        if (authentication == null) {
            return null;
        }
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String name = userDetails.getUsername();
        String role = new ArrayList<GrantedAuthority>(userDetails.getAuthorities()).get(0).getAuthority();
        UserEntity foundUser = userService.findUserByUserName(name);
        return new UserEntity(foundUser.getId(),foundUser.getName(),foundUser.getPassword(),foundUser.getEmail(),foundUser.getEnabled(),foundUser.getRole());
    }
}
