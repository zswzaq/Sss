package day15_0903.test1;

import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AllCaseTest {
    @DataProvider
    public Object[][] getData() {
        // 获取用例的详细信息
        List<Object> apiCaseDetailList = ExcalTools.readExcal("/case/test_case_03.xlsx", 0, ApiCaseDetail.class);
        // 接口的基本信息
        List<Object> apiInfoList = ExcalTools.readExcal("/case/test_case_03.xlsx", 1, ApiInfo.class);
        // 每条测试用例都对应一条基本信息,
        // 1.接口的基本信息是测试用例的一个属性
        // 2.创建一个二维数组，做数据提供者
        Object[][] datas = new Object[apiCaseDetailList.size()][];
        for (int i = 0; i < apiCaseDetailList.size(); i++) {
            // 获取当前索引的api详情信息对象
            ApiCaseDetail apiCaseDetail = (ApiCaseDetail) apiCaseDetailList.get(i);
            // 获取api详情信息的apiId
            String apiId = apiCaseDetail.getApiId();
            // 遍历apiInfo基本信息
            for (Object objects : apiInfoList) {
                // 获取当前的apiInfo基本信息对象
                ApiInfo apiInfo = (ApiInfo) objects;
                // 判断如果api详情的id和基本信息的id相等，就找到了这个apiInfo基本信息对象
                if (apiInfo.getApiId().equals(apiId)) {
                    apiCaseDetail.setApiInfo(apiInfo);
                    // 跳出循环
                    break;
                }
            }
            Object[] arr = { apiCaseDetailList.get(i) };
            datas[i] = arr;
        }
        return datas;

    }

    @Test(dataProvider = "getData")
    public void f1(ApiCaseDetail apiCaseDetail) {
        String url = apiCaseDetail.getApiInfo().getUrl();
        String requestData = apiCaseDetail.getRequestData();
        String doGet = HttpTools.doPost(url, requestData);
        System.out.println(doGet);
    }

    public static void main(String[] args) {
        // 测试用例的详细信息
        List<Object> dataList = ExcalTools.readExcal("/case/test_case_03.xlsx", 0, ApiCaseDetail.class);
        for (Object object : dataList) {
            System.out.println(object);
        }
        // 接口的基本信息
        List<Object> dataList2 = ExcalTools.readExcal("/case/test_case_03.xlsx", 1, ApiInfo.class);
        System.out.println("---------------------------------------");
        for (Object object : dataList2) {
            System.out.println(object);
        }
    }
}
