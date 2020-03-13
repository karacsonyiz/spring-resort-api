package com.karacsonyizoli.demo.service;

import com.karacsonyizoli.demo.database.UserRepository;
import com.karacsonyizoli.demo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> listUsers() {
        return userRepository.findAll();
    }

    public UserEntity findUserByUserName(String name) {
        UserEntity userEntity = userRepository.findUserByName(name);
            return userRepository.findUserByName(name);
    }
}
