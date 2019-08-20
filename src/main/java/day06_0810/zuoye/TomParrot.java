package day06_0810.zuoye;

//一只叫Tom的2岁的金刚鹦鹉，发现了一张干净的、面额为3块的假钱，它不屑的看了看

//继承鹦鹉类，实现钱接口的方法
public class TomParrot extends Parrot  implements  Money{


    @Override
    public boolean isTrueCheck() {
        return false;
    }

    @Override
    public boolean isChearCheck() {
        return false;
    }

    public boolean amountCheck(int amount) {
        if (amount >= 10) {
            return true;
        } else {
            return false;
        }
    }

//    public boolean isTrueCheck() {
//        return false;
//    }
//
//    public boolean isChearCheck() {
//        return false;
//    }
//
//    public boolean amountCheck(int amout) {
//        if (amout >= 10) {
//            return true;
//        } else {
//            return false;
//        }
//    }
}
