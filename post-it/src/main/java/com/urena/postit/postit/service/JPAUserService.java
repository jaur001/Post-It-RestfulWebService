package com.urena.postit.postit.service;

import com.urena.postit.postit.dao.UserDao;
import com.urena.postit.postit.entities.Post;
import com.urena.postit.postit.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class JPAUserService implements UserService{


    private final UserDao userDao;

    @Autowired
    public JPAUserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    @Transactional
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    @Transactional
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    @Transactional
    public User update(User user) {
        return userDao.update(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    @Transactional
    public List<Post> findAllPosts(int userId) {
        return userDao.findAllPosts(userDao.findById(userId));
    }

    @Override
    @Transactional
    public Post findPostById(int userId, int postId) {
        return userDao.findPostById(userDao.findById(userId),postId);
    }

    @Override
    @Transactional
    public Post post(int userId, Post post) {
        return userDao.post(findById(userId),post);
    }

    @Override
    @Transactional
    public Post updatePost(int userId, Post post) {
        return userDao.updatePost(findById(userId),post);
    }

    @Override
    @Transactional
    public void deletePost(int userId, int postId) {
        userDao.deletePost(findById(userId),postId);
    }
}
