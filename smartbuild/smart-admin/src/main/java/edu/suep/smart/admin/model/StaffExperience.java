package edu.suep.smart.admin.model;

/**
 * ---------------------------
 * 变动经历表 (StaffExperience)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-18 11:51:23
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class StaffExperience {

	/** ID */
	private Long id;
	/** 项目名称 */
	private String name;
	/** 项目岗位 */
	private String post;
	/** 项目类别 */
	private String type;
	/** 项目描述 */
	private String describe;
	/** 证明人 */
	private String witness;
	/** 开始时间 */
	private java.util.Date pstartdate;
	/** 结束时间 */
	private java.util.Date penddate;
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

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getWitness() {
		return witness;
	}

	public void setWitness(String witness) {
		this.witness = witness;
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