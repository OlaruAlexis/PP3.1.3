package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<User> getAllUsers();
    public User getUser(Long id);
    public void saveUser(User user);
    public void deleteUser(Long id);
    public User getUserByUsername(String username);
}
