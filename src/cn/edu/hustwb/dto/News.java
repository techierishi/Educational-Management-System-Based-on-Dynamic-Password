package cn.edu.hustwb.dto;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * News entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "news", catalog = "school")
public class News implements java.io.Serializable {

	// Fields

	private Integer newsid;
	private User user;
	private String newstitle;
	private String newscontent;
	private Date newsdate;

	// Constructors

	/** default constructor */
	public News() {
	}

	/** full constructor */
	public News(User user, String newstitle, String newscontent, Date newsdate) {
		this.user = user;
		this.newstitle = newstitle;
		this.newscontent = newscontent;
		this.newsdate = newsdate;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "newsid", unique = true, nullable = false)
	public Integer getNewsid() {
		return this.newsid;
	}

	public void setNewsid(Integer newsid) {
		this.newsid = newsid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "newstitle", length = 120)
	public String getNewstitle() {
		return this.newstitle;
	}

	public void setNewstitle(String newstitle) {
		this.newstitle = newstitle;
	}

	@Column(name = "newscontent", length = 10000)
	public String getNewscontent() {
		return this.newscontent;
	}

	public void setNewscontent(String newscontent) {
		this.newscontent = newscontent;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "newsdate", length = 10)
	public Date getNewsdate() {
		return this.newsdate;
	}

	public void setNewsdate(Date newsdate) {
		this.newsdate = newsdate;
	}

}