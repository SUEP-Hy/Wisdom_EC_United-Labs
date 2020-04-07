package edu.suep.smart.admin.model;

/**
 * ---------------------------
 * 禁入审批表 (StaffForbidapproval)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-28 22:26:09
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class StaffForbidapproval {

	/** ID */
	private Long id;
	/** 制订人 */
	private String makercode;
	/** 审核人 */
	private String verifiercode;
	/** 审核结果 */
	private String audit;
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

	public String getMakercode() {
		return makercode;
	}

	public void setMakercode(String makercode) {
		this.makercode = makercode;
	}

	public String getVerifiercode() {
		return verifiercode;
	}

	public void setVerifiercode(String verifiercode) {
		this.verifiercode = verifiercode;
	}

	public String getAudit() {
		return audit;
	}

	public void setAudit(String audit) {
		this.audit = audit;
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