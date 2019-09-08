package day15_0903.test1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AllCaseTest4 {
    @DataProvider
    public Object[][] getData() {
        // 获取用例的详细信息
        List<Object> apiCaseDetailList = ExcalTools.readExcal("/case/test_case_04.xlsx", 0, ApiCaseDetail.class);
        // 接口的基本信息
        List<Object> apiInfoList = ExcalTools.readExcal("/case/test_case_04.xlsx", 1, ApiInfo.class);
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

    @Test(dataProvider = "getData")
    public void f1(ApiCaseDetail apiCaseDetail) {
        // url 和数据是api详情里有的，所以直接可以传一个apiCase详情对象
        String doPost = HttpTools.doPost(apiCaseDetail);
        System.out.println(doPost);
    }

    public static void main(String[] args) {
     // 接口的基本信息
        List<Object> dataList2 = ExcalTools.readExcal("/case/test_case_04.xlsx", 1, ApiInfo.class);
        System.out.println("---------------------------------------");
        for (Object object : dataList2) {
            System.out.println(object);
        }
    }
}
