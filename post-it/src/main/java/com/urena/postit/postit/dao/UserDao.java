package com.urena.postit.postit.dao;

import com.urena.postit.postit.entities.Post;
import com.urena.postit.postit.entities.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    User findById(int id);

    User save(User user);

    void delete(int id);

    List<Post> findAll(int id);

    Post findById(int userId,int postId);

    Post post(int id, Post post);

    void delete(int userId, int postId);
}
