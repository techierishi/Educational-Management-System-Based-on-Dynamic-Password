package cn.edu.hustwb.vo;

import java.util.Date;

public class TeacherVO {
	private int teaid;
	private String teaname;
	private String sex;
	private String department;
	private Date birdata;
	public int getTeaid() {
		return teaid;
	}
	public void setTeaid(int teaid) {
		this.teaid = teaid;
	}
	public String getTeaname() {
		return teaname;
	}
	public void setTeaname(String teaname) {
		this.teaname = teaname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Date getBirdata() {
		return birdata;
	}
	public void setBirdata(Date birdata) {
		this.birdata = birdata;
	}


}
