package com.example.resemble;

import com.example.resemble.controller.dto.PostDTO;
import com.example.resemble.util.JacksonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ExampleTestApplication {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext ctx;

    @BeforeEach
    void setup(){
        this.mockMvc= MockMvcBuilders
                .webAppContextSetup(ctx)
                .addFilters(new CharacterEncodingFilter("UTF-8",true))
                .alwaysDo(print())
                .build();

    }
    //throws?
    @Test
    public void testWritingPost() throws Exception {

        PostDTO postDTO=new PostDTO();
        postDTO.setTitle("안녕1234");
        postDTO.setContent("잘가1234");


//add exception to method signature
        String jsonDTO=JacksonUtils.toJson(postDTO);
        System.out.println(jsonDTO);


        mockMvc
                .perform(
                        post("/api/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonDTO))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(jsonPath("$.title").value("안녕1234"))//실제값과 예측값 테스트
                .andExpect(jsonPath("$.content").value("잘가1234"));
    }
    //오류 테스트케이스 2개 이상인데 하나만 작동시 발생한다.
    //테스트시도 데이터 입력되나?
    @Test
    public void testReadingPost() throws Exception {

        testWritingPost();
        mockMvc
                .perform(
                        get("/api/post/{id}",3L))
                .andExpect(status().is(HttpStatus.OK.value()));
    }
    @Test
    public void testupdatePost() throws Exception {

        PostDTO postDTO=new PostDTO();
        postDTO.setTitle("updatetitle");
        postDTO.setContent("updatecontent");

        String jsonDTO=JacksonUtils.toJson(postDTO);


        mockMvc
                .perform(
                        put("/api/post/update/{id}", 2L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonDTO))
                .andExpect(status().is(HttpStatus.OK.value()));


    }

    @Test
    public void delete() throws Exception {
        mockMvc
                .perform(
                        post("/api/post/delete/{id}",7L))
                .andExpect(status().is(HttpStatus.OK.value()));
    }
}
