package day13_0829.test2;

import org.testng.annotations.Test;

import day13_0829.test1_testNg.HttpTools;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

public class Register_Test_Case_Data {

    private static final String URL = "http://test.lemonban.com/futureloan/mvc/api/member/register";

    @DataProvider
    public Object[][] getData() {
        List<Object> readList = ExcalTools.readExcal("/Register.xlsx", 0, Register.class);
        Object[][] registerDatas = new Object[readList.size()][];
        // for (Object object: readList) {
        // Register register = (Register) object;
        // }
        for (int i = 0; i < readList.size(); i++) {
            // Register register = (Register) readList.get(i);
            // registerDatas[i] = register;//这样不能将一个对象直接放在一个二维数组
            // 1.可以将对象先放在一维数组里去，长度为1
            Object[] arr = new Object[1];
            arr[0] = readList.get(i);
            registerDatas[i] = arr;// 2.再放二维
        }
        return registerDatas;

    }

    @Test(dataProvider = "getData")
    public void case1(Register register) {// 直接注入一个Register对象
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("mobilephone", register.getMobilephone());
        paramMap.put("pwd", register.getPwd());
        paramMap.put("regname", register.getRegname());

        String result = HttpTools.doPost(URL, paramMap);
        System.out.println(result);
    }

}
