package cn.edu.hustwb.dto;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Score entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "score", catalog = "school")
public class Score implements java.io.Serializable {

	// Fields

	private ScoreId id;
	private Student student;
	private Course course;
	private Integer usuallyscore;
	private Integer paperscore;
	private Integer sumscore;

	// Constructors

	/** default constructor */
	public Score() {
	}

	/** minimal constructor */
	public Score(ScoreId id, Student student, Course course) {
		this.id = id;
		this.student = student;
		this.course = course;
	}

	/** full constructor */
	public Score(ScoreId id, Student student, Course course,
			Integer usuallyscore, Integer paperscore, Integer sumscore) {
		this.id = id;
		this.student = student;
		this.course = course;
		this.usuallyscore = usuallyscore;
		this.paperscore = paperscore;
		this.sumscore = sumscore;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "stuid", column = @Column(name = "stuid", nullable = false)),
			@AttributeOverride(name = "couid", column = @Column(name = "couid", nullable = false)) })
	public ScoreId getId() {
		return this.id;
	}

	public void setId(ScoreId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "stuid", nullable = false, insertable = false, updatable = false)
	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "couid", nullable = false, insertable = false, updatable = false)
	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Column(name = "usuallyscore")
	public Integer getUsuallyscore() {
		return this.usuallyscore;
	}

	public void setUsuallyscore(Integer usuallyscore) {
		this.usuallyscore = usuallyscore;
	}

	@Column(name = "paperscore")
	public Integer getPaperscore() {
		return this.paperscore;
	}

	public void setPaperscore(Integer paperscore) {
		this.paperscore = paperscore;
	}

	@Column(name = "sumscore")
	public Integer getSumscore() {
		return this.sumscore;
	}

	public void setSumscore(Integer sumscore) {
		this.sumscore = sumscore;
	}

}