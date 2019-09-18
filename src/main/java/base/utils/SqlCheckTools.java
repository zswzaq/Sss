package base.utils;

import java.util.LinkedHashMap;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

import base.pojo.ApiCaseDetail;
import base.pojo.SqlChecker;
import base.pojo.WriteDate;

public class SqlCheckTools {
    /**
     * 
     * @param apiCaseDetail
     * @param type：1前置、2后置
     */
    private static void check(ApiCaseDetail apiCaseDetail, int type) {
        List<SqlChecker> sqlCheckerList = null;
        if (type == 1) {
            sqlCheckerList = apiCaseDetail.getBeforeCheckList();
        } else if (type == 2) {
            sqlCheckerList = apiCaseDetail.getAfterCheckList();
        }
        if (sqlCheckerList == null) {// 如果没验证数据，直接返回
            return;
        } else {
            for (SqlChecker sqlChecker : sqlCheckerList) {
                String expected = sqlChecker.getExpected();// 期望结果
                // 拿 sql语句，并执行，得到实际结果(得到的是列表)
                List<LinkedHashMap<String, Object>> sqListResp = JDBCTools.excuteQuery(sqlChecker.getSql());
                // 将列表转成字符串去
                String actual = JSONObject.toJSONString(sqListResp);//
                ApiTools.setSqlDatesList(new WriteDate(sqlChecker.getRowNo(), 6, actual));
                // 写回执行结果
                if (expected.equals(actual)) {
                    ApiTools.setSqlDatesList(new WriteDate(sqlChecker.getRowNo(), 7, "pass"));
                }
                else {
                    ApiTools.setSqlDatesList(new WriteDate(sqlChecker.getRowNo(), 7, "fail"));

                }
                if (type == 1) {
                    System.out.println("前置期望：" + expected);
                    System.out.println("前置实际：" + actual);
                } else if (type == 2) {
                    System.out.println("前置期望：" + expected);
                    System.out.println("前置实际：" + actual);
                }
            }

        }
    }

    // qian置数据验证
    public static void beforeCheck(ApiCaseDetail apiCaseDetail) {
        check(apiCaseDetail, 1);
    }

    // 后置数据验证
    public static void afterCheck(ApiCaseDetail apiCaseDetail) {
        check(apiCaseDetail, 2);
    }

}
