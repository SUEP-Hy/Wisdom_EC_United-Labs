package edu.suep.smart.admin.model;

/**
 * ---------------------------
 * 薪酬福利表 (StaffPayroll)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-03-18 11:51:23
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class StaffPayroll {

	/** ID */
	private Long id;
	/** 医疗保障号 */
	private String medicalsecuritynum;
	/** 社会保障号 */
	private String socialsecuritynum;
	/** 公积金账号 */
	private String accumulationfundaccount;
	/** 社保组织关系 */
	private String socialsecurityorganizationrelationship;
	/** 社保档级 */
	private String socialsecuritylevel;
	/** 发薪方式 */
	private String paymenttype;
	/** 银行账号 */
	private String bankaccount;
	/** 薪资地区 */
	private String salaryregion;
	/** 社保开始缴纳时间 */
	private java.util.Date socialsecuritystartstime;
	/** 公积金开始缴纳时间 */
	private java.util.Date reservebeginstime;
	/** 社保缴纳基数 */
	private Double socialsecuritypaymentbase;
	/** 公积金缴纳基数 */
	private Double reservepaymentbase;
	/** 年金缴纳基数 */
	private Double annuitypaymentbase;
	/** 发薪币种 */
	private Integer paycurrency;
	/** 发薪银行 */
	private Integer paybank;
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

	public String getMedicalsecuritynum() {
		return medicalsecuritynum;
	}

	public void setMedicalsecuritynum(String medicalsecuritynum) {
		this.medicalsecuritynum = medicalsecuritynum;
	}

	public String getSocialsecuritynum() {
		return socialsecuritynum;
	}

	public void setSocialsecuritynum(String socialsecuritynum) {
		this.socialsecuritynum = socialsecuritynum;
	}

	public String getAccumulationfundaccount() {
		return accumulationfundaccount;
	}

	public void setAccumulationfundaccount(String accumulationfundaccount) {
		this.accumulationfundaccount = accumulationfundaccount;
	}

	public String getSocialsecurityorganizationrelationship() {
		return socialsecurityorganizationrelationship;
	}

	public void setSocialsecurityorganizationrelationship(String socialsecurityorganizationrelationship) {
		this.socialsecurityorganizationrelationship = socialsecurityorganizationrelationship;
	}

	public String getSocialsecuritylevel() {
		return socialsecuritylevel;
	}

	public void setSocialsecuritylevel(String socialsecuritylevel) {
		this.socialsecuritylevel = socialsecuritylevel;
	}

	public String getPaymenttype() {
		return paymenttype;
	}

	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}

	public String getBankaccount() {
		return bankaccount;
	}

	public void setBankaccount(String bankaccount) {
		this.bankaccount = bankaccount;
	}

	public String getSalaryregion() {
		return salaryregion;
	}

	public void setSalaryregion(String salaryregion) {
		this.salaryregion = salaryregion;
	}

	public java.util.Date getSocialsecuritystartstime() {
		return socialsecuritystartstime;
	}

	public void setSocialsecuritystartstime(java.util.Date socialsecuritystartstime) {
		this.socialsecuritystartstime = socialsecuritystartstime;
	}

	public java.util.Date getReservebeginstime() {
		return reservebeginstime;
	}

	public void setReservebeginstime(java.util.Date reservebeginstime) {
		this.reservebeginstime = reservebeginstime;
	}

	public Double getSocialsecuritypaymentbase() {
		return socialsecuritypaymentbase;
	}

	public void setSocialsecuritypaymentbase(Double socialsecuritypaymentbase) {
		this.socialsecuritypaymentbase = socialsecuritypaymentbase;
	}

	public Double getReservepaymentbase() {
		return reservepaymentbase;
	}

	public void setReservepaymentbase(Double reservepaymentbase) {
		this.reservepaymentbase = reservepaymentbase;
	}

	public Double getAnnuitypaymentbase() {
		return annuitypaymentbase;
	}

	public void setAnnuitypaymentbase(Double annuitypaymentbase) {
		this.annuitypaymentbase = annuitypaymentbase;
	}

	public Integer getPaycurrency() {
		return paycurrency;
	}

	public void setPaycurrency(Integer paycurrency) {
		this.paycurrency = paycurrency;
	}

	public Integer getPaybank() {
		return paybank;
	}

	public void setPaybank(Integer paybank) {
		this.paybank = paybank;
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