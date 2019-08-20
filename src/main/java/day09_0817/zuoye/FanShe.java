package day09_0817.zuoye;

public class FanShe {
    private String a;
    private String b;
    private String c;
    public String p;

    public int add(Integer a, Integer b) {
        return a + b;
    }
    public static  void addc() {
        System.out.println("sssssss");
    }

    @Override
    public String toString() {
        return "FanShe [a=" + a + ", b=" + b + ", c=" + c + ", p=" + p + "]";
    }
    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }
    public FanShe(String a, String b) {
        super();
        this.a = a;
        this.b = b;
    }
    public FanShe() {
        super();
        // TODO Auto-generated constructor stub
    }

}
