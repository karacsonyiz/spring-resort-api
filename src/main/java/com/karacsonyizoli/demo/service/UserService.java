package com.karacsonyizoli.demo.service;

import com.karacsonyizoli.demo.database.UserDao;
import com.karacsonyizoli.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> listUsers() {
        return userDao.listUsers();
    }

    public Optional<User> findUserByUserName(String name) {
        return userDao.findUserByUserName(name);
    }

}
