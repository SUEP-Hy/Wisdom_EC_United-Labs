package edu.suep.smart.admin.model;

/**
 * ---------------------------
 * 生物特征表 (StaffBiofeature)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-28 22:26:09
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class StaffBiofeature {

	/** ID */
	private Long id;
	/** 人员基础信息表ID */
	private Long staffid;
	/** 生物信息特征状态 */
	private String status;
	/** 人脸信息 */
	private Boolean faceinfo;
	/** 指纹信息 */
	private Boolean fingerprintinfo;
	/** 生物类型 */
	private Long type;
	/** 姓名 */
	private String name;
	/** 编码 */
	private String code;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getFaceinfo() {
		return faceinfo;
	}

	public void setFaceinfo(Boolean faceinfo) {
		this.faceinfo = faceinfo;
	}

	public Boolean getFingerprintinfo() {
		return fingerprintinfo;
	}

	public void setFingerprintinfo(Boolean fingerprintinfo) {
		this.fingerprintinfo = fingerprintinfo;
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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