package com.karacsonyizoli.demo.database;

import com.karacsonyizoli.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    @Query(value = "SELECT id, name, password, email, enabled, role FROM users WHERE name = ?1", nativeQuery= true)
    UserEntity findUserByName(String name);
}
