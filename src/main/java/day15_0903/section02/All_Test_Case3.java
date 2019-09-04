package day15_0903.section02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class All_Test_Case3 {

	@DataProvider
	public Object[][] getData() {
		// 读取测试用例的详细数据列表
		ArrayList<Object> apiCaseDetailList = ExcelUtils.readExcel("/case/test_case_03.xlsx", 0, ApiCaseDetail.class);
		// 接口的基本信息
		ArrayList<Object> apiInfoList = ExcelUtils.readExcel("/case/test_case_03.xlsx", 1, ApiInfo.class);
		// 每条测试用例都对应有一个接口基本信息：接口基本信息是测试用例对象的一个属性
		// 把List的中间数据重新组装到map中去
		Map<String, ApiInfo> apiInfoMap = new HashMap<>();
		for (Object obj : apiInfoList) {
			ApiInfo apiInfo = (ApiInfo) obj;
			apiInfoMap.put(apiInfo.getApiId(), apiInfo);
		}

		Object[][] datas = new Object[apiCaseDetailList.size()][];
		for (int i = 0; i < apiCaseDetailList.size(); i++) {
			// 获取到当前索引的api的详细信息对象
			ApiCaseDetail apiCaseDetail = (ApiCaseDetail) apiCaseDetailList.get(i);
			// 获取到api详细信息对象设置到用例详细对象中
			apiCaseDetail.setApiInfo(apiInfoMap.get(apiCaseDetail.getApiId()));
			Object[] itemArray = { apiCaseDetail };
			datas[i] = itemArray;
		}
		return datas;
	}

	@Test(dataProvider = "getData")
	public void test_case(ApiCaseDetail apiCaseDetail) {
		String result = HttpUtils.post(apiCaseDetail);
		System.out.println(result);
	}

}
