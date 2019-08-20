package day08_0815.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesDemo {

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        // 加载资源文件
        // 输入流: 当前类目.class.getResourceAsStream("从类路径的根路径开始写的一个文件路径");

        // 获得资源的字节流
        InputStream inStream = PropertiesDemo.class.getResourceAsStream("/config/user.properties");
        // 加载资源文件
        properties.load(inStream);

        // 读取
        String name = properties.getProperty("name");
        String age = properties.getProperty("age");
        String gender = properties.getProperty("gender");
        System.out.println(name);
        System.out.println(age);
        System.out.println(gender);
    }

}
