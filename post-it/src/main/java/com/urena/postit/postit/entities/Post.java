package com.urena.postit.postit.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.concurrent.atomic.AtomicInteger;

@ApiModel(description = "All details about Post entity")
@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Size(min = 1, message = "The post should not be empty")
    @ApiModelProperty(notes = "Text written in the post selected")
    @Column(name="text")
    private String text;



    public Post() {
    }

    public Post(String text) {
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
