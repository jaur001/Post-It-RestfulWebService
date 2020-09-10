package com.urena.postit.postit.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ApiModel(description = "All details about User entity")
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Email
    @Column(name = "email")
    private String email;
    @Size(min = 2, message = "User Name should have at least 2 characters")
    @ApiModelProperty(notes = "UserName choosen by the User")
    @Column(name = "user_name")
    private String userName;
    @Size(min = 4, message = "Password should have at least 4 characters")
    @ApiModelProperty(notes = "Password written by the User")
    @JsonIgnore
    @Column(name = "password")
    private String password;
    @Size(min = 2, message = "First Name should have at least 2 characters")
    @ApiModelProperty(notes = "First Name of the User")
    @Column(name = "first_name")
    private String firstName;
    @Size(min = 2, message = "Last Name should have at least 2 characters")
    @ApiModelProperty(notes = "Last Name of the User")
    @Column(name = "last_name")
    private String lastName;
    @PastOrPresent(message = "Birthdate should be in the past")
    @ApiModelProperty(notes = "Birth date of the User, it should be in the past")
    @Column(name = "birth_date")
    private Date birthDate;
    @ApiModelProperty(notes = "Posts created by User")
    @OneToMany(fetch=FetchType.LAZY,
            cascade= CascadeType.ALL)
    @JoinColumn(name="user_id")
    private List<Post> posts;

    /*@ApiModelProperty(notes = "Users that the User follows")
    @ManyToMany(fetch=FetchType.LAZY,
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name="following_follower",
            joinColumns=@JoinColumn(name="following_id"),
            inverseJoinColumns=@JoinColumn(name="follower_id"))
    private List<User> followings;
    @ApiModelProperty(notes = "Users following the User")
    @ManyToMany(fetch=FetchType.LAZY,
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name="following_follower",
            joinColumns=@JoinColumn(name="follower_id"),
            inverseJoinColumns=@JoinColumn(name="following_id"))
    private List<User> followers;*/

    public User() {
        posts = new ArrayList<>();
        //following = new ArrayList<>();
        //followers = new ArrayList<>();
    }

    public User(String email, String userName, String password, String firstName, String lastName, Date birthDate) {
        this();
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }
    /*
    public void follow(User user){
        followings.add(user);
        user.getFollowers().add(this);
    }

    public void unfollow(User user){
        followings.remove(user);
        user.getFollowers().remove(this);
    }*/

    public void post(Post post){
        posts.add(post);
    }

    public void deletePost(Post post){
        posts.remove(post);
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
    /*
    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public List<User> getFollowings() {
        return followings;
    }

    public void setFollowings(List<User> followings) {
        this.followings = followings;
    }*/
}
