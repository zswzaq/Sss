package day12_0827.test;

import java.util.HashMap;
import java.util.Map;

public class HttpToolsTest {

    public static void main(String[] args) throws Exception {
        // 准备url
        // String url =
        // "http://test.lemonban.com/ningmengban/mvc/user/login.json";
        String url = "http://test.lemonban.com/futureloan/mvc/api/member/register";

        // 准备参数
        Map<String, String> map = new HashMap<String, String>();
        map.put("usermane", "13444444444");
        map.put("password", "1234567");
        String doGet = HttpTools.doGet(url, map);
        String doPost = HttpTools.doPost(url, map);
        System.out.println(doGet);
        System.out.println(doPost);
    }
}
