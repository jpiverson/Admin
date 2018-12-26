package com.sproutlemon.admin.service.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sproutlemon.admin.entity.sys.SysAccount;
import com.sproutlemon.admin.repository.sys.SysAccountRepository;

@Service
public class SysAccountService {

	@Autowired
	SysAccountRepository accountRepository;

	/**
	 * 根据账号查询用户
	 * 
	 * @param account
	 * @return
	 */
	public SysAccount findByAccount(String account) {
		return accountRepository.findByAccount(account);
	}

}
