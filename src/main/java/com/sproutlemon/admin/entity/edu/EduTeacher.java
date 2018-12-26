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
 * 老师
 * 
 * @author penn
 *
 */
@Entity
@Table(name = "edu_teacher")
public class EduTeacher implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4335267717508504404L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "teacher_code", length = 32, nullable = false, unique = true)
	private String teacherCode; // 教师编码，全局唯一

	@Column(name = "org_code", length = 32, nullable = false)
	private String orgCode; // 教师所属机构

	@Column(name = "teacher_name", length = 10, nullable = false)
	private String teacherName; // 教师姓名

	@Column(name = "teacher_mobile", length = 11, nullable = false, unique = true)
	private String teacherMobile; // 教师电话

	@Column(name = "profile", length = 11, nullable = false)
	private String profile; // 教师介绍

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

	public String getTeacherCode() {
		return teacherCode;
	}

	public void setTeacherCode(String teacherCode) {
		this.teacherCode = teacherCode;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherMobile() {
		return teacherMobile;
	}

	public void setTeacherMobile(String teacherMobile) {
		this.teacherMobile = teacherMobile;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
