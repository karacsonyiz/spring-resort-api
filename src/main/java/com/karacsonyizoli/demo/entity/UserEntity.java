package com.karacsonyizoli.demo.entity;

import com.karacsonyizoli.demo.model.UserRole;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users", schema = "demo")
public class UserEntity {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String password;
    private String email;
    private int enabled;
    private String role;

    public UserEntity() {
    }

    public UserEntity(long id, String name, String password, String email, int enabled, String role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.enabled = enabled;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
