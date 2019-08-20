package day04_0806.study;

public class Var {

    // 变量
    // 局部变量：需要初始化
    // 局部变量：没有修饰符 public等
    // 全局变量：可以不初始化，默认String：NULL   int：0
    // 全局变量：有修饰符，有静态非静态
    // 就近原则
    // 不要让变量同名
    static int aaa =1;
    static String[][] a;
    
    public static void main(String[] args) {


        System.out.println(a);
        // 空指针异常：由于一个对象为null了，还去访问他的属性和方法，一定会空指针异常
        
        //System.out.println(a.length);//空指针异常
        main1(args);

    }

    public static  void main1(String[] args) {// 类方法。静态方法
        System.out.println(aaa);
    }
    public void my() {// 实例方法（对象方法）
        
    }
}
