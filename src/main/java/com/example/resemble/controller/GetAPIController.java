package com.example.resemble.controller;

import com.example.resemble.model.SearchVO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GetAPIController {
    @RequestMapping(method= RequestMethod.GET,path="/getRequest")
    public String getRequst(){
        return "this is getRequest";
    }
    //@GetMapping("/getParameters") //localhost:8080/api/getParameters?id=?&email=?
    /*path만지정
    public String getParameters(@RequestParam String id,@RequestParam String email){
          return "아이디는"+id+"이메일은"+email;
    }*/

    /*public String getParameters(@RequestParam(name="id")String userId,@RequestParam(name="email")String userEmail){
        return "아이디는"+userId+"이메일은"+userEmail;
    }   왜어러개 인수 못받나???
     */

    /*public String getMutiparameters(SearchVO searchVo){
        return "VO사용 아이디는"+searchVo.getId()+"이메일은"+searchVo.getEmail();
    }
     */
    @GetMapping("/getMultiParametersRtnJson")
    public SearchVO getMultiParametersRtnJson(SearchVO searchVo){
        return searchVo;
    }

}
