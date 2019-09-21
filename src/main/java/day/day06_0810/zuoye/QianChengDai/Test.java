package day.day06_0810.zuoye.QianChengDai;

public class Test {
    public static void main(String[] args) {
        //创建一个投资人对象:zs
        Member zs = new Investor();
        // 注册方法
        boolean reg;
        if (zs.reg("13322221111", "123123")) reg = true;
        else reg = false;
//        System.out.println(reg);
        zs.reg("13322221111", "123123");
        //登录方法
        zs.login("13322221113", "123456");
        // 充值方法
        zs.recharge(100);
        System.out.println("账户余额："+zs.getMoney());
        zs.recharge(100);
        System.out.println("账户余额："+zs.getMoney());
        zs.recharge(100);
        System.out.println("账户余额："+zs.getMoney());
        // 提现方法
        zs.withdrawal(9);
        System.out.println("账户余额："+zs.getMoney());
        zs.withdrawal(50);
        System.out.println("账户余额："+zs.getMoney());
        System.out.println("-------------------------------------------------");

        //创建一个借款人对象:borrower
        Member borrower = new Borrower();
        // 注册方法
        boolean b = borrower.reg("13322221111", "123123");
        System.out.println(b);
        borrower.reg("13322221111", "123123");
        //登录方法
        borrower.login("13322221113", "123456");
        // 充值方法
        borrower.recharge(100);
        System.out.println("账户余额："+borrower.getMoney());
        borrower.recharge(100);
        System.out.println("账户余额："+borrower.getMoney());
        // 提现方法
        borrower.withdrawal(9);
        System.out.println("账户余额："+borrower.getMoney());
        borrower.withdrawal(50);
        System.out.println("账户余额："+borrower.getMoney());
    }
}
