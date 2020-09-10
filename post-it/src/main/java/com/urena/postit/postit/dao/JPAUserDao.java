package com.urena.postit.postit.dao;

import com.urena.postit.postit.entities.Post;
import com.urena.postit.postit.entities.User;
import com.urena.postit.postit.exceptions.PostNotFoundException;
import com.urena.postit.postit.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class JPAUserDao implements UserDao{

    private final EntityManager entityManager;

    @Autowired
    public JPAUserDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

                //new User("galaxy@test.com","PacoGalaxy","1234","Paco","Hojilla",new Date()),
                //new User("ronnie@test.com","RonnieStrongman","1234","Ronnie","Coleman",new Date()),
                //new User("messi@test.com","messiMC","1234","Lionel","Messi",new Date()),
                //new User("cr7@test.com","cr7","1234","Cristiano","Ronaldo",new Date())

    @Override
    public List<User> findAll() {
        TypedQuery<User> query = entityManager.createQuery("from User",User.class);
        return query.getResultList();
    }

    @Override
    public User findById(int id) {
        User userFound = entityManager.find(User.class,id);
        if(userFound==null) throw new UserNotFoundException("User with ID " + id + " Not Found");
        return userFound;
    }

    @Override
    public User save(User user) {
        user.setId(0);
        return entityManager.merge(user);
    }

    @Override
    public User update(User user) {
        return entityManager.merge(user);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(findById(id));
    }

    @Override
    public List<Post> findAllPosts(User user) {
        return user.getPosts();
    }

    @Override
    public Post findPostById(User user, int postId) {
        Post postFound = user.getPosts().stream()
                .filter(post -> post.getId()==postId)
                .findFirst().orElse(null);
        if(postFound==null) throw new PostNotFoundException("Post with ID " + postId + " Not Found");
        return postFound;
    }

    @Override
    public Post post(User user, Post post) {
        post.setId(0);
        user.post(post);
        return post;
    }

    @Override
    public Post updatePost(User user, Post post) {
        user.post(post);
        return post;
    }

    @Override
    public void deletePost(User user, int postId) {
        user.deletePost(findPostById(user,postId));
    }
}
