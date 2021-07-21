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
    @PostMapping("post/update/{id}")
    //@PathVariable 아이디와 타이틀? content를 같이 보내기 힘듬 id 를 보내고 id값에 postdto값을 바꾸고 싶음 post와 postdto를 나눈이유는?????
    //get과 post룰 둘다 사용못하는게 문제다... 해결위해서는 postDTO에 id값을 넣으면 되나요????
    public void updatePost(@PathVariable Long id,@RequestBody PostDTO postDTO){
        postService.update(id,postDTO);
    }
    @PostMapping("post/delete/{id}")
    public void deletePost(@PathVariable Long id){postService.deletePost(id);}
}
