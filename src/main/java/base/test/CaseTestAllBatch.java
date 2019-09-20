package base.test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.pojo.ApiCaseDetail;
import base.pojo.WriteDate;
import base.utils.ApiTools;
import base.utils.AssertTools;
import base.utils.ExcalTools;
import base.utils.HttpTools;
import base.utils.SqlCheckTools;

public class CaseTestAllBatch {
    @DataProvider
    public Object[][] getData() {
        return ApiTools.getData();
    }
    //dsdk

    @Test(dataProvider = "getData")
    public void f1(ApiCaseDetail apiCaseDetail) {
        // 1.数据库的前置验证
        //List<SqlChecker> checkList = apiCaseDetail.getCheckList();// 不好
        SqlCheckTools.beforeCheck(apiCaseDetail);
        String actualResult = HttpTools.excute(apiCaseDetail);
        // 搜集要写入 的数据,将数据写回Excel：行号、列号、内容
        WriteDate writeDate = new WriteDate(apiCaseDetail.getRowNo(), 5, actualResult);
        // 添加一条要写的数据
        ApiTools.setWriteDatesList(writeDate);
        // 2.数据库的后置验证
        SqlCheckTools.afterCheck(apiCaseDetail);

        // 开始做断言
        AssertTools.assertResponse(apiCaseDetail, actualResult);
        System.out.println(actualResult);
    }

    // 执行完所有的测试用例后，在全部写一次
    @AfterSuite
    public void afterSuite() {
        ExcalTools.writeBackBatch("/case/test_case_all.xlsx", "D:\\a.xlsx", 0);
        ExcalTools.writeBackBatch2("/case/test_case_all.xlsx", "D:\\a.xlsx", 2);
    }
}
