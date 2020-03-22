package edu.suep.smart.admin.model;

/**
 * ---------------------------
 * 考勤制度管理表 (StaffAttendancesys)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-19 22:33:50
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class StaffAttendancesys {

	/** ID */
	private Long id;
	/** 考勤周期 */
	private Integer cycle;
	/** 考勤班组 */
	private String team;
	/** 上班时间 */
	private java.util.Date worktime;
	/** 下班时间 */
	private java.util.Date offtime;
	/** 创建人 */
	private String createBy;
	/** 创建时间 */
	private java.util.Date createTime;
	/** 更新人 */
	private String lastUpdateBy;
	/** 更新时间 */
	private java.util.Date lastUpdateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCycle() {
		return cycle;
	}

	public void setCycle(Integer cycle) {
		this.cycle = cycle;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public java.util.Date getWorktime() {
		return worktime;
	}

	public void setWorktime(java.util.Date worktime) {
		this.worktime = worktime;
	}

	public java.util.Date getOfftime() {
		return offtime;
	}

	public void setOfftime(java.util.Date offtime) {
		this.offtime = offtime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public String getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public java.util.Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(java.util.Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

}