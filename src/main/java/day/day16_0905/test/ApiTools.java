package day.day16_0905.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Api工具类
 * @author Administrator
 */
public class ApiTools {
    //提供数据
    public static Object[][] getData() {
        // 获取用例的详细信息
        List<Object> apiCaseDetailList = ExcalTools.readExcal("/case/test_case_5.xlsx", 0, ApiCaseDetail.class);
        // 接口的基本信息
        List<Object> apiInfoList = ExcalTools.readExcal("/case/test_case_5.xlsx", 1, ApiInfo.class);
        // 每条测试用例都对应一条基本信息,
        // 接口的基本信息是测试用例的一个属性
        // 把List的中间数据重新组装到map中去
        Map<String, ApiInfo> apiInfoMap = new HashMap<String, ApiInfo>();
        for (Object object : apiInfoList) {
            ApiInfo apiInfo = (ApiInfo) object;
            apiInfoMap.put(apiInfo.getApiId(), apiInfo);
        }
        // 创建一个二维数组，做数据提供者
        Object[][] datas = new Object[apiCaseDetailList.size()][];
        for (int i = 0; i < apiCaseDetailList.size(); i++) {
            // 获取当前索引的api详情信息对象
            ApiCaseDetail apiCaseDetail = (ApiCaseDetail) apiCaseDetailList.get(i);
            // 获取api详情信息的apiId
            String apiId = apiCaseDetail.getApiId();
            // 获取到api详细信息对象设置到用例详细对象中
            apiCaseDetail.setApiInfo(apiInfoMap.get(apiId));
            Object[] arr = { apiCaseDetailList.get(i) };
            datas[i] = arr;
        }
        return datas;
    }

}
