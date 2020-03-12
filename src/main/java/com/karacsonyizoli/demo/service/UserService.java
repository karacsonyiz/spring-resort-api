package com.karacsonyizoli.demo.service;

import com.karacsonyizoli.demo.database.UserRepository;
import com.karacsonyizoli.demo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> listUsers() {
        System.out.println("sajt4");
        return userRepository.findAll();
    }

    public UserEntity findUserByUserName(String name) {
        System.out.println("sajt5");
        return  userRepository.findUserByName(name);
    }

}
