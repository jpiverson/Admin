package com.sproutlemon.admin.entity.log;

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
 * 短信日志
 * 
 * @author penn
 *
 */
@Entity
@Table(name = "log_message")
public class LogMessage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "mobile", length = 50, nullable = false)
	private String mobile; // 手机号

	@Column(name = "contents", length = 100, nullable = false)
	private String contents; // 内容

	@Column(name = "code", length = 6, nullable = false)
	private String code; // 验证码

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "send_time", nullable = false, updatable = false)
	private Date sendTime; // 发送时间

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

}
