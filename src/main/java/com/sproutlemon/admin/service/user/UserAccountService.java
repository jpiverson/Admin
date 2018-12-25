package com.sproutlemon.admin.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sproutlemon.admin.entity.user.UserAccount;
import com.sproutlemon.admin.repository.user.UserAccountRepository;

@Service
public class UserAccountService {

	@Autowired
	UserAccountRepository accountRepository;

	/**
	 * 根据账号查询用户
	 * 
	 * @param account
	 * @return
	 */
	public UserAccount findByAccount(String account) {
		return accountRepository.findByAccount(account);
	}

}
