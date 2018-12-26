package com.sproutlemon.admin.entity.edu;

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
 * 班级
 * 
 * @author penn
 *
 */
@Entity
@Table(name = "edu_class")
public class EduClass {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "class_code", length = 32, nullable = false, unique = true)
	private String classCode; // 班级编码，全局唯一

	@Column(name = "org_code", length = 32, nullable = false)
	private String orgCode; // 班级所属机构

	@Column(name = "class_name", length = 10, nullable = false)
	private String className; // 班级名称

	@Column(name = "classAdviser_name", length = 10, nullable = false)
	private String classAdviserName; // 班主任姓名

	@Column(name = "classAdviser_mobile", length = 11, nullable = false)
	private String classAdviserMobile; // 班主任电话

	@Column(name = "establishment_number")
	private int establishmentNumber; // 班级编制人数

	@Column(name = "current_number")
	private int currentNumber; // 班级当前人数

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", nullable = false, updatable = false)
	private Date createTime; // 机构创建时间

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

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassAdviserName() {
		return classAdviserName;
	}

	public void setClassAdviserName(String classAdviserName) {
		this.classAdviserName = classAdviserName;
	}

	public String getClassAdviserMobile() {
		return classAdviserMobile;
	}

	public void setClassAdviserMobile(String classAdviserMobile) {
		this.classAdviserMobile = classAdviserMobile;
	}

	public int getEstablishmentNumber() {
		return establishmentNumber;
	}

	public void setEstablishmentNumber(int establishmentNumber) {
		this.establishmentNumber = establishmentNumber;
	}

	public int getCurrentNumber() {
		return currentNumber;
	}

	public void setCurrentNumber(int currentNumber) {
		this.currentNumber = currentNumber;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
