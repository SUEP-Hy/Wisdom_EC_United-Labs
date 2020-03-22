package edu.suep.smart.admin.model;

/**
 * ---------------------------
 * 体检信息表 (StaffPhysical)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-18 11:51:23
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class StaffPhysical {

	/** ID */
	private Long id;
	/** 色盲 */
	private String achromate;
	/** 血型 */
	private String bloodtype;
	/** 体检医院 */
	private String hospital;
	/** 体检项目 */
	private String item;
	/** 体检结论 */
	private String conclusion;
	/** 身高 */
	private Double height;
	/** 体重 */
	private Double weight;
	/** 左眼视力 */
	private Double eyesightl;
	/** 右眼视力 */
	private Double eyesightr;
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

	public String getAchromate() {
		return achromate;
	}

	public void setAchromate(String achromate) {
		this.achromate = achromate;
	}

	public String getBloodtype() {
		return bloodtype;
	}

	public void setBloodtype(String bloodtype) {
		this.bloodtype = bloodtype;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getConclusion() {
		return conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getEyesightl() {
		return eyesightl;
	}

	public void setEyesightl(Double eyesightl) {
		this.eyesightl = eyesightl;
	}

	public Double getEyesightr() {
		return eyesightr;
	}

	public void setEyesightr(Double eyesightr) {
		this.eyesightr = eyesightr;
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