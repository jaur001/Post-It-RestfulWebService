package com.urena.postit.postit.service;

import com.urena.postit.postit.entities.Post;
import com.urena.postit.postit.entities.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(int id);

    User save(User user);

    User update(User user);

    void delete(int id);


    List<Post> findAllPosts(int userId);

    Post findPostById(int userId, int postId);

    Post post(int userId, Post post);

    Post updatePost(int userId, Post post);

    void deletePost(int UserId, int postId);
}
