package com.example.resemble.service;


import com.example.resemble.controller.dto.PostDTO;
import com.example.resemble.domain.Post;
import com.example.resemble.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired//?????
    private PostRepository postRepository;

    //PostDTO?????뭐임
    //자바 옵셔널 ???
    public Post writePost(PostDTO postDTO){
        String title=postDTO.getTitle();
        String content=postDTO.getContent();

        Post post=new Post();
        post.setTitle(title);
        post.setContent(content);

        return postRepository.save(post);
    }

    //orElse optional 객체가 비어있다면 기본값으로 'null' 지정한다
    public Post readPost(Long id){
        return postRepository.findById(id).orElse(null);
    }

    //update
    public void update(Long id,PostDTO postDTO){
        String title=postDTO.getTitle();
        String content=postDTO.getContent();

        Optional<Post> post=postRepository.findById(id);

        post.ifPresent(selectPost->{
            selectPost.setTitle(title);
            selectPost.setContent(content);
            postRepository.save(selectPost);
        });
        //return postRepository.save(selectPost);
    }
}