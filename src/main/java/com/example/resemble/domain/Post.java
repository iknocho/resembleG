package com.example.resemble.domain;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
public class Post {

    @Id
    //primary key생성??????
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private String title;

    @Column
    private String content;

    //커맨드+n

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
