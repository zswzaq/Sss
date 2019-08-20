package day03;

public class YunSuanFu1 {
    /**
     * 11111111111 11111111111 11111111111 11111111111 11111111111 11111111111
     */
    public static void main(String[] args) {
        // 比较运算符 ＞ ＜
        int a = 3;
        int b = 10;
        // System.out.println(a>b);
        // System.out.println(a<b);
        // System.out.println(a==b);
        // System.out.println(a!=b);
        // System.out.println(a>=b);
        // System.out.println(a<=b);
        // 逻辑运算符 & | 短路：&& ||       ! 非
        int c = 12;
        // 当且仅当，两个
        System.out.println(a > b && b < c);
        System.out.println(a < b && b < c);
        System.out.println(a > b && b > c);
        System.out.println(a < b && b > c);

        String user = "sasa";
        String pwd = "123";
        if (user.length()==4 && pwd.length()==3) {
            System.out.println("登陆成功");
        }else {
            System.out.println("登陆失败，信息错误");
        }
    }

}
