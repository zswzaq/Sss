package day02.zuoye;

import java.util.Arrays;

public class Demo0801 {

    public static void main(String[] args) {
        // int a = 1.1; // 错，1.1默认是double类型
        // int f = 2; // 对
        // char b = lemon; // 错，需要单引号
        // char c = %; // 错，需要单引号
        // char p = "%"; // 错，需单引号
        // char d = '%'; // 对
        // long e = 1.1; // 错，1.1默认是double类型
        // long g = 3; // 对
        // float j = 2.3; // 错， 2.3默认是double类型，需要加上F 2.3F
        // float m = 2.3f; // 对
        // double n = 3.33 // 错，没加分号
        // 2：创建一维数组
        // 请使用两种语法创建数组，数组的元素为{“我”,”是”,”最”,”棒”,”的”}
        String[] arr = new String[5];
        arr[0] = "我";
        arr[1] = "是";
        arr[2] = "最";
        arr[3] = "棒";
        arr[4] = "的";
        System.out.println(Arrays.toString(arr));
        String[] arr1 = {"我","是","最","棒","的"};
        System.out.println(Arrays.toString(arr1));
        // 请使用请使用两种语法创建数组，数组的元素为{100,200,300,400,500}
        /*
         * int[] arr2 = {100,200,300,400,500};
         * System.out.println(Arrays.toString(arr2)); int[] arr3 = new int[5];
         * arr3[0] = 100; arr3[1] = 200; arr3[2] = 300; arr3[3] = 400; arr3[4] =
         * 500; System.out.println(Arrays.toString(arr3));
         */
        // 3：创建二维数组
        // 请使用两种语法来创建数组，数组的元素为{{“第一个”,”二维”},{“数”,”组”}}
        String[][] er = {{"第一个","二维"},{"数","组"}};
        System.out.println(Arrays.toString(er[0]));
        System.out.println(Arrays.toString(er[1]));
        System.out.println("--------------------------");
        String[][] er1 = new String[2][2];
        er1[0][0] = "第一个";
        er1[0][1] = "二维";
        er1[1][0] = "数";
        er1[1][1] = "组";
        // 请使用两种语法来创建数组，数组的元素为{{“第”,”二”},{“个”,”二”},{“维”,”数”,”组”}}
        String[] s1 = {"第","二"};
        String[] s2 = {"个","二"};
        String[] s3 = {"维","数","组"};
        String[][] ss = {s1,s2,s3};
        System.out.println(ss[0][0]);
        System.out.println(ss[1][1]);
        System.out.println(ss[2][2]);
        String [][] ss1 = {{"第","二"},{"个","二"},{"维","数","组"}};
        for (String[] strings : ss1) {
            System.out.println(Arrays.toString(strings));
        }
        // 请使用两种语法来创建数组，数组的元素为{{10,20},{30,40}}
        int[][] eri = {{10,20},{30,40}};
        System.out.println(Arrays.toString(eri[0]));
        System.out.println(Arrays.toString(eri[1]));
        int[][] eri1 = new int[2][2];
        eri1[0][0] = 10;
        eri1[0][1] = 20;
        eri1[1][0] = 30;
        eri1[1][1] = 40;
        // 请使用两种语法来创建数组，数组的元素为{{50,60},{70,80},{90,100,110}}
        int[] ss11 = {50,60};
        int[] ss2 = {70,80};
        int[] ss3 = {90,100,110};
        int[][] sss = {ss11,ss2,ss3};
        System.out.println(sss[0][0]);
        System.out.println(sss[1][1]);
        System.out.println(sss[2][2]);
        int [][] sss1 = {{50,60},{70,80},{90,100,110}};
        for (int[] stringss : sss1) {
            System.out.println(Arrays.toString(stringss));
        }
    }

}

