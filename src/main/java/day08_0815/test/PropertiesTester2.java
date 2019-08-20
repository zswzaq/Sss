package day08_0815.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesTester2 {

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        // 方法一
        // 获得资源的字节流
        InputStream inStream = PropertiesTester2.class.getResourceAsStream("/config/user.properties");
        // 包装成字符流
        BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));
        // 加载资源文件
        properties.load(reader);

        // 读取文件成字符流
        FileReader reader2 = new FileReader(new File("src/main/resources/config/user.properties"));
        // 加载资源文件
        properties.load(reader2);

        // 读取
        String name = properties.getProperty("name");
        String age = properties.getProperty("age");
        String gender = properties.getProperty("gender");
        System.out.println(name);
        System.out.println(age);
        System.out.println(gender);
    }

}
