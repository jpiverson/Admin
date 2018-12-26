package com.sproutlemon.admin.enums;

/**
 * 登录账号的类型
 * 
 * @author penn
 *
 */
public enum UserAccoutType {
	HEADMASTER, // 园长
	TEACHER, // 老师, 需要在EduTeacher中关联具体的记录
	OTHER,

}
