package com.sproutlemon.admin.enums;

/**
 * 登录错误的类型
 * 
 * @author penn
 *
 */
public enum LoginFailureType {

	NONE, // 没有错误
	ACCOUNT_DOES_NOT_EXIST, // 账号不存在
	WRONG_PASSWORD, // 密码错误
	TRY_TOO_MANY_TIMES, // 账号尝试登录次数太多
	OTHER, // 其他

}
