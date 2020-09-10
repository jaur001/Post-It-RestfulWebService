package com.urena.postit.postit.service;

import com.urena.postit.postit.dao.UserDao;
import com.urena.postit.postit.entities.Post;
import com.urena.postit.postit.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JPAUserService implements UserService{


    private final UserDao userDao;

    @Autowired
    public JPAUserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public List<Post> findAll(int id) {
        return userDao.findAll(id);
    }

    @Override
    public Post findById(int userId, int postId) {
        return userDao.findById(userId,postId);
    }

    @Override
    public Post post(int id, Post post) {
        return userDao.post(id,post);
    }

    @Override
    public void delete(int userId, int postId) {
        userDao.delete(userId,postId);
    }
}
