package com.sproutlemon.admin.exception;

public class ServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3054476254512061619L;

	private String errCode; // 错误码
	private String errMsg; // 错误消息

	public ServiceException() {
		super();
	}

	public ServiceException(ServiceExceptionEnum ServiceExceptionEnum) {
		super(ServiceExceptionEnum.getErrMsg());
		this.errCode = ServiceExceptionEnum.getErrCode();
	}

	public ServiceException(ServiceExceptionEnum ServiceExceptionEnum, Throwable throwable) {
		super(ServiceExceptionEnum.getErrMsg(), throwable);
		this.errCode = ServiceExceptionEnum.getErrCode();
		this.errMsg = ServiceExceptionEnum.getErrMsg();
	}

	public String getErrCode() {
		return errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public static void main(String[] args) {
		try {
			System.out.println(1 / 0);
		} catch (Exception e) {
			throw new ServiceException(ServiceExceptionEnum.SYSTEM_ERROR);
		}
	}

}
