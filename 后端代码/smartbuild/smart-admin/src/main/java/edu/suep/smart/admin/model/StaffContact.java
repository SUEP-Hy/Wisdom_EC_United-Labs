package edu.suep.smart.admin.model;

/**
 * ---------------------------
 * 联系信息表 (StaffContact)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-28 22:26:09
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class StaffContact {

	/** ID */
	private Long id;
	/** 人员基础信息表ID */
	private Long staffid;
	/** 联系手机 */
	private String cellphone;
	/** 电子邮箱 */
	private String email;
	/** 微信号 */
	private String wechatnum;
	/** 办公电话 */
	private String officephone;
	/** 企业短号 */
	private String enterprisecornet;
	/** 籍贯 */
	private String nativeplace;
	/** 现居住地 */
	private String currentaddr;
	/** 邮编 */
	private String zipcode;
	/** 紧急联系人 */
	private String urgentcontact;
	/** 与本人关系 */
	private String relationship;
	/** 联系人电话 */
	private String contactphone;
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

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWechatnum() {
		return wechatnum;
	}

	public void setWechatnum(String wechatnum) {
		this.wechatnum = wechatnum;
	}

	public String getOfficephone() {
		return officephone;
	}

	public void setOfficephone(String officephone) {
		this.officephone = officephone;
	}

	public String getEnterprisecornet() {
		return enterprisecornet;
	}

	public void setEnterprisecornet(String enterprisecornet) {
		this.enterprisecornet = enterprisecornet;
	}

	public String getNativeplace() {
		return nativeplace;
	}

	public void setNativeplace(String nativeplace) {
		this.nativeplace = nativeplace;
	}

	public String getCurrentaddr() {
		return currentaddr;
	}

	public void setCurrentaddr(String currentaddr) {
		this.currentaddr = currentaddr;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getUrgentcontact() {
		return urgentcontact;
	}

	public void setUrgentcontact(String urgentcontact) {
		this.urgentcontact = urgentcontact;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getContactphone() {
		return contactphone;
	}

	public void setContactphone(String contactphone) {
		this.contactphone = contactphone;
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