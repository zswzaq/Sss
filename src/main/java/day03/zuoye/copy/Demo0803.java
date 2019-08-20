package day03.zuoye.copy;

public class Demo0803 {

    public static void main(String[] args) {
        // 1：打印如下图案(直角三角形)
        // *
        // * *
        // * * *
        // * * * *
        // * * * * *
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("------------------------");
        // 2：写一段程序分别求出0到100之间所有的偶数的和以及奇数的和
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 != 0) {
                continue;
            }
            sum += i;
        }
        System.out.println("0到100之间所有的偶数的和：" + sum);
        System.out.println("------------------------");
        int sum1 = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                continue;
            }
            sum1 += i;
        }
        System.out.println("0到100之间所有的奇数的和：" + sum1);
        System.out.println("------------------------");
        // 3：写一段程序求1+2+3+...+999+1000的值
        int sum2 = 0;
        for (int i = 1; i <= 1000; i++) {
            // System.out.println(i);
            sum2 += i;
        }
        System.out.println("1+2+3+...+999+1000的和：" + sum2);
    }

}
