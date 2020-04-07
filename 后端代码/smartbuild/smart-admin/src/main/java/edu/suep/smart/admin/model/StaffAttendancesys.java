package edu.suep.smart.admin.model;

/**
 * ---------------------------
 * 考勤策略 (StaffAttendancesys)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-28 22:26:09
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class StaffAttendancesys {

	/** ID */
	private Long id;
	/** 考勤周期 */
	private Integer cycle;
	/** 考勤策略名称 */
	private String name;
	/** 考勤周期类型 */
	private Integer attendencecycle;
	/** 考勤班数 */
	private Integer attendenceid;
	/** 第一班上班时间 */
	private java.util.Date worktime0;
	/** 第一班下班时间 */
	private java.util.Date afterworktime0;
	/** 第二班上班时间 */
	private java.util.Date worktime1;
	/** 第二班下班时间 */
	private java.util.Date afterworktime1;
	/** 第三班上班时间 */
	private java.util.Date worktime2;
	/** 第三班下班时间 */
	private java.util.Date afterworktime2;
	/** 组织机构 */
	private Long department;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAttendencecycle() {
		return attendencecycle;
	}

	public void setAttendencecycle(Integer attendencecycle) {
		this.attendencecycle = attendencecycle;
	}

	public Integer getAttendenceid() {
		return attendenceid;
	}

	public void setAttendenceid(Integer attendenceid) {
		this.attendenceid = attendenceid;
	}

	public java.util.Date getWorktime0() {
		return worktime0;
	}

	public void setWorktime0(java.util.Date worktime0) {
		this.worktime0 = worktime0;
	}

	public java.util.Date getAfterworktime0() {
		return afterworktime0;
	}

	public void setAfterworktime0(java.util.Date afterworktime0) {
		this.afterworktime0 = afterworktime0;
	}

	public java.util.Date getWorktime1() {
		return worktime1;
	}

	public void setWorktime1(java.util.Date worktime1) {
		this.worktime1 = worktime1;
	}

	public java.util.Date getAfterworktime1() {
		return afterworktime1;
	}

	public void setAfterworktime1(java.util.Date afterworktime1) {
		this.afterworktime1 = afterworktime1;
	}

	public java.util.Date getWorktime2() {
		return worktime2;
	}

	public void setWorktime2(java.util.Date worktime2) {
		this.worktime2 = worktime2;
	}

	public java.util.Date getAfterworktime2() {
		return afterworktime2;
	}

	public void setAfterworktime2(java.util.Date afterworktime2) {
		this.afterworktime2 = afterworktime2;
	}

	public Long getDepartment() {
		return department;
	}

	public void setDepartment(Long department) {
		this.department = department;
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