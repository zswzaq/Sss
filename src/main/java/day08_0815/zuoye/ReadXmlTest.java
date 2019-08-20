package day08_0815.zuoye;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 解析XML文件的基本流程 1:创建SAXReader,用来读取XML文件 2:指定xml文件使得SAXReader读取，并解析问文档对象Document
 * 3:获取根元素 4:获取每一个元素，从而达到解析的目的
 * 
 * @author Administrator
 */
public class ReadXmlTest {
    public static void main(String[] args) throws Exception {
        Map<String, Map> readXMLMap = readXML("/UiLibrary.xml");
        Set<String> keySet = readXMLMap.keySet();
        for (String keys : keySet) {
            System.out.println(keySet + "::" + readXMLMap.get(keys));
        }
    }

    private static Map<String, Map> readXML(String url) throws Exception {
        // 创建大Map对象
        Map<String, Map> map = new HashMap<String, Map>();
        Map<String, Locator> locatorMap = null;
        // 创建一个SaxReader对象
        SAXReader saxReader = new SAXReader();
        // 读取一个XML文件，---》成为一个Document对象（文档对象）
        Document read = saxReader.read(ReadXmlTest.class.getResourceAsStream(url));
        // 读取根节点（跟标签、跟元素），返回一个Element对象
        Element rootElement = read.getRootElement();
        // 读取根节点的所有子节点
        List<Element> elements = rootElement.elements();
        // 遍历
        for (Element element : elements) {
            // 获取子节点的信息 ， 提取子节点上的id属性，返回是Attribute类型
            Attribute nameAttribute = element.attribute("name");
            // 获取 name 所有的值::::第一层map的key值
            String nameString = nameAttribute.getValue();
            // 创建locator对象，
            Locator locator = new Locator();
            // 获取Locator标签的所有子标签
            List<Element> locatorInfoElements = element.elements();
            locatorMap = new HashMap<String, Locator>();
            for (Element locatorInfoElement : locatorInfoElements) {
                // System.out.println(locatorInfoElement.getName());
                // 获取所有子节点的信息 ， 提取子节点上的text属性，返回是Attribute类型
                List<Attribute> locatorLists = locatorInfoElement.attributes();
                // 得到每条标签的值：重置、用户名、密码：：第二层map 的key值
                String stringValue = locatorInfoElement.getStringValue();
                for (Attribute attributes : locatorLists) {
                    // 获取标签中的key和value值
                    String key = attributes.getName();
                    String value = attributes.getStringValue();
                    // 如果key是by, 就locator.setBy,如果key是value,
                    // 就locator.setValue,,如果key是desc, 就locator.setDesc
                    /*
                     * if ("by".equals(key)) { locator.setBy(value); } else if
                     * ("value".equals(key)) { locator.setValue(value); } else
                     * if ("desc".equals(key)) { locator.setDesc(value); }
                     */
                    // 反射机制:1.获取类的字节码对象
                    Class<Locator> class1 = Locator.class;
                    // 2.设置setXxx方法
                    String setMethod = "set" + (key.charAt(0) + "").toUpperCase() + key.substring(1);
                    // 3.获得setXxx方法
                    Method method = class1.getMethod(setMethod, String.class);
                    // 4.调用此方法
                    method.invoke(locator, value);
                }
                locatorMap.put(stringValue, locator);
            }
            map.put(nameString, locatorMap);
        }
        return map;
    }
}
