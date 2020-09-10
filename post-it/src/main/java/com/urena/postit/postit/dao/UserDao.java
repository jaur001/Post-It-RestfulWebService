package com.urena.postit.postit.dao;

import com.urena.postit.postit.entities.Post;
import com.urena.postit.postit.entities.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    User findById(int id);

    User save(User user);

    User update(User user);

    void delete(int id);

    List<Post> findAllPosts(User user);

    Post findPostById(User user,int postId);

    Post post(User user, Post post);
    Post updatePost(User user, Post post);

    void deletePost(User user, int postId);
}
