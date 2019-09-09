package day16_0905.test;

import java.util.List;

import org.testng.Assert;

import com.alibaba.fastjson.JSONObject;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

/**
 * 断言工具类
 * 
 * @author Administrator
 *
 */
public class AssertTools {

    public static void assertResponse(ApiCaseDetail apiCaseDetail, String actualResult) {

        // 断言关键信息
        // 1.拿预期结果与实际结果
        String expectedResultInfo = apiCaseDetail.getExpectedResultInfo();
        // json解析为集合
        List<ExpectedResultInfo> resultInfos = JSONObject.parseArray(expectedResultInfo, ExpectedResultInfo.class);
        // 保护一下，如果为空，直接返回，不然会空指针
        if (resultInfos == null) {
            return;
        } else {
            // 把实际响应结果解析成jsonpath对应的对象
            Object document = Configuration.defaultConfiguration().jsonProvider().parse(actualResult);
            for (ExpectedResultInfo expectedResult : resultInfos) {
                // 2.拿实际结果
                String actual = expectedResult.getActual();
                // 3.拿预期结果
                Object expected = expectedResult.getExpected();
                // 利用jsonPath找到对应实际的值
                Object actualData = JsonPath.read(document, actual);
                System.out.println(actualData + "<——>" + expected);
                // testNg断言
                Assert.assertEquals(actualData, expected);
            }
        }

    }

}
