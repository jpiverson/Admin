package com.sproutlemon.admin.entity.edu;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 学校
 * 
 * @author penn
 *
 */
@Entity
@Table(name = "edu_organization")
public class EduOrganization implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1840043354354447405L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "org_code", length = 32, nullable = false, unique = true)
	private String orgCode; // 教育机构编码，全局唯一

	@Column(name = "org_name", length = 20, nullable = false)
	private String orgName; // 教育机构名称

	@Column(name = "headmaster_name", length = 10, nullable = false)
	private String headmasterName; // 校长姓名

	@Column(name = "headmaster_mobile", length = 11, nullable = false)
	private String headmasterMobile; // 校长电话

	@Column(name = "org_tel", length = 15)
	private String orgTel; // 教育机构电话

	@Column(name = "org_addr", length = 100)
	private String orgAddr; // 教育机构地址

	@Column(name = "org_city_id")
	private int orgCityId; // 教育机构城市编码

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", nullable = false, updatable = false)
	private Date createTime; // 机构创建时间

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "service_time", nullable = false)
	private Date serviceTime; // 服务截止时间

	@Column(name = "status", nullable = false)
	private int status; // 机构状态: 0正常，大于0异常

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgTel() {
		return orgTel;
	}

	public void setOrgTel(String orgTel) {
		this.orgTel = orgTel;
	}

	public String getOrgAddr() {
		return orgAddr;
	}

	public void setOrgAddr(String orgAddr) {
		this.orgAddr = orgAddr;
	}

	public int getOrgCityId() {
		return orgCityId;
	}

	public void setOrgCityId(int orgCityId) {
		this.orgCityId = orgCityId;
	}

	public String getHeadmasterName() {
		return headmasterName;
	}

	public void setHeadmasterName(String headmasterName) {
		this.headmasterName = headmasterName;
	}

	public String getHeadmasterMobile() {
		return headmasterMobile;
	}

	public void setHeadmasterMobile(String headmasterMobile) {
		this.headmasterMobile = headmasterMobile;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(Date serviceTime) {
		this.serviceTime = serviceTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
