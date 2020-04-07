package edu.suep.smart.admin.model;

/**
 * ---------------------------
 * 协议编码表 (StaffProtocol)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-28 22:26:10
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class StaffProtocol {

	/** ID */
	private Long id;
	/** 人员基础信息表ID */
	private Long staffid;
	/** 协议类型 */
	private String type;
	/** 协议名称 */
	private String name;
	/** 签订方式 */
	private String signtype;
	/** 甲方 */
	private String firstparty;
	/** 附件 */
	private String paccessory;
	/** 协议编码 */
	private Integer code;
	/** 签订日期 */
	private java.util.Date signdate;
	/** 协议期限 */
	private String deadline;
	/** 开始时间 */
	private java.util.Date pstartdate;
	/** 结束时间 */
	private java.util.Date penddate;
	/** 终止日期 */
	private java.util.Date terminaldate;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSigntype() {
		return signtype;
	}

	public void setSigntype(String signtype) {
		this.signtype = signtype;
	}

	public String getFirstparty() {
		return firstparty;
	}

	public void setFirstparty(String firstparty) {
		this.firstparty = firstparty;
	}

	public String getPaccessory() {
		return paccessory;
	}

	public void setPaccessory(String paccessory) {
		this.paccessory = paccessory;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public java.util.Date getSigndate() {
		return signdate;
	}

	public void setSigndate(java.util.Date signdate) {
		this.signdate = signdate;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public java.util.Date getPstartdate() {
		return pstartdate;
	}

	public void setPstartdate(java.util.Date pstartdate) {
		this.pstartdate = pstartdate;
	}

	public java.util.Date getPenddate() {
		return penddate;
	}

	public void setPenddate(java.util.Date penddate) {
		this.penddate = penddate;
	}

	public java.util.Date getTerminaldate() {
		return terminaldate;
	}

	public void setTerminaldate(java.util.Date terminaldate) {
		this.terminaldate = terminaldate;
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