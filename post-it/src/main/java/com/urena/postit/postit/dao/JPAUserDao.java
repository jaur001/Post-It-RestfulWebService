package com.urena.postit.postit.dao;

import com.urena.postit.postit.entities.Post;
import com.urena.postit.postit.entities.User;
import com.urena.postit.postit.exceptions.PostNotFoundException;
import com.urena.postit.postit.exceptions.UserNotFoundException;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Repository
public class JPAUserDao implements UserDao{

    private static List<User> users;

    @PostConstruct
    public void init(){
        users = new ArrayList<>(Arrays.asList(
                new User("galaxy@test.com","PacoGalaxy","1234","Paco","Hojilla",new Date()),
                new User("ronnie@test.com","RonnieStrongman","1234","Ronnie","Coleman",new Date()),
                new User("messi@test.com","messiMC","1234","Lionel","Messi",new Date()),
                new User("cr7@test.com","cr7","1234","Cristiano","Ronaldo",new Date())
        ));
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findById(int id) {
        User userFound = users.stream()
                .filter(user -> user.getId()==id)
                .findFirst().orElse(null);
        if(userFound==null) throw new UserNotFoundException("User with ID " + id + " Not Found");
        return userFound;
    }

    @Override
    public User save(User user) {
        user.resetId();
        users.add(user);
        return user;
    }

    @Override
    public void delete(int id) {
        users.remove(findById(id));
    }

    @Override
    public List<Post> findAll(int id) {
        return findById(id).getPosts();
    }

    @Override
    public Post findById(int userId, int postId) {
        Post postFound = findById(userId).getPosts().stream()
                .filter(post -> post.getId()==postId)
                .findFirst().orElse(null);
        if(postFound==null) throw new PostNotFoundException("Post with ID " + postId + " Not Found");
        return postFound;
    }

    @Override
    public Post post(int id, Post post) {
        post.resetId();
        findById(id).post(post);
        return post;
    }

    @Override
    public void delete(int userId, int postId) {
        User user = findById(userId);
        user.deletePost(findById(userId,postId));
    }
}
