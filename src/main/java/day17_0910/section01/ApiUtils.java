package day17_0910.section01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 接口工具类
 * 
 * @author happy
 *
 */
public class ApiUtils {
	
	//创建一个数据池，保存要回写的数据
	public static List<CellData> cellDataList = new ArrayList<CellData>();
	//把一个要写回的数据对象保存到数据池中
	public static void setCellData(CellData cellData) {
		cellDataList.add(cellData);
	}

	//获得整个容器
	public static List<CellData> getCellDataList() {
		return cellDataList;
	}


	/**
	 * 为数据提供者提供数据--》工具方法<br>
	 * 
	 * @return 二维数组,格式如下<br>
	 *         {<br>
	 *         {apiCaseDetail}, <br>
	 *         {apiCaseDetail}, <br>
	 *         {apiCaseDetail}, <br>
	 *         {apiCaseDetail}, <br>
	 *         }<br>
	 */
	public static Object[][] getData() {
		// 读取测试用例的详细数据列表
		ArrayList<Object> apiCaseDetailList = ExcelUtils.readExcel("/case/test_case_5.xlsx", 0, ApiCaseDetail.class);
		// 接口的基本信息
		ArrayList<Object> apiInfoList = ExcelUtils.readExcel("/case/test_case_5.xlsx", 1, ApiInfo.class);
		// 每条测试用例都对应有一个接口基本信息：接口基本信息是测试用例对象的一个属性
		// 把List的中间数据重新组装到map中去
		Map<String, ApiInfo> apiInfoMap = new HashMap<String, ApiInfo>();
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

}
