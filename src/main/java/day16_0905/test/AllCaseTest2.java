package day16_0905.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AllCaseTest2 {
    @DataProvider
    public Object[][] getData() {
        return ApiTools.getData();
    }

    @Test(dataProvider = "getData")
    public void f1(ApiCaseDetail apiCaseDetail) {
        String actualResult = HttpTools.excute(apiCaseDetail);
        // 开始做断言
        AssertTools.assertResponse(apiCaseDetail, actualResult);
        System.out.println(actualResult);
    }

}
