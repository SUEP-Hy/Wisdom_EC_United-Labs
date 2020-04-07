package edu.suep.smart.admin.model;

/**
 * ---------------------------
 * 户口信息表 (StaffResident)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-28 22:26:10
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class StaffResident {

	/** ID */
	private Long id;
	/** 人员基础信息表ID */
	private Long staffid;
	/** 姓名 */
	private String name;
	/** 配偶姓名 */
	private String matename;
	/** 配偶户型 */
	private String matehousetype;
	/** 子女姓名 */
	private String childrenname;
	/** 家庭住址 */
	private String permanentresidence;
	/** 迁入地 */
	private String immigrationaddr;
	/** 迁出地 */
	private String emigrationtaddr;
	/** 现居住地 */
	private String currentaddr;
	/** 迁入时间 */
	private java.util.Date immigrationtime;
	/** 迁出时间 */
	private java.util.Date emigrationtime;
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

	public Long getStaffid() {
		return staffid;
	}

	public void setStaffid(Long staffid) {
		this.staffid = staffid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMatename() {
		return matename;
	}

	public void setMatename(String matename) {
		this.matename = matename;
	}

	public String getMatehousetype() {
		return matehousetype;
	}

	public void setMatehousetype(String matehousetype) {
		this.matehousetype = matehousetype;
	}

	public String getChildrenname() {
		return childrenname;
	}

	public void setChildrenname(String childrenname) {
		this.childrenname = childrenname;
	}

	public String getPermanentresidence() {
		return permanentresidence;
	}

	public void setPermanentresidence(String permanentresidence) {
		this.permanentresidence = permanentresidence;
	}

	public String getImmigrationaddr() {
		return immigrationaddr;
	}

	public void setImmigrationaddr(String immigrationaddr) {
		this.immigrationaddr = immigrationaddr;
	}

	public String getEmigrationtaddr() {
		return emigrationtaddr;
	}

	public void setEmigrationtaddr(String emigrationtaddr) {
		this.emigrationtaddr = emigrationtaddr;
	}

	public String getCurrentaddr() {
		return currentaddr;
	}

	public void setCurrentaddr(String currentaddr) {
		this.currentaddr = currentaddr;
	}

	public java.util.Date getImmigrationtime() {
		return immigrationtime;
	}

	public void setImmigrationtime(java.util.Date immigrationtime) {
		this.immigrationtime = immigrationtime;
	}

	public java.util.Date getEmigrationtime() {
		return emigrationtime;
	}

	public void setEmigrationtime(java.util.Date emigrationtime) {
		this.emigrationtime = emigrationtime;
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