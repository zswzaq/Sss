package day15_0903.section01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * 数据库表：很多表
 * 		kk java 100
 * 		kk python 99
 * 		kk c#   90
 * 		zero  java 99
 * 		zero  python 98
 * 
 * 数据冗余
 * kk -->king
 * 为了解决冗余，会创建一个student表
 * 1  kk
 * 2  zero
 * 3  shadow
 * 
 * score
 *  	1 java 100
 * 		1 python 99
 * 		1 c#   90
 * 		2  java 99
 * 		2  python 98
 * @author happy
 *
 */
public class Register_Test_Case2 {

	@DataProvider
	public Object[][] getData() {
		ArrayList<Object> dataList = ExcelUtils.readExcel("/case/test_case2.xlsx", 0, ApiCase.class);
		Object[][] datas = new Object[dataList.size()][];
		for (int i = 0; i < dataList.size(); i++) {
			Object[] itemArray = { dataList.get(i) };
			datas[i] = itemArray;
		}
		return datas;
	}

	@Test(dataProvider = "getData")
	public void test_case(ApiCase apiCase) {
		String url = apiCase.getUrl();
		String requestData = apiCase.getRequestData();
		String result = HttpUtils.post(url, requestData);
		System.out.println(result);
	}
	public static void main(String[] args) {
	    ArrayList<Object> dataList = ExcelUtils.readExcel("/case/test_case2.xlsx", 0, ApiCase.class);
	    System.out.println(dataList);
    }

}
