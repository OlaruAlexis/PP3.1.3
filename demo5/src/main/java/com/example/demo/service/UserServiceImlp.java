package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImlp implements UserService {

    private final UserDao dao;
    @Autowired
    public UserServiceImlp(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    @Override
    public User getUser(Long id) {
        return dao.getUser(id);
    }

    @Override
    public void saveUser(User user) {
        dao.saveUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        dao.deleteUser(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return dao.getUserByUsername(username);
    }
}
