package day15_0903.test;

import org.testng.annotations.Test;

public class Register_Test_Case_JsonData {

   @Test
   public void test1(){
       String url = "http://120.78.128.25:8766/futureloan/member/register";
       String requestData = "{ \"mobile_phone\": \"13877777773\",\"pwd\": \"12345678\"}";
       String  result = HttpTools.doPost(url, requestData);
       System.out.println(result);
   }
   @Test
   public void test2(){
       String url = "http://120.78.128.25:8766/futureloan/loans";
       String requestData = "{ \"pageIndex\": \"2\",\"pwd\": \"2\"}";
       String  result = HttpTools.doGet(url, requestData);
       System.out.println(result);
   }

}
