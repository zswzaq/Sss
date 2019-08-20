package day06_0810.zuoye;

/**
 * 一：采用面向对象三大特性对前程贷进行编码，要求如下：
 * （1）包含会员类、投资人类、借款人类
 * （2）实现会员的注册、登录(简单逻辑即可)、充值、提现方法
 * 二：实操并掌握如下String类的API
 * 判断是否以指定字符串开头或结尾 startsWith endWith
 * 字符串截取 substring
 * 字符串拆分 split
 * 字符串查找 indexOf lastIndexOf contains
 * 字符串比较 equals equalsIgnoreCase
 * 字符串拼接 concat
 * 判空 isEmpty
 * 去掉左右空格 trim
 * 字符串长度 length
 * 转大小写 toUpperCase toLowerCase
 * 替换 replace replaceFirst replaceAll
 * 字符串描述 valueOf
 * 三：对如下场景景进行编程
 * 动物园有鹦鹉表演的活动，鹦鹉很聪明，会叼钱，如果RMB是假钱、或者面额小于10块,或者不干净，鹦鹉都不会叼
 * 1：一只叫Tom的2岁的金刚鹦鹉，发现了一张干净的、面额为3块的假钱，它不屑的看了看
 * 2：一只叫Jack的1岁的虎皮鹦鹉，发现了一张干净的，面额为10块的真钱，它叼走了
 */
public class TestString {
    // 1.
    public static void main(String[] args) {
        String str = "I am from China!!!    ";
        //1.判断是否以指定字符串开头或结尾 startsWith endWith
//        System.out.println(str.startsWith("I"));
//        System.out.println(str.startsWith(" "));
//        System.out.println(str.endsWith("!"));
//        //2.字符串截取 substring  (左开右闭、或者只写一个参数)
//        System.out.println(str.substring(1));
//        System.out.println(str.substring(0, 6));
//        //3.字符串拆分 split, 返回值是数组
//        String[] strings = str.split(" ");
//        System.out.println(Arrays.toString(strings));
        //4.字符串查找 indexOf:字符串的索引； lastIndexOf：最后字符串出现的索引；； contains：：是否包含字符串
//        System.out.println(str.indexOf("a"));
//        System.out.println(str.lastIndexOf("a"));
//        System.out.println(str.contains(" "));
        //5.字符串比较 equals:比较值 ；；equalsIgnoreCase：忽略大小写
//        System.out.println(str.equals("I am from China!!!"));
//        System.out.println(str.equals("I am from china!!!"));
//        System.out.println(str.equals("I am from China!!"));
//        System.out.println(str.equalsIgnoreCase("I am from china!!!"));
        //6.字符串拼接 concat
//        System.out.println(str.concat(",I Love"));
//        //7.判空 isEmpty
//        System.out.println(str.isEmpty());
//        //8.去掉左右空格 trim
//        System.out.println(str.trim());
//        // 9.字符串长度 length
//        System.out.println(str.length());
//        // 10.转大小写 toUpperCase toLowerCase
//        System.out.println(str.toLowerCase());
//        System.out.println(str.toUpperCase());
        //11.替换 replace：普通字符串替换； replaceFirst：正则表达式 替换第一个， replaceAll：正则表达式 替换所有字符串
//        System.out.println(str.replace("a", "b"));
//        System.out.println(str.replaceFirst("a", "b"));
//        System.out.println(str.replaceAll(".", "b"));
        // 12.字符串描述 valueOf
//        String s = String.valueOf(123);// 转换为字符串
//        System.out.println(s);

        // 鹦鹉测试：
        //一只叫Tom的2岁的金刚鹦鹉，发现了一张干净的、面额为3块的假钱，它不屑的看了看
        //继承
        Parrot tom = new TomParrot();
        tom.setName("tom");
        tom.setAge(3);
        tom.setType("金刚鹦鹉");
        //多态，实现钱的接口
        Money tomMoney = new TomParrot();
        boolean b = tomMoney.isChearCheck();
        System.out.println(b);
        boolean amountCheck = tomMoney.amountCheck(10);
        System.out.println(amountCheck);
        boolean clear = tomMoney.isChearCheck();
        System.out.println(clear);
        if (b && amountCheck && clear) {
            System.out.println("叼走了");
        } else {
            System.out.println("不屑的看了看");
        }
        //一只叫Jack的1岁的虎皮鹦鹉，发现了一张干净的，面额为10块的真钱，它叼走了
        // 继承
        Parrot jack = new JackParrot();
        jack.setName("Jack");
        jack.setAge(1);
        jack.setType("虎皮鹦鹉");
        System.out.println(jack.getAge()+"岁的"+jack.getName()+",他是"+jack.getType());
        //多态，实现接口
        Money jacMoney = new JackParrot();
        boolean is = jacMoney.isChearCheck();
        System.out.println(is);
        boolean amountCheck1 = jacMoney.amountCheck(10);
        System.out.println(amountCheck1);
        boolean clear1 = jacMoney.isChearCheck();
        System.out.println(clear1);
        if (is && amountCheck1 && clear1) {
            System.out.println("叼走了");
        } else {
            System.out.println("不屑的看了看");
        }
    }
}
