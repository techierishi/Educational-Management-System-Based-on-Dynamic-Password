package cn.edu.hustwb.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ScoreId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class ScoreId implements java.io.Serializable {

	// Fields

	private Integer stuid;
	private Integer couid;

	// Constructors

	/** default constructor */
	public ScoreId() {
	}

	/** full constructor */
	public ScoreId(Integer stuid, Integer couid) {
		this.stuid = stuid;
		this.couid = couid;
	}

	// Property accessors

	@Column(name = "stuid", nullable = false)
	public Integer getStuid() {
		return this.stuid;
	}

	public void setStuid(Integer stuid) {
		this.stuid = stuid;
	}

	@Column(name = "couid", nullable = false)
	public Integer getCouid() {
		return this.couid;
	}

	public void setCouid(Integer couid) {
		this.couid = couid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ScoreId))
			return false;
		ScoreId castOther = (ScoreId) other;

		return ((this.getStuid() == castOther.getStuid()) || (this.getStuid() != null
				&& castOther.getStuid() != null && this.getStuid().equals(
				castOther.getStuid())))
				&& ((this.getCouid() == castOther.getCouid()) || (this
						.getCouid() != null && castOther.getCouid() != null && this
						.getCouid().equals(castOther.getCouid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getStuid() == null ? 0 : this.getStuid().hashCode());
		result = 37 * result
				+ (getCouid() == null ? 0 : this.getCouid().hashCode());
		return result;
	}

}