package day15_0903.test;

import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CaseTest2 {
    @DataProvider
    public Object[][] getData() {
        List<Object> dataList = ExcalTools.readExcal("/case/test_case_02.xlsx", 0, ApiCase.class);
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
    }

}
