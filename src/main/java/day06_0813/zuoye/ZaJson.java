package day06_0813.zuoye;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSONObject;

public class ZaJson {
    /**
     * 3：将如下Json字符串转成Java对象 1). {"name": "tom","age": "26","gender": "男"} 2). [
     * {"name": "tom","age": "26","gender": "男"}, {"name": "jack","age":
     * "25","gender": "男"}, {"name": "rose","age": "26","gender": "女"} ]
     * 
     * @param args
     */
    public static void main(String[] args) {
        String j1 = "{\"name\": \"tom\",\"age\": \"26\",\"sex\": \"男\"}";
        String j2 = "[{\"name\": \"tom\",\"age\": \"26\",\"sex\": \"男\"}, "
                + "{\"name\": \"jack\",\"age\":\"25\",\"sex\": \"男\"}, "
                + "{\"name\": \"rose\",\"age\": \"26\",\"sex\": \"女\"} ]";

        // parse方法，转换，，，，转换为Map，需要强转
        // Map<String, String> m = (Map<String, String>) JSONObject.parse(j1);
        // System.out.println(m);
        // Set<String> set = m.keySet();
        // for (String key : set) {
        // System.out.println(key+":"+m.get(key));
        // }
        // 2.将json对象换成Person类
        // Person per = JSONObject.parseObject(j1, Person.class);
        // System.out.println(per.toString());
        
        //用集合接收，  parseArray
        // 对象使用Person.class   引用类型
         List<Person> pers = JSONObject.parseArray(j2, Person.class);
         //System.out.println(pers);
         for (Person person : pers) {
            System.out.println(person);
//            System.out.println(person.getName());
//            System.out.println(person.getAge());
//            System.out.println(person.getSex());
        }
    }

}
