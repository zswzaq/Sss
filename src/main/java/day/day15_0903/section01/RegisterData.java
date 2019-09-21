package day.day15_0903.section01;

public class RegisterData {

	private String phone;
	private String pwd;
	private String regname;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
		return "RegisterData [phone=" + phone + ", pwd=" + pwd + ", regname=" + regname + "]";
	}

}
