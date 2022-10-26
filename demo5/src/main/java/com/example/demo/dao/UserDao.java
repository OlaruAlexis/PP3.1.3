package com.example.demo.dao;

import com.example.demo.model.User;

import java.util.List;

public interface UserDao {

    public List<User> getAllUsers();
    public User getUser(Long id);
    public void saveUser(User user);
    public void deleteUser(Long id);
    public User getUserByUsername(String username);
}
