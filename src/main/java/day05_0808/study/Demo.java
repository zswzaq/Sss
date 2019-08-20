package day05_0808.study;

public class Demo {
    public static void main(String[] args) {
        
        int add = add(1,2,3,4,5,6,7);
        System.out.println(add);
    }
    private static int add(int...arr) {
        int sum=0;
        for (int i : arr) {
            sum +=i;
        }
        return sum;
    }
    // 无参构造器
    // 构造函数：：：创建对象的函数
    // 不写的话：：：默认已经创建 
    //
    public Demo() {
        
    }

}
