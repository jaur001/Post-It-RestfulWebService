package com.urena.postit.postit.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;
import java.util.concurrent.atomic.AtomicInteger;

@ApiModel(description = "All details about Post entity")
public class Post {

    private static final AtomicInteger idGenerator = new AtomicInteger(1);
    private Integer id;
    @Size(min = 1, message = "The post should not be empty")
    @ApiModelProperty(notes = "Text written in the post selected")
    private String text;



    public Post() {
        this("");
    }

    public Post(String text) {
        this(idGenerator.getAndIncrement(),text);
    }

    public Post(Integer id, String text) {
        this.id = idGenerator.getAndIncrement();
        this.text = text;
    }

    public void resetId() {
        id = idGenerator.getAndIncrement();
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
