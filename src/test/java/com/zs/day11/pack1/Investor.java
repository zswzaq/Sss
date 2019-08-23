package com.zs.day11.pack1;

/**
 * 投资人
 */

public class Investor extends Member {// 继承

    //投资人重写充值方法
    @Override
    public boolean recharge(double money) {
        boolean b = super.recharge(money);
        if (b) {
            System.out.println("充值成功,你可以去投资了");
        }
        return b;
    }

    @Override
    public boolean withdrawal(Integer money) {
        boolean w = super.withdrawal(money);
        if (w) {
            System.out.println("zs提现成功");
        }
        return w;
    }
}
