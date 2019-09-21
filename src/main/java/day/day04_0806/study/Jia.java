package day.day04_0806.study;
public class Jia {

    public static void main(String[] args) {
        
        int he = getHe(1, 2);
        System.out.println(he);
        getHe(2, 2);
    }
    private static int getHe(int a , int b) {
        int c = a+b;
        return c;
    }
}
