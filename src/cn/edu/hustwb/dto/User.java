package cn.edu.hustwb.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "school")
public class User implements java.io.Serializable {

	// Fields

	private Integer userid;
	private String account;
	private String password;
	private Integer type;
	private Integer status;
	private Integer permissions;
	private String ekey;

	// Constructors

	/** default constructor */
	public User() {
	}


	@Id
	@GeneratedValue
	@Column(name = "userid", unique = true, nullable = false)
	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@Column(name = "account", length = 256)
	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Column(name = "password", length = 256)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "type")
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "permissions")
	public Integer getPermissions() {
		return this.permissions;
	}

	public void setPermissions(Integer permissions) {
		this.permissions = permissions;
	}

	@Column(name = "ekey", length = 256)
	public String getEkey() {
		return ekey;
	}


	public void setEkey(String ekey) {
		this.ekey = ekey;
	}

}