package com.zs.day11;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.zs.day11.pack1.Investor;
import com.zs.day11.pack1.Member;

public class NewTest {
    @Test
    public void f() {
        // 创建一个投资人
        Member zs = new Investor();
        double before = zs.getMoney();
        zs.recharge(100);
        double after = zs.getMoney();
        boolean b = before == (after + 100);
        Assert.assertFalse(b);
    }

    @Test
    public void f1() {
        // 创建一个投资人
        Member zs = new Investor();
        double before = zs.getMoney();
        zs.recharge(99);
        double after = zs.getMoney();
        boolean b = before == (after + 99);
        Assert.assertFalse(b);
    }

    @Test
    public void f2() {
        Member zs = new Investor();
        double before = zs.getMoney();
        zs.recharge(-100);
        double after = zs.getMoney();
        boolean b = before == (after - 100);
        Assert.assertFalse(b);
    }

    @Test
    public void f3() {
        Member zs = new Investor();
        double before = zs.getMoney();
        zs.recharge(100000);
        double after = zs.getMoney();
        boolean b = before == (after + 100000);
        Assert.assertFalse(b);
    }

}
