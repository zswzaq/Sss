package day.day03.zuoye.copy2;

public class ZhiShu {
    /**
     * 质数
     * 
     * @param args
     */
    public static void main(String[] args) {
        // 质数 ,如果要求200以内的质数 将100改为两百即可
        for (int i = 2; i <= 100; i++) {
            boolean zhishu = true; // 每个数除以它之前的数，是否能整出
            for (int j = 2; j < i - 1; j++) {
                if (i % j == 0) {
                    zhishu = false;
                    break;// 可以省去，但是效率会下降
                }
            }
            if (zhishu) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        // 找出1-100的质数之和
        int k = 2;
        for (int i = 2; i <= 100; i++) { // i值为2，质数为除去1和自身整除的数 j初始值为2去除偶数
            for (k = 2; k < i; k++) { // 内层循环遍历查询i的整除数
                if (i % k == 0) { // 判断当前i是否可以整除k值
                    break; // 整除则跳出循环
                }
            }
            // 如果当前内循环没有正常结束k与i对比不成立
            if (k >= (i - 1)) { // 计算当前的i值是否等于i-1的值 ，相等则说明为质数
                System.out.print(i + " "); // 输出质数
            }
        }
    }
}
