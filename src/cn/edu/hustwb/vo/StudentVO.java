package cn.edu.hustwb.vo;

import java.util.Date;

public class StudentVO {
	private int stuid;
	private String stuname;
	private String sex;
	private String department;
	private String major;
	private String stuclass;
	private String national;
	private Date birdata;
	public int getStuid() {
		return stuid;
	}
	public void setStuid(int stuid) {
		this.stuid = stuid;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
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
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getStuclass() {
		return stuclass;
	}
	public void setStuclass(String stuclass) {
		this.stuclass = stuclass;
	}
	public String getNational() {
		return national;
	}
	public void setNational(String national) {
		this.national = national;
	}
	public Date getBirdata() {
		return birdata;
	}
	public void setBirdata(Date birdata) {
		this.birdata = birdata;
	}


}
