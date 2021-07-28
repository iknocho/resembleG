package com.example.resemble.controller;

import com.example.resemble.controller.dto.PostDTO;
import com.example.resemble.domain.Post;
import com.example.resemble.repository.PostRepository;
import com.example.resemble.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//@controller: 화면이 목적?
@RestController//@controler+@responsebody(responsebody):애노테이션 목적return data(json)
@RequestMapping("/api/")//1)class level mapping 모든 메서드에 적용
public class PostController {

    @Autowired//타입에 따라서 알아서 bean주입?
    private PostService postService;

    @PostMapping("post") //handler level mapping 요청url에 대해 해당메서드에서 처리
    public Post writePost(@RequestBody PostDTO postDTO){
        return postService.writePost(postDTO);
    }
    @GetMapping("post/{id}")
    //클릭한 함수로 이동하는법 커맨드+b
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
    @PutMapping("post/update/{id}")
    //@PathVariable 아이디와 타이틀? content를 같이 보내기 힘듬 id 를 보내고 id값에 postdto값을 바꾸고 싶음
    // post와 postdto를 나눈이유는????? 변수이름 변경시 테이블도 바꿔야하기 떄문에 너무 변경
    // reponse도 만든다,보안이슈
    //get과 post룰 둘다 사용못하는게 문제다... 해결위해서는 postDTO에 id값을 넣으면 되나요????
    public void updatePost(@PathVariable Long id,@RequestBody PostDTO postDTO){
        postService.update(id,postDTO);
    }
    @PostMapping("post/delete/{id}")
    public void deletePost(@PathVariable Long id){ postService.deletePost(id);}
}

//어노테이션은= 인터페이스?? 기능도 있음 근데왜 인터페이스+ 메타데이터(데이터를 설명하는 데이터)
//인터페이스:추상화 메서드(기능없는 메서드) 다중상속가능 와 추상화클래스: 추상화메서드와 일반 변수 https://
//오버로딩: 같은 클래스,다른 매개변수 오버라이딩 : 상속받은 클래스, 같은 매개변수,반환값