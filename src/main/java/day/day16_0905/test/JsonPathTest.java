package day.day16_0905.test;

import com.alibaba.fastjson.JSONPath;

public class JsonPathTest {
    public static void main(String[] args) {

        String jsonStr = "{\"code\":2,\"msg\":\"账号已存在\",\"data\":null,\"copyright\":\"Copyright 柠檬班 © 2017-2019 湖南省零檬信息技术有限公司 All Rights Reserved\"}\n"
                + "";
        String jsonPath = "$.code";
        System.out.println(jsonPath);
        Object read = JSONPath.read(jsonStr, jsonPath);
        System.out.println(read);
        
        
        // JSONPath.read(json, path)
    }

}
