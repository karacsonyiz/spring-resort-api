package com.karacsonyizoli.demo.controller;

import com.karacsonyizoli.demo.entity.UserEntity;
import com.karacsonyizoli.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<UserEntity> findUserByUserName(@PathVariable String name) {
        UserEntity userEntity = userService.findUserByUserName(name);
        if(userEntity != null){
            return ResponseEntity.ok(userEntity);
        }
        return ResponseEntity.badRequest().build();
    }

    @RequestMapping(value = "/api/createuser", method = RequestMethod.POST)
    public ResponseEntity<String> createUser(@RequestBody UserEntity user){
        return userService.createUser(user);
    }

    @RequestMapping(value = "/api/updateuser", method = RequestMethod.POST)
    public ResponseEntity<String> updateUser(@RequestBody UserEntity user){
        return userService.updateUser(user);
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
