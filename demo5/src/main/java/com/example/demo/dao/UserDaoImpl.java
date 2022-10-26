package com.example.demo.dao;

import com.example.demo.model.User;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        List<User> users = entityManager.createQuery("SELECT u FROM User u").getResultList();
        return users;
    }

    @Override
    public User getUser(Long id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    public void saveUser(User user) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(user);
    }

    @Override
    public void deleteUser(Long id) {
        Session session = entityManager.unwrap(Session.class);
        session.delete(getUser(id));
    }

    @Override
    public User getUserByUsername(String username) {
        TypedQuery<User> q = entityManager.createQuery("SELECT u FROM User u WHERE u.username=:username", User.class);
        q.setParameter("username", username);
        return q.getResultList().stream().findFirst().orElse(null);
    }
}
