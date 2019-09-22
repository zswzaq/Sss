package base.test;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.pojo.ApiCaseDetail;
import base.pojo.WriteDate;
import base.utils.ApiTools;
import base.utils.AssertTools;
import base.utils.ExcalTools;
import base.utils.HttpTools;

public class CaseTestAllBatch0 {
    @DataProvider
    public Object[][] getData() {
        return ApiTools.getData();
    }

    @Test(dataProvider = "getData")
    public void f1(ApiCaseDetail apiCaseDetail) {
        String actualResult = HttpTools.excute(apiCaseDetail);
        // 搜集要写入 的数据
        // 添加一条要写的数据
        ApiTools.setWriteDatesList(new WriteDate(apiCaseDetail.getRowNo(), 6, actualResult));
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
        List<Integer> sheetList = new ArrayList<Integer>();
        sheetList.add(0);
        sheetList.add(2);
        ExcalTools.writeBackBatch2("/case/test_case_all.xlsx", "D:\\a.xlsx", sheetList);
    }
}
