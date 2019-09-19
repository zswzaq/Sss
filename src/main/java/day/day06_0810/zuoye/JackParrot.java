package day.day06_0810.zuoye;

//一只叫Jack的1岁的虎皮鹦鹉，发现了一张干净的，面额为10块的真钱，它叼走了
//继承鹦鹉类，实现钱接口的方法
public class JackParrot extends Parrot implements Money {

    // 重写钱接口里的方法
    @Override
    public boolean isTrueCheck() {
        //虎皮鹦鹉看到的是真钱,直接返回true
        return true;
    }

    @Override
    public boolean isChearCheck() {
        //虎皮鹦鹉看到的是干净的钱，直接返回true
        return true;
    }

    @Override
    public boolean amountCheck(int amount) {
        if (amount >= 10) {
            return true;
        } else {
            return false;
        }
    }
}
