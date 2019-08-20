package day04_0806.study;
public class Switch {
    public static void main(String[] args) {
        //
        int day = 1;
        switch (day) {
        case 1:
            System.out.println("星期一");
            break;// 跳出分支，不加的话，会case穿透
        case 2:
            System.out.println("星期二");
            break;// 跳出分支，不加的话，会case穿透
        case 3:
            System.out.println("星期三");
            break;
        case 4:
            System.out.println("星期四");
            break;
        case 5:
            System.out.println("星期五");
            break;
        case 6:
            System.out.println("星期六");
            break;
        case 7:
            System.out.println("星期日");
            break;
        default:
            System.out.println("非法");
            break;
        }
        
        
        int day1 =2;
            getDay(day1);
    }

    private static void getDay(int day1) {
        switch (day1) {
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
            System.out.println("工作");
            break;
        case 6:
        case 7:
            System.out.println("休息");
            break;
      default:
        System.out.println("非法");
        break;
      }
    }

}
