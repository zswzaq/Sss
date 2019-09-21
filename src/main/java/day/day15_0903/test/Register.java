package day.day15_0903.test;

public class Register {
    private String mobilephone;
    private String pwd;
    private String regname;
    public String getMobilephone() {
        return mobilephone;
    }
    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }
    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public String getRegname() {
        return regname;
    }
    public void setRegname(String regname) {
        this.regname = regname;
    }
    @Override
    public String toString() {
        return "Register [mobilephone=" + mobilephone + ", pwd=" + pwd + ", regname=" + regname + "]";
    }
    

}
