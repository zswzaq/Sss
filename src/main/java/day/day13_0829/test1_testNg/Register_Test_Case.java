
package day.day13_0829.test1_testNg;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class Register_Test_Case {
    private static final String URL = "http://test.lemonban.com/futureloan/mvc/api/member/register";

    @Test
    public void case1() {
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("mobilephone", "13888688888");
        paramMap.put("pwd", "123456");
        String result = HttpTools.doPost(URL, paramMap);
        System.out.println(result);
    }

    @Test
    public void case2() {
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("mobilephone", "13888688888");
        paramMap.put("pwd", "1234");
        String result = HttpTools.doPost(URL, paramMap);
        System.out.println(result);
    }

    @Test
    public void case3() {
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("mobilephone", "13888688888");
        paramMap.put("pwd", "");
        String result = HttpTools.doPost(URL, paramMap);
        System.out.println(result);
    }

    @Test
    public void case4() {
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("mobilephone", "");
        paramMap.put("pwd", "12345678");
        String result = HttpTools.doPost(URL, paramMap);
        System.out.println(result);
    }

    @Test
    public void case5() {
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("mobilephone", "");
        paramMap.put("pwd", "");
        String result = HttpTools.doPost(URL, paramMap);
        System.out.println(result);
    }
    
    @Test
    public void case6() {
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("mobilephone", "abc");
        paramMap.put("pwd", "1234567");
        String result = HttpTools.doPost(URL, paramMap);
        System.out.println(result);
    }
}
