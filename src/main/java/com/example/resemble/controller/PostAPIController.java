package com.example.resemble.controller;

import com.example.resemble.model.SearchVO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostAPIController {

    //http통신할때 post: body에 data를 집어넣어 받아오겠다.
    //@RequestBody 에 SearchVO에 있는 값을 매칭해서 보내줘라
    //RequestMapping과 GetMapping PostMapping차이점?????????
    @RequestMapping(method = RequestMethod.POST,path="/postRequest")
    public SearchVO postRequest(@RequestBody SearchVO searchVo){
        return searchVo;
    }
    //api 잘 작동되는지 확인방법

    @PostMapping(value="/postMapping")
    public SearchVO postMapping(@RequestBody SearchVO searchVO){
        return searchVO;
    }
}
