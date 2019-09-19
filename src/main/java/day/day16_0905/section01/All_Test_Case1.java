package day.day16_0905.section01;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

/**
 * code为2 msg是不存在-->描述成json
 * {"code":2,"msg":"账号已存在","msg":"xxxxx"}-->object
 * [{"jsonPath":"$.code","expected":2},"jsonPath":"$.msg","expected":"账号已存在"}]
 * @author happy
 * http://www.lemfix.com/topics/54 -->jsonpath
 * http://www.lemfix.com/topics/75
 *
 */
public class All_Test_Case1 {

	/**
	 * 数据提供者
	 * @return 二维数组
	 */
	@DataProvider
	public Object[][] getData() {
		return ApiUtils.getData();
	}

	/**
	 * 
	 * @param apiCaseDetail
	 */
	@Test(dataProvider = "getData")
	public void test_case(ApiCaseDetail apiCaseDetail) {
		String result = HttpUtils.excute(apiCaseDetail);
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		String jsonStr = "{\"code\":2,\"msg\":\"账号已存在\",\"data\":null,\"copyright\":\"Copyright 柠檬班 © 2017-2019 湖南省零檬信息技术有限公司 All Rights Reserved\"}\n" + 
				"";
		String jsonPath = "$.copyright";
		
		Object document = Configuration.defaultConfiguration().jsonProvider().parse(jsonStr);
		Object code = JsonPath.read(document, jsonPath);
		System.out.println(code);
		
		
		Object read = JsonPath.read(jsonStr, jsonPath);
		System.out.println(read);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
