package day15_0903.section01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Register_Test_Case {
	@Test
	public void test_case_1(){
		String url = "http://120.78.128.25:8766/futureloan/member/register";
		String requestData = "{ \"mobile_phone\": \"13888887773\",\"pwd\": \"12345678\"}";
		String result = HttpUtils.post(url, requestData);
		System.out.println(result);
	}
	
	@Test
	public void test_case_2(){
		String url = "http://120.78.128.25:8766/futureloan/loans";
		String requestData = "{ \"pageIndex\": \"2\",\"pageSize\": \"2\"}";
		String result = HttpUtils.get(url, requestData);
		System.out.println(result);
	}
}
