package com.zs.day11.pack1;

/**
 * 借款人
 */
public class Borrower extends Member{//继承

    // 借款人重写充值方法
    @Override
    public boolean recharge(double money) {

//        System.out.print("borrower");
        boolean recharge = super.recharge(money);
        if (recharge ) {
            System.out.println("充值成功, 可以去消费");
        }
        return recharge;
    }

    @Override
    public boolean withdrawal(Integer money) {
        boolean w = super.withdrawal(money);
        if(w){
            System.out.println("borrower提现成功");
        }

        return w;

    }
}
