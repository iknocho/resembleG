package com.example.resemble;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.nio.charset.StandardCharsets;

// mock up 매모리에서 얻는 과정

//테스트 방법 1.AutoConfiguration 2.Customizimg
//1.AutoConfiguration 간단한테스트에 이용가능

@SpringBootTest
@AutoConfigureMockMvc
class ResembleApplicationTests {

	@Autowired
	protected MockMvc mockMvc;
	@Test
	void contextLoads() {
	}

}

//2.Customizing 장점:커스텀 가능하다 작동실패.
/*@SpringBootTest
public abstract class AbstractControllerTest{
	protected MockMvc mockMvc;
	abstract  protected Object controller();

	@BeforeEach
	private void setup(){
		mockMvc= MockMvcBuilders
				.standaloneSetup(controller())
				.addFilter(new CharacterEncodingFilter(StandardCharsets.UTF_8.name(),true)
				.
	}
}


public class BoardControllerTest extends ResembleApplicationTests{
	@Autowired
	private BoardController
}

 */