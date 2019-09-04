package day15_0903.test;

import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CaseTest3 {
    /*@DataProvider
    public Object[][] getData() {
        List<Object> dataList = ExcalTools.readExcal("/case/test_case_03.xlsx", 0, ApiCaseDetail.class);
        Object[][] datas = new Object[dataList.size()][];
        for (int i = 0; i < dataList.size(); i++) {
            Object[] arr = { dataList.get(i) };
            datas[i] = arr;
        }
        return datas;

    }

    @Test(dataProvider = "getData")
    public void f1(ApiCase apiCase) {
        String url = apiCase.getUrl();
        String requestData = apiCase.getRequestData();
        String doGet = HttpTools.doGet(url, requestData);
        System.out.println(doGet);
    }*/

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
