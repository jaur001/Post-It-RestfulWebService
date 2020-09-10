package com.urena.postit.postit.rest;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import com.urena.postit.postit.entities.Post;
import com.urena.postit.postit.entities.User;
import com.urena.postit.postit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/post-it-v1")
public class PostItRestController {

    private final UserService userService;

    @Autowired
    public PostItRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> findById(@PathVariable int id){
        User user = userService.findById(id);
        EntityModel<User> entityModel = EntityModel.of(user);
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).findAll());
        entityModel.add(linkTo.withRel("all-users"));
        return entityModel;
    }

    @PostMapping("/users")
    public ResponseEntity<Post> save(@Valid @RequestBody User user){
        User savedUser = userService.save(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/users")
    public ResponseEntity<Post> update(@Valid @RequestBody User user){
        User savedUser = userService.save(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/users/{id}")
    public String delete(@PathVariable int id){
        userService.delete(id);
        return "User with id " + id + " deleted";
    }

    @GetMapping("/users/{id}/posts")
    public List<Post> findAllPosts(@PathVariable int id){
        return userService.findAllPosts(id);
    }

    @GetMapping("/users/{userId}/posts/{postId}")
    public EntityModel<Post> findPostById(@PathVariable int userId,@PathVariable int postId){
        Post post = userService.findPostById(userId,postId);
        EntityModel<Post> entity = EntityModel.of(post);
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).findAllPosts(userId));
        entity.add(linkTo.withRel("all-posts"));
        return entity;
    }

    @PostMapping("/users/{userId}/posts")
    public ResponseEntity<Post> post(@PathVariable int userId,@Valid @RequestBody Post post){
        Post savedPost = userService.post(userId,post);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/users/{userId}/posts")
    public ResponseEntity<Post> updatePost(@PathVariable int userId,@Valid @RequestBody Post post){
        Post savedPost = userService.post(userId,post);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/users/{userId}/posts/{postId}")
    public String deletePost(@PathVariable int userId,@PathVariable int postId){
        userService.deletePost(userId,postId);
        return "Post with id " + postId + " deleted";
    }
}
