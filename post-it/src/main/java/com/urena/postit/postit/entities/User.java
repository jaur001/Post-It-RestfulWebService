package com.urena.postit.postit.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@ApiModel(description = "All details about User entity")
public class User {

    private static final AtomicInteger idGenerator = new AtomicInteger(1);
    private Integer id;
    @Email
    private String email;
    @Size(min = 2, message = "User Name should have at least 2 characters")
    @ApiModelProperty(notes = "UserName choosen by the User")
    private String userName;
    @Size(min = 4, message = "Password should have at least 4 characters")
    @ApiModelProperty(notes = "Password written by the User")
    @JsonIgnore
    private String password;
    @Size(min = 2, message = "First Name should have at least 2 characters")
    @ApiModelProperty(notes = "First Name of the User")
    private String firstName;
    @Size(min = 2, message = "Last Name should have at least 2 characters")
    @ApiModelProperty(notes = "Last Name of the User")
    private String lastName;
    @PastOrPresent(message = "Birthdate should be in the past")
    @ApiModelProperty(notes = "Birth date of the User, it should be in the past")
    private Date birthDate;
    @ApiModelProperty(notes = "Posts created by User")
    private List<Post> posts;
    @ApiModelProperty(notes = "Users following the User")
    private List<User> followers;
    @ApiModelProperty(notes = "Users that the User follows")
    private List<User> following;

    public User() {
        this("","","","","",new Date());
    }

    public User(String email, String userName, String password, String firstName, String lastName, Date birthDate) {
        this(0, email,userName,password,firstName,lastName,birthDate,new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
    }

    public User(Integer id, String email, String userName, String password, String firstName, String lastName,
                Date birthDate, List<Post> posts, List<User> followers, List<User> following) {
        this.id = idGenerator.getAndIncrement();
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.posts = posts;
        this.followers = followers;
        this.following = following;
    }

    public void follow(User user){
        following.add(user);
        user.getFollowers().add(this);
    }

    public void unfollow(User user){
        following.remove(user);
        user.getFollowers().remove(this);
    }

    public void post(Post post){
        posts.add(post);
    }

    public void deletePost(Post post){
        posts.remove(post);
    }

    public void resetId(){
        id = idGenerator.getAndIncrement();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public List<User> getFollowing() {
        return following;
    }

    public void setFollowing(List<User> following) {
        this.following = following;
    }
}
