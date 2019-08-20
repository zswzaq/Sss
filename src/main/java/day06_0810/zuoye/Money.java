package day06_0810.zuoye;


//钱接口
public interface  Money {


    // 判断是否真钱
    public boolean isTrueCheck();

    // 判断是否干净
    public boolean isChearCheck();

    // 判断金额>=10
    public boolean amountCheck(int amount);
}
