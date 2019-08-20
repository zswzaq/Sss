/**
 * 
 */
package day06_0813.study;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author zhangshuai
 *
 */
public class Test2 {

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>();
        // ArrayList 有序，可以重复，索引从0
        names.add("zs1");
        names.add("zs2");
        names.add("zs3");
        names.add("zs4");
        System.out.println(names);
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }
        // for (String name : names) {
        // System.out.println(name);
        // }
        
        // 迭代
        // hasNext() 是否有下一个元素
        // next() 获取下一个元素
        for (Iterator iterator = names.iterator(); iterator.hasNext();) {
            String string = (String) iterator.next();
            System.out.println(string);
        }
        names.clear();
    }
}
