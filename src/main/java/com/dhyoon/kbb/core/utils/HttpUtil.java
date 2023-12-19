package com.dhyoon.kbb.core.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class HttpUtil {

    public static <T> T convert(ByteBuffer b, Class<T> clazz) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String s = StandardCharsets.UTF_8.decode(b).toString();
        return objectMapper.readValue(s, clazz);
    }

}
