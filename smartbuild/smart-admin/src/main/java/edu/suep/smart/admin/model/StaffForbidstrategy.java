package edu.suep.smart.admin.model;

/**
 * ---------------------------
 * 考勤制策略表 (StaffForbidstrategy)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-19 22:33:50
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class StaffForbidstrategy {

	/** ID */
	private Long id;
	/** 禁入人员 */
	private String personcode;
	/** 门禁设备 */
	private String devicecode;
	/** 禁入开始时间 */
	private java.util.Date forbidstart;
	/** 禁入结束时间 */
	private java.util.Date forbidend;
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

	public String getPersoncode() {
		return personcode;
	}

	public void setPersoncode(String personcode) {
		this.personcode = personcode;
	}

	public String getDevicecode() {
		return devicecode;
	}

	public void setDevicecode(String devicecode) {
		this.devicecode = devicecode;
	}

	public java.util.Date getForbidstart() {
		return forbidstart;
	}

	public void setForbidstart(java.util.Date forbidstart) {
		this.forbidstart = forbidstart;
	}

	public java.util.Date getForbidend() {
		return forbidend;
	}

	public void setForbidend(java.util.Date forbidend) {
		this.forbidend = forbidend;
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