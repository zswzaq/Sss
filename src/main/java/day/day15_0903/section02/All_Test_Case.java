package day.day15_0903.section02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class All_Test_Case {

	@DataProvider
	public Object[][] getData() {
		// 读取测试用例的详细数据列表
		ArrayList<Object> apiCaseDetailList = ExcelUtils.readExcel("/case/test_case_03.xlsx", 0, ApiCaseDetail.class);
		// 接口的基本信息
		ArrayList<Object> apiInfoList = ExcelUtils.readExcel("/case/test_case_03.xlsx", 1, ApiInfo.class);
		// 每条测试用例都对应有一个接口基本信息：接口基本信息是测试用例对象的一个属性

		Object[][] datas = new Object[apiCaseDetailList.size()][];
		for (int i = 0; i < apiCaseDetailList.size(); i++) {
			// 获取到当前索引的api的详细信息对象
			ApiCaseDetail apiCaseDetail = (ApiCaseDetail) apiCaseDetailList.get(i);
			// 获取到api详细信息对象的apiId
			String apiId = apiCaseDetail.getApiId();
			// 遍历所有api基本信息
			for (Object obj : apiInfoList) {
				// 获得当前的api的基本信息对象
				ApiInfo apiInfo = (ApiInfo) obj;
				// 如果api基本信息对象的apiid和测试用例详细信息的apiid相同，说明就找到这个apiInfo对象
				if (apiInfo.getApiId().equals(apiId)) {
					apiCaseDetail.setApiInfo(apiInfo);
					// 跳出循环
					break;
				}
			}
			Object[] itemArray = { apiCaseDetail };
			datas[i] = itemArray;
		}
		return datas;
	}

	@Test(dataProvider = "getData")
	public void test_case(ApiCaseDetail apiCaseDetail) {
		String url = apiCaseDetail.getApiInfo().getUrl();
		String requestData = apiCaseDetail.getRequestData();
//		String result = HttpUtils.post(url, requestData);
//		System.out.println(result);
	}

	// example--》给自己、给其他人
	public static void main(String[] args) {
		// 测试用例的详细信息
//		ArrayList<Object> dataList = ExcelUtils.readExcel("/case/test_case_03.xlsx", 0, ApiCaseDetail.class);
//		for (Object object : dataList) {
//			System.out.println(object);
//		}
		// 接口的基本信息
		ArrayList<Object> dataList2 = ExcelUtils.readExcel("/case/test_case_04.xlsx", 1, ApiInfo.class);
		System.out.println("---------------------------------------");
		for (Object object : dataList2) {
			System.out.println(object);
		}
	}

}
