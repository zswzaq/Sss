/**
 * 
 */
package day06_0813.study;

import java.util.ArrayList;

/**
 * @author zhangshuai
 *
 */
public class Test {

    public static void main(String[] args) {
        String name = "shadow";
        // 保存70个人
        String[] names = new String[70];
        // 又来了一个人， 需要用可变数组，：：：ArrayList
        ArrayList<String> arr = new ArrayList<String>();
        // ArrayList 有序，可以重复，索引从0
        arr.add("zs1");
        arr.add("zs2");
        arr.add("zs3");
        arr.add("zs4");
        arr.add("zs5");
        arr.add("zs6");
        System.out.println(arr);
        // 取出 get()
        System.out.println(arr.get(0)+"是第一个值");
        //set 修改
        System.out.println(arr.set(0, "zs"));
        //集合大小，size()
        System.out.println(arr.size());
        // remove() 移除
        System.out.println(arr.remove(4));
        System.out.println(arr.get(4));
        // isEmpty()
        System.out.println(arr.isEmpty());
        // contains()
        System.out.println(arr.contains("zs"));
        
    }
}
