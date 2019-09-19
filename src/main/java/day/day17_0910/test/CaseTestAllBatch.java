package day.day17_0910.test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CaseTestAllBatch {
    @DataProvider
    public Object[][] getData() {
        return ApiTools.getData();
    }

    @Test(dataProvider = "getData")
    public void f1(ApiCaseDetail apiCaseDetail) {
        String actualResult = HttpTools.excute(apiCaseDetail);
        // 搜集要写入 的数据
        // 添加一条要写的数据
        ApiTools.setWriteDatesList(new WriteDate(apiCaseDetail.getRowNo(), 5, actualResult));
        // 将数据写回Excel：行号、列号、内容
        //WriteDate writeDate = new WriteDate(apiCaseDetail.getRowNo(), 4, actualResult);
        // Excel原路径，文件写入目标路径，写入的数据（表单索引、行索引、列索引、内容）
        //ExcalTools.writeBack("/case/test_case_all.xlsx", "D:\\myGit\\a.xlsx", 0, writeDate);
        // 开始做断言
        AssertTools.assertResponse(apiCaseDetail, actualResult);
        System.out.println(actualResult);
    }

    // 执行完所有的测试用例后，在全部写一次
    @AfterSuite
    public void afterSuite() {
        ExcalTools.writeBackBatch("/case/test_case_all.xlsx", "D:\\a.xlsx", 0);
    }
}
