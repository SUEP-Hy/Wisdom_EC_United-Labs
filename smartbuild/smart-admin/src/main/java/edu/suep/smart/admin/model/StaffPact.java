package edu.suep.smart.admin.model;

/**
 * ---------------------------
 * 合同信息表 (StaffPact)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-18 11:51:23
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class StaffPact {

	/** ID */
	private Long id;
	/** 合同编号 */
	private String code;
	/** 签订方式 */
	private String signtype;
	/** 甲方 */
	private String firstparty;
	/** 乙方 */
	private String secondparty;
	/** 试用期限 */
	private String servicelife;
	/** 工作城市 */
	private String workplace;
	/** 工作内容 */
	private String workduties;
	/** 派遣机构 */
	private String dispatchagency;
	/** 签订日期 */
	private java.util.Date signdate;
	/** 试用开始日期 */
	private java.util.Date pstartdate;
	/** 试用结束日期 */
	private java.util.Date penddate;
	/** 转正日期 */
	private java.util.Date regularizationdate;
	/** 合同类型 */
	private String type;
	/** 合同期限类型 */
	private Integer periodtype;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getSecondparty() {
		return secondparty;
	}

	public void setSecondparty(String secondparty) {
		this.secondparty = secondparty;
	}

	public String getServicelife() {
		return servicelife;
	}

	public void setServicelife(String servicelife) {
		this.servicelife = servicelife;
	}

	public String getWorkplace() {
		return workplace;
	}

	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}

	public String getWorkduties() {
		return workduties;
	}

	public void setWorkduties(String workduties) {
		this.workduties = workduties;
	}

	public String getDispatchagency() {
		return dispatchagency;
	}

	public void setDispatchagency(String dispatchagency) {
		this.dispatchagency = dispatchagency;
	}

	public java.util.Date getSigndate() {
		return signdate;
	}

	public void setSigndate(java.util.Date signdate) {
		this.signdate = signdate;
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

	public java.util.Date getRegularizationdate() {
		return regularizationdate;
	}

	public void setRegularizationdate(java.util.Date regularizationdate) {
		this.regularizationdate = regularizationdate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getPeriodtype() {
		return periodtype;
	}

	public void setPeriodtype(Integer periodtype) {
		this.periodtype = periodtype;
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