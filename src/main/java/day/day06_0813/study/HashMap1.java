/**
 * 
 */
package day.day06_0813.study;

import java.util.HashMap;
import java.util.Set;

public class HashMap1 {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap();
        map.put(1, "zs1");
        map.put(2, "zs2");
        map.put(3, "zs3");
        map.put(3, "zs3333333");// 覆盖值
        Set<Integer> keySet = map.keySet();
        System.out.println(keySet);
        System.out.println(map);
        System.out.println(map.get(1));

        for (Integer key : keySet) {
            System.out.println(key + ":" + map.get(key));
        }

    }
}
