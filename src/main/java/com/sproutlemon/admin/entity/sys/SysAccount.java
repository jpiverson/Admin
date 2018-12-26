package com.sproutlemon.admin.entity.sys;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sproutlemon.admin.enums.UserAccoutType;

/**
 * 用户账号
 * 
 * @author penn
 *
 */
@Entity
@Table(name = "sys_account")
public class SysAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "account", length = 20, nullable = false, unique = true)
	private String account; // 登录账号，手机号

	@Column(name = "name", length = 10, nullable = false)
	private String name; // 姓名

	@Column(name = "avatar", length = 100, nullable = false)
	private String avatar; // 头像

	@Column(name = "password", length = 32, nullable = false)
	private String password; // 登录密码

	@Enumerated(EnumType.STRING)
	@Column(name = "account_type", length = 20, nullable = false)
	private UserAccoutType accountType; // 账号类型

	@Column(name = "resetPass", nullable = false)
	private int resetPass; // 是否需要重置密码，1需要，0不需要

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", nullable = false, updatable = false)
	private Date createTime; // 账号创建时间

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_time")
	private Date updateTime; // 资料更新时间

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_login_time")
	private Date lastLoginTime; // 上次登录时间

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserAccoutType getAccountType() {
		return accountType;
	}

	public void setAccountType(UserAccoutType accountType) {
		this.accountType = accountType;
	}

	public int getResetPass() {
		return resetPass;
	}

	public void setResetPass(int resetPass) {
		this.resetPass = resetPass;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

}
