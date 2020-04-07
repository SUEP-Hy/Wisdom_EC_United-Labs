package edu.suep.smart.admin.model;

/**
 * ---------------------------
 * 禁入策略表 (StaffForbidstrategy)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-28 22:26:09
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class StaffForbidstrategy {

	/** ID */
	private Long id;
	/** 策略名称 */
	private String name;
	/** 禁入原因 */
	private String reason;
	/** 策略状态 */
	private Long status;
	/** 执行开始时间 */
	private java.util.Date starttime;
	/** 执行结束时间 */
	private java.util.Date strategyendtime;
	/** 禁入人员编码 */
	private String personcode;
	/** 门禁设备编码 */
	private String devicecode;
	/** 禁入策略开始日期 */
	private java.util.Date forbidstart;
	/** 禁入策略结束日期 */
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public java.util.Date getStarttime() {
		return starttime;
	}

	public void setStarttime(java.util.Date starttime) {
		this.starttime = starttime;
	}

	public java.util.Date getStrategyendtime() {
		return strategyendtime;
	}

	public void setStrategyendtime(java.util.Date strategyendtime) {
		this.strategyendtime = strategyendtime;
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