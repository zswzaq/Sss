package day15_0903.section01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Register_Test_Case3 {

	@DataProvider
	public Object[][] getData() {
		ArrayList<Object> dataList = ExcelUtils.readExcel("/case/test_case_03.xlsx", 0, ApiCaseDetail.class);
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
	
	//example--》给自己、给其他人
	public static void main(String[] args) {
		//测试用例的详细信息
		ArrayList<Object> dataList = ExcelUtils.readExcel("/case/test_case_03.xlsx", 0, ApiCaseDetail.class);
		for (Object object : dataList) {
			System.out.println(object);
		}
		//接口的基本信息
		ArrayList<Object> dataList2 = ExcelUtils.readExcel("/case/test_case_03.xlsx", 1, ApiInfo.class);
		System.out.println("---------------------------------------");
		for (Object object : dataList2) {
			System.out.println(object);
		}
	}

}
