package com.sproutlemon.admin.exception;

/**
 * Service层面应该抛出该异常
 * 
 * @author penn
 *
 */
public enum ServiceExceptionEnum {

	UNKNOWN_EXCEPTION("OE001", "未知异常", "warn"), // 未知异常
	SYSTEM_ERROR("OE002", "系统错误", "error"), // 系统错误
	NO_LOGIN("OE003", "尚未登录", "warn");// 没有登录

	private String errCode;
	private String errMsg;
	private String errType;

	ServiceExceptionEnum(String errCode, String errMsg, String errType) {
		this.errCode = errCode;
		this.errMsg = errMsg;
		this.errType = errType;
	}

	/**
	 * Getter method for property <tt>errCode</tt>.
	 *
	 * @return property value of errCode
	 */
	public String getErrCode() {
		return errCode;
	}

	/**
	 * Setter method for property <tt>errCode</tt>.
	 *
	 * @param errCode value to be assigned to property errCode
	 */
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	/**
	 * Getter method for property <tt>errMsg</tt>.
	 *
	 * @return property value of errMsg
	 */
	public String getErrMsg() {
		return errMsg;
	}

	/**
	 * Setter method for property <tt>errMsg</tt>.
	 *
	 * @param errMsg value to be assigned to property errMsg
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	/**
	 * Getter method for property <tt>errType</tt>.
	 *
	 * @return property value of errType
	 */
	public String getErrType() {
		return errType;
	}

	/**
	 * Setter method for property <tt>errType</tt>.
	 *
	 * @param errType value to be assigned to property errType
	 */
	public void setErrType(String errType) {
		this.errType = errType;
	}

}
