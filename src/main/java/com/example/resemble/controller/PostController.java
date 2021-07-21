package com.example.resemble.controller;

import com.example.resemble.controller.dto.PostDTO;
import com.example.resemble.domain.Post;
import com.example.resemble.repository.PostRepository;
import com.example.resemble.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("post")
    public Post writePost(@RequestBody PostDTO postDTO){
        return postService.writePost(postDTO);
    }
    @GetMapping("post/{id}")
    //클릭한 함수로 이동하는법
    //빌드폴더와 .gradle폴더 삭제이유???
    public Post readPost(@PathVariable Long id){
        return postService.readPost(id);
    }
    /*한줄로 줄어든 이유??????????

    public Post readPost(){
        postRepository.findById(id: 1L);
        postRepository.findById(id: 1L);
        postRepository.findById(id: 1L);
        postRepository.findById(id: 1L);
       return postRepository.findById(id: 1L);
    }

     */
    @PostMapping("post/update")
    //@PathVariable 아닐수도
    public void updatePost(@PathVariable Long id,@RequestBody PostDTO postDTO){
        postService.update(id,postDTO);
    }


}
