package com.sproutlemon.admin.entity.org;

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
 * 教育机构
 * 
 * @author penn
 *
 */
@Entity
@Table(name = "education_org")
public class EducationOrg {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", length = 50, nullable = false, unique = true)
	private String name; // 教育机构的名称

	@Column(name = "addr", length = 50, nullable = false)
	private String addr; // 地址

	@Column(name = "headmaster_name", length = 10, nullable = false)
	private String headmasterName; // 校长姓名

	@Column(name = "headmaster_mobile", length = 11, nullable = false)
	private String headmasterMobile; // 校长电话

	@Column(name = "org_tel", length = 11, nullable = false)
	private String orgTel; // 机构电话

	@Column(name = "city_id")
	private int cityId; // 城市编码

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", nullable = false, updatable = false)
	private Date createTime; // 账号创建时间

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "service_time", nullable = false, updatable = false)
	private Date serviceTime; // 服务截止时间

	@Column(name = "status")
	private int status; // 机构状态 0正常，异常大于0

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

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
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

	public String getOrgTel() {
		return orgTel;
	}

	public void setOrgTel(String orgTel) {
		this.orgTel = orgTel;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
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
