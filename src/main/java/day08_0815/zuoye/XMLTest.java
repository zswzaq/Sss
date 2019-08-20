package day08_0815.zuoye;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XMLTest {

    public static void main(String[] args) throws Exception {
        List<User> users = readXml("/User.xml");
        for (User user : users) {
            System.out.println(user);
        }
    }

    private static List<User> readXml(String url) throws Exception {
        // 创建一个List对象
        List<User> users = new ArrayList<User>();
        // 创建SaxReader对象
        SAXReader saxReader = new SAXReader();
        // 读取一个XML文件，---》成为一个Document对象（文档对象）
        Document read = saxReader.read(XMLTest.class.getResourceAsStream(url));
        // 读取根节点（跟标签、跟元素），返回一个Element对象
        Element rootElement = read.getRootElement();
        // System.out.println(rootElement.getName());
        // 读取根节点的所有子节点
        List<Element> elements = rootElement.elements();
        // System.out.println(elements.get(0));
        // 遍历
        for (Element element : elements) {
            // 获取子节点的信息 ， 提取子节点上的id属性，返回是Attribute类型
            Attribute idAttribute = element.attribute("id");
            // 获取id 所有的值
            String idString = idAttribute.getValue();
            // 创建User对象，设置id
            User user = new User();
            user.setId(idString);
            // 获取USer标签的所有子标签
            List<Element> userInfoElements = element.elements();
            for (Element userInfoElement : userInfoElements) {
                // 获取标签中的key和value值
                String key = userInfoElement.getName();
                String value = userInfoElement.getStringValue();
                // 如果key是name 就user.setName，如果key是age 就user.setAge， 如果key是sex 就user.setSex
                /*
                 * if ("name".equals(key)) { user.setName(value); } else if ("age".equals(key))
                 * { user.setAge(value); } else if ("sex".equals(key)) { user.setSex(value); }
                 */
                Class uClass = user.getClass();
                String setMethod = "set" + (key.charAt(0) + "").toUpperCase() + key.substring(1);
                Method method = uClass.getMethod(setMethod, String.class);
                method.invoke(user, value);
            }
            // 把user对象添加到List中
            users.add(user);
        }
        return users;
    }

}
