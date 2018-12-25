package com.sproutlemon.admin.entity.log;

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

import com.sproutlemon.admin.enums.LoginFailureType;

/**
 * 登录日志
 * 
 * @author penn
 *
 */
@Entity
@Table(name = "log_login")
public class LogLogin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "account", length = 50, nullable = false)
	private String account; // 登录账号

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "login_time", nullable = false, updatable = false)
	private Date loginTime; // 登录时间

	@Column(name = "ip_addr", length = 15, nullable = false)
	private String ipAddr; // 登录IP地址

	@Column(name = "city_id")
	private int cityId; // 城市编码

	@Column(name = "is_success", nullable = false)
	private int isSuccess; // 是否登录成功，1成功，0失败

	@Enumerated(EnumType.STRING)
	@Column(name = "failure_type", length = 50, nullable = false)
	private LoginFailureType failureType; // 登录失败的错误类型

	public LogLogin(String account, Date loginTime, String ipAddr, int cityId, int isSuccess,
			LoginFailureType failureType) {
		super();
		this.account = account;
		this.loginTime = loginTime;
		this.ipAddr = ipAddr;
		this.cityId = cityId;
		this.isSuccess = isSuccess;
		this.failureType = failureType;
	}

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

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(int isSuccess) {
		this.isSuccess = isSuccess;
	}

	public LoginFailureType getFailureType() {
		return failureType;
	}

	public void setFailureType(LoginFailureType failureType) {
		this.failureType = failureType;
	}

}
