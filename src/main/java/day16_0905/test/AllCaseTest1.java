package day16_0905.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AllCaseTest1 {
    @DataProvider
    public Object[][] getData() {
        return ApiTools.getData();
    }

    @Test(dataProvider = "getData")
    public void f1(ApiCaseDetail apiCaseDetail) {
        String response = null;
        String type = apiCaseDetail.getApiInfo().getType();
        if ("GET".equalsIgnoreCase(type)) {
            // url 和数据是api详情里有的，所以直接可以传一个apiCase详情对象
            response = HttpTools.doGet(apiCaseDetail);
        } else if ("POST".equalsIgnoreCase(type)) {
            // url 和数据是api详情里有的，所以直接可以传一个apiCase详情对象
            response = HttpTools.doPost(apiCaseDetail);
        } else if ("PATCH".equalsIgnoreCase(type)) {
            // url 和数据是api详情里有的，所以直接可以传一个apiCase详情对象
            response = HttpTools.doPatch(apiCaseDetail);
        }
        // url 和数据是api详情里有的，所以直接可以传一个apiCase详情对象
        // String doPost = HttpTools.doPost(apiCaseDetail);
        System.out.println(response);
    }

}
