package day06_0810.study;

/**
 * 封装：1私有化属性 2.提供公开的get、set方法
 * 
 * @author Administrator
 *
 */
public class Member {
    // 属性私有化，别的类访问不到
    private String name;
    private String pwd;
    private String sex;

    // 有参构造函数
    // 如果有了有参构造函数，会覆盖无参构造函数
    // 则需要显式写无参构造器
//    public Member(String name, String pwd, String sex) {
//        this.name = name;
//        this.pwd = pwd;
//        this.sex = sex;
//    }

    public void setName(String aString) {
        if (aString.length() == 11) {

            name = aString;
        }
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}
