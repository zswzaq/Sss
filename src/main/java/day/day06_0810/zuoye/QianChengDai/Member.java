package day.day06_0810.zuoye.QianChengDai;

/**
 * 一：采用面向对象三大特性对前程贷进行编码，要求如下：
 * （1）包含会员类、投资人类、借款人类
 * （2）实现会员的注册、登录(简单逻辑即可)、充值、提现方法
 */
public class Member {
    //封裝： 1.私有化属性
    private String phone;
    private String password;
    private String name;
    private double money;

    // 2.提供公开的get set方法
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    //定义会员类的方法，行为：
    // 注册方法
    public boolean reg(String phone, String password) {
        if (phone.length() == 11 && password.length() == 6) {
            System.out.println("注册成功");
        } else {
            System.out.println("登录失败，账号密码有误");
            return false;
        }
        return true;
    }

    // 登录方法
    public void login(String phone, String password) {
        if (phone.length() == 11 && password.length() == 6) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败，账号密码有误");
        }
    }

    // 充值方法
    public boolean recharge(double money) {
        if (money < 10 || money > 100000) {
            System.out.println("金额小于10，或者大于100000，充值失败");
            return false;
        } else {
            this.money += money;
//            System.out.print("充值成功:余额：");
            return true;
        }
    }

    //提现方法
    public boolean withdrawal(Integer money) {
        if (money < 10 || money > 100000) {
            System.out.println("金额小于10，或者大于100000，提现失败");
            return false;
        } else {
            this.money -= money;
//            System.out.print("提现成功:账户余额：");
            return true;
        }

    }
    //有参构造器
//    public Member(String phone, String password, String name, String money) {
//        this.phone = phone;
//        this.password = password;
//        this.name = name;
//        this.money = money;
//    }
}
