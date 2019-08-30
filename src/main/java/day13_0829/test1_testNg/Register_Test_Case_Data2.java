package day13_0829.test1_testNg;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

public class Register_Test_Case_Data2 {

  @DataProvider
  public Object[][] getData() {
      Object[][] data = {
      new Object[] { "13888688888", "123456" },
      new Object[] { "13888688888", "1234" },
      new Object[] { "13888688888", "" },
      new Object[] { "13888688888", "sasasassfdsgfdhfgjtfhtturtr" },
      new Object[] { "", "12345678" },
      new Object[] { "", "" },
      new Object[] { "abc", "1234567" },
    };
    return data;
  }
//Object[][] data = {
//{ "13888688888", "123456" },
//{ "13888688888", "1234" },
//{ "13888688888", "" },
//{ "13888688888", "sasasassfdsgfdhfgjtfhtturtr" },
//{ "", "12345678" },
//{ "", "" },
//// {register对象 },
//};
//return data;
  private static final String URL = "http://test.lemonban.com/futureloan/mvc/api/member/register";

  @Test(dataProvider = "getData")
  public void case1(String mobilephone, String pwd) {//要使用数据提供者
      Map<String, String> paramMap = new HashMap<String, String>();
      paramMap.put("mobilephone", mobilephone);
      paramMap.put("pwd", pwd);
      String result = HttpTools.doPost(URL, paramMap);
      System.out.println(result);
  }

}
