package cn.edu.hustwb.dto;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "course", catalog = "school")
public class Course implements java.io.Serializable {

	// Fields

	private Integer couid;
	private Teacher teacher;
	private String couname;
	private Set<Score> scores = new HashSet<Score>(0);

	// Constructors

	/** default constructor */
	public Course() {
	}

	/** full constructor */
	public Course(Teacher teacher, String couname, Set<Score> scores) {
		this.teacher = teacher;
		this.couname = couname;
		this.scores = scores;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "couid", unique = true, nullable = false)
	public Integer getCouid() {
		return this.couid;
	}

	public void setCouid(Integer couid) {
		this.couid = couid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "teaid")
	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Column(name = "couname", length = 256)
	public String getCouname() {
		return this.couname;
	}

	public void setCouname(String couname) {
		this.couname = couname;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "course")
	public Set<Score> getScores() {
		return this.scores;
	}

	public void setScores(Set<Score> scores) {
		this.scores = scores;
	}

}