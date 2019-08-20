package day09_0817.test;

public class User {

    private String id;
    private String name;
    private String age;
    private String sex;
    private String c;

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", c=" + c + "]";
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public User() {
    }

    public User(String id, String name, String age, String sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}
