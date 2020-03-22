package edu.suep.smart.admin.model;

/**
 * ---------------------------
 * 进退场记录表 (StaffInout)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-19 22:33:50
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class StaffInout {

	/** ID */
	private Long id;
	/** 考勤时间 */
	private java.util.Date attendancetime;
	/** 考勤方向 */
	private Integer attendancedirection;
	/** 考勤设备 */
	private Integer device;
	/** 考勤地点 */
	private String site;
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

	public java.util.Date getAttendancetime() {
		return attendancetime;
	}

	public void setAttendancetime(java.util.Date attendancetime) {
		this.attendancetime = attendancetime;
	}

	public Integer getAttendancedirection() {
		return attendancedirection;
	}

	public void setAttendancedirection(Integer attendancedirection) {
		this.attendancedirection = attendancedirection;
	}

	public Integer getDevice() {
		return device;
	}

	public void setDevice(Integer device) {
		this.device = device;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
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