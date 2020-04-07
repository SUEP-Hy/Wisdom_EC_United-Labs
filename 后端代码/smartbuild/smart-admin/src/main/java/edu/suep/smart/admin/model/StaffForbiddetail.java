package edu.suep.smart.admin.model;

/**
 * ---------------------------
 * 禁入明细表 (StaffForbiddetail)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-28 22:26:09
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class StaffForbiddetail {

	/** ID */
	private Long id;
	/** 禁入策略id */
	private Long strategyid;
	/** 禁入人员姓名 */
	private String workname;
	/** 禁入下发设备 */
	private Long device;
	/** 禁入开始时间 */
	private java.util.Date begintime;
	/** 禁入结束时间 */
	private java.util.Date stoptime;
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

	public Long getStrategyid() {
		return strategyid;
	}

	public void setStrategyid(Long strategyid) {
		this.strategyid = strategyid;
	}

	public String getWorkname() {
		return workname;
	}

	public void setWorkname(String workname) {
		this.workname = workname;
	}

	public Long getDevice() {
		return device;
	}

	public void setDevice(Long device) {
		this.device = device;
	}

	public java.util.Date getBegintime() {
		return begintime;
	}

	public void setBegintime(java.util.Date begintime) {
		this.begintime = begintime;
	}

	public java.util.Date getStoptime() {
		return stoptime;
	}

	public void setStoptime(java.util.Date stoptime) {
		this.stoptime = stoptime;
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