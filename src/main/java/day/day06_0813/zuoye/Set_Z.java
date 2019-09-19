/**
 * 
 */
package day.day06_0813.zuoye;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 1:新建一个类，类名自取，main函数里创建一个HashSet对象。使用今天上课讲得到的api完成下面的要求。
 * 1).往这个HashSet对象里添加如下String类型的数据：“张三”，“李四”，“王五”，“张三”，”赵六”
 * 2).判断这个集合是否为空，并打印判断的结果。 3).打印这个集合的大小。 4).判断这个集合是否包含数据"王五"。 5).将”张三”这条数据删掉。
 * 6).利用迭代器迭代获取set集合中的每个元素，并打印。 7).将set转换成数组。并循环打印数组中的元素
 * 
 * 2.新建一个类，类名自取，main函数里创建一个HashMap对象。使用今天上课讲得到的api完成下面的要求。
 * 1).往这个HashMap对象里添加自己的姓名和年龄，键值分别为”name”和”age”。 2).判断这个集合是否为空，并打印判断的结果。
 * 3).打印这个集合的大小。 4).判断这个集合是否包含数据“王五”，并打印判断结果。 5).将map里的age删掉。 6).获取map的所有键，并打印。
 * 7).获取map的所有值，并打印。 8).用两种方法获取map里所有的键值对，并打印。
 * 
 * 3：将如下Json字符串转成Java对象 1). {"name": "tom","age": "26","gender": "男"} 2). [
 * {"name": "tom","age": "26","gender": "男"}, {"name": "jack","age":
 * "25","gender": "男"}, {"name": "rose","age": "26","gender": "女"} ]
 */
public class Set_Z {
    public static void main(String[] args) {
        Set<String> aSet = new HashSet<String>();
        aSet.add("zs");
        aSet.add("李四");
        aSet.add("王五");
        aSet.add("张三");
        aSet.add("赵柳");
        // System.out.println("集合是否为空:"+aSet.isEmpty());
        // System.out.println("集合的大小:"+aSet.size());
        // System.out.println("集合是否包含数据\"王五\"："+aSet.contains("王五"));
        // //将”张三”这条数据删掉
        // aSet.remove("张三");
        // System.out.println("将”张三”这条数据删掉后的集合："+aSet);
        // //利用迭代器迭代获取set集合中的每个元素，并打印
        // for (Iterator it = aSet.iterator(); it.hasNext();) {
        // String name = (String) it.next();
        // System.out.println(name);
        // }
        // 7).将set转换成数组。并循环打印数组中的元素
        Object[] arraySet = aSet.toArray();
        for (int c = 0; c < arraySet.length; c++) {
            System.out.println(arraySet[c]);
        }
    }

}
