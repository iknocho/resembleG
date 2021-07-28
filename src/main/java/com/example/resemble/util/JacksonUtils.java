package com.example.resemble.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//왜 클래스를 만들어서 json으로 ??함수로는 ?
public class JacksonUtils {

    private static final ObjectMapper mapper=new ObjectMapper();

    public static String toJson(Object value) throws JsonProcessingException {
        return mapper.writeValueAsString(value);
    }

}
