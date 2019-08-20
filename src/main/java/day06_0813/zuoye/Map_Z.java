
package day06_0813.zuoye;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 
 * 2.新建一个类，类名自取，main函数里创建一个HashMap对象。使用今天上课讲得到的api完成下面的要求。
 * 1).往这个HashMap对象里添加自己的姓名和年龄，键值分别为”name”和”age”。 2).判断这个集合是否为空，并打印判断的结果。
 * 3).打印这个集合的大小。 4).判断这个集合是否包含数据“王五”，并打印判断结果。 5).将map里的age删掉。 6).获取map的所有键，并打印。
 * 7).获取map的所有值，并打印。 8).用两种方法获取map里所有的键值对，并打印。
 * 
 *
 */
public class Map_Z {
    public static void main(String[] args) {
        Map<String, String> zMap = new HashMap<String, String>();
        zMap.put("name", "xiaoming");
        zMap.put("age", "22");
        // System.out.println("集合是否为空:"+zMap.isEmpty());
        // System.out.println("集合大写:"+zMap.size());
        // System.out.println("集合是否包含“王五”:"+zMap.containsValue("王五"));
        // 删除age
        // zMap.remove("age");
        // System.out.println(zMap);
        // 获取key，keySet()
        // Set<String> k = zMap.keySet();
        // System.out.println("此map中所有的key："+k);
        // // 获取values
        // for (String v : k) {
        // System.out.println("map里值："+v);
        // }
        // 1
        // for (String key : zMap.keySet()) {
        // System.out.println(key + ":" + zMap.get(key));
        // }
        // 2
        // Set<Entry<String, String>> entrySet = zMap.entrySet();
        // System.out.println(entrySet);
        // 3
        /* 利用Iterator迭代 */
        Set<String> keys = zMap.keySet();
        // System.out.println(keys);
        for (Iterator id = keys.iterator(); id.hasNext();) {
            String key = (String) id.next();
            String value = zMap.get(key);
            System.out.println(key + "::" + value);
        }

    }

}
