package cn.edu.hustwb.dto;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "student", catalog = "school")
public class Student implements java.io.Serializable {

	// Fields

	private Integer stuid;
	private String stuname;
	private String sex;
	private Date birdata;
	private String department;
	private String major;
	private String stuclass;
	private String national;
	private Date adtime;

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** full constructor */
	public Student(String stuname, String sex, Date birdata, String department,
			String major, String stuclass, String national, Date adtime) {
		this.stuname = stuname;
		this.sex = sex;
		this.birdata = birdata;
		this.department = department;
		this.major = major;
		this.stuclass = stuclass;
		this.national = national;
		this.adtime = adtime;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "stuid", unique = true, nullable = false)
	public Integer getStuid() {
		return this.stuid;
	}

	public void setStuid(Integer stuid) {
		this.stuid = stuid;
	}

	@Column(name = "stuname", length = 256)
	public String getStuname() {
		return this.stuname;
	}

	public void setStuname(String stuname) {
		this.stuname = stuname;
	}

	@Column(name = "sex", length = 4)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birdata", length = 10)
	public Date getBirdata() {
		return this.birdata;
	}

	public void setBirdata(Date birdata) {
		this.birdata = birdata;
	}

	@Column(name = "department", length = 256)
	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Column(name = "major", length = 256)
	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Column(name = "stuclass", length = 256)
	public String getStuclass() {
		return this.stuclass;
	}

	public void setStuclass(String stuclass) {
		this.stuclass = stuclass;
	}

	@Column(name = "national", length = 256)
	public String getNational() {
		return this.national;
	}

	public void setNational(String national) {
		this.national = national;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "adtime", length = 10)
	public Date getAdtime() {
		return this.adtime;
	}

	public void setAdtime(Date adtime) {
		this.adtime = adtime;
	}

}