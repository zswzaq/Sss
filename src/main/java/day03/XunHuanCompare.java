package day03;

public class XunHuanCompare {

    public static void main(String[] args) {
        int csadsas = 1;
        
        // 判断次数多一次
//        int sum = 0;
//        for (int i = 1; i <= 100; i++) {
//            sum+=i;
//        }
//        System.out.println(sum);
//        for (; true; ) {
//            System.out.println("1");
//        }
        
//        int a = 1;
//        while (a <= 100) {
//            System.out.println(a);
//            a += 1;
//        }
//        int a = 1;  // 判断次数多一次
//        do {
//            System.out.println(a);
//          a += 1;
//        } while (a <= 100);// 判断次数==循环次数
        
        
        int sum = 0;
        for (int i = 1; i <= 5; i++) {
            if (i%2 ==0) {
//                continue;
                
            }
            sum+=i;
            
        }
        System.out.println(sum);
        
        
    }

}
