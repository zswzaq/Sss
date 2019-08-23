package com.zs.day11.pack4;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Failure_Test extends BaseTest {

    @Test
    public void fun2() {
        // 创建一个投资人，
        double before = zs.getMoney();
        // 充值100
        zs.recharge(99);
        double after = zs.getMoney();// 1.实际结果
        // 2.预期结果：：： // 3.对比
        double as = before;
        boolean b = (after == as);
        Assert.assertTrue(b);

    }

    @Test
    public void fun3() {
        double before = zs.getMoney();
        // 充值-100
        zs.recharge(-100);
        double after = zs.getMoney();
        boolean b = before == after;
        Assert.assertTrue(b);
    }

}
