package com.example.demo.security;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserDao userDao;

    public UserDetailsServiceImpl(UserDao userDao) {
        this.userDao=userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.getUserByUsername(username);
        if (user==null) {
            throw new UsernameNotFoundException(username + " не найден");
        } else {
            return user;
        }
    }
}
