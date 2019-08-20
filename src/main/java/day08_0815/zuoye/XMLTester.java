package day08_0815.zuoye;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XMLTester {
    public static void main(String[] args) throws DocumentException {
        HashMap<String, Map> map = readXml("/UiLibrary.xml");
        Set<String> set = map.keySet();
        for (String key : set) {
            System.out.println(key + "--->" + map.get(key));
        }
    }

    private static HashMap<String, Map> readXml(String xmlPath) throws DocumentException {
        // 定义HashMap容器存放数据对象
        HashMap<String, Map> map = new HashMap<String, Map>();
        // 生成解析器
        SAXReader saxReader = new SAXReader();
        // 获取xml文档对象
        Document document = saxReader.read(XMLTester.class.getResourceAsStream(xmlPath));
        // 获取根节点
        Element rootElement = document.getRootElement();
        // 获取根节点下的所有子节点集合
        List<Element> subElements = rootElement.elements();
        // 遍历取出每个子节点
        for (Element subElement : subElements) {
            // 创建一个locator对象
            Locator locator = new Locator();
            // 取出每一个子节点的name属性值
            Attribute attribute = subElement.attribute("name");
            // name属性值，作为Map的key值
            String nameString = attribute.getValue();
            List<Element> subElementInfoList = subElement.elements();
            // 循环取出每个子节点下的信息
            HashMap<String, Locator> SubMap = new HashMap<String, Locator>();
            for (Element subElementInfo : subElementInfoList) {
                String subNameString = subElementInfo.getStringValue();
                Attribute subAttribute1 = subElementInfo.attribute("by");
                locator.setBy(subAttribute1.getValue());
                Attribute subAttribute2 = subElementInfo.attribute("value");
                locator.setValue(subAttribute2.getValue());
                Attribute subAttribute3 = subElementInfo.attribute("desc");
                locator.setDesc(subAttribute3.getValue());
                SubMap.put(subNameString, locator);
            }
            // 把用户对象存入容器
            map.put(nameString, SubMap);
        }
        return map;
    }
}
