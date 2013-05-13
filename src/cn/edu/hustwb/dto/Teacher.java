package cn.edu.hustwb.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "teacher", catalog = "school")
public class Teacher implements java.io.Serializable {

	// Fields

	private Integer teaid;
	private String teaname;
	private String sex;
	private Date birdata;
	private String department;
	private Set<Course> courses = new HashSet<Course>(0);

	// Constructors

	/** default constructor */
	public Teacher() {
	}

	/** full constructor */
	public Teacher(String teaname, String sex, Date birdata, String department,
			Set<Course> courses) {
		this.teaname = teaname;
		this.sex = sex;
		this.birdata = birdata;
		this.department = department;
		this.courses = courses;
	}

	// Property accessors
	@Id
	@Column(name = "teaid", unique = true, nullable = false)
	public Integer getTeaid() {
		return this.teaid;
	}

	public void setTeaid(Integer teaid) {
		this.teaid = teaid;
	}

	@Column(name = "teaname", length = 256)
	public String getTeaname() {
		return this.teaname;
	}

	public void setTeaname(String teaname) {
		this.teaname = teaname;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "teacher")
	public Set<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

}