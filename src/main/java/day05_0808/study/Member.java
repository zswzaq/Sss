package day05_0808.study;

public class Member {
    String name;
    String pwd;
    String sex;
    // 有参构造函数
    // 如果有了有参构造函数，会覆盖无参构造函数
    // 则需要显式写无参构造器
    public Member(String name, String pwd, String sex) {
        this.name = name;
        this.pwd = pwd;
        this.sex = sex;
    }
    
}
