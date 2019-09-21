/**
 * 
 */
package day.day06_0813.study;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author zhangshuai
 *
 */
public class HashSet1 {

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<String>();
        set.add("苹果");
        set.add("香蕉");
        set.add("葡萄");
        set.add("哈密瓜");
        System.out.println(set.size());
        for (String string : set) {
            System.out.println(string);
        }
        for (Iterator iterator = set.iterator(); iterator.hasNext();) {
            String string = (String) iterator.next();
            System.out.println(string);
        }
        
        
        
//        Object[] array = set.toArray();
//        for (Object object : array) {
//            String str = (String) object;//向下，需要 强转
//            System.out.println(str);
//        }
    }
}
