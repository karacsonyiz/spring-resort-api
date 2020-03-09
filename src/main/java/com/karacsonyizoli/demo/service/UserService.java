package com.karacsonyizoli.demo.service;

import com.karacsonyizoli.demo.database.UserDao;
import com.karacsonyizoli.demo.database.UserRepository;
import com.karacsonyizoli.demo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> listUsers() {
        return userRepository.findAll();
    }

    public UserEntity findUserByUserName(String name) {
        UserEntity entity = userRepository.findUserByName(name);
        return entity;
    }

}
