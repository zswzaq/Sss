
package day13_0829.test1_testNg;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class Register_Test_Case2 {
    private static final String URL = "http://test.lemonban.com/futureloan/mvc/api/member/register";

    @Test
    public void case1(String mobilephone, String pwd) {//要使用数据提供者
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("mobilephone", "13888688888");
        paramMap.put("pwd", "123456");
        String result = HttpTools.doPost(URL, paramMap);
        System.out.println(result);
    }

}
