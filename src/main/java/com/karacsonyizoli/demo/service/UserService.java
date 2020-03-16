package com.karacsonyizoli.demo.service;

import com.karacsonyizoli.demo.database.UserRepository;
import com.karacsonyizoli.demo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<String> createUser(UserEntity userEntity){
        try {
            userRepository.save(userEntity);
            return ResponseEntity.ok("Success");
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public ResponseEntity<String> updateUser(UserEntity userEntity) {
        UserEntity entity = userRepository.findById(userEntity.getId()).get();
        entity.setEmail(userEntity.getEmail());
        entity.setName(userEntity.getName());
        entity.setPassword(userEntity.getPassword());
        try {
            userRepository.save(entity);
            return ResponseEntity.ok("Success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
