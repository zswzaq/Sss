package day.day13_0829.test1_testNg;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class Register_Test_Case_Data1 {

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
      new Object[] { 3, "b" },
      new Object[] { 4, "b" },
      new Object[] { 5, "b" },
    };
  }
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
  }
}
