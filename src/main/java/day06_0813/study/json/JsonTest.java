package day06_0813.study.json;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

/**
 * @author zhangshuai
 *
 */
public class JsonTest {
    
    public static void main(String[] args) {
        //json对象
        // map对象
        String jsonStr = "{\"name\": \"tom\",\"age\": \"26\",\"gender\": \"男\"}";
        
        
        Map<?, ?> map = (Map<?, ?>) JSONObject.parse(jsonStr);
        System.out.println(map);
    }
}
