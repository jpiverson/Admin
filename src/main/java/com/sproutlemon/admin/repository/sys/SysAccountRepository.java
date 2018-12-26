package com.sproutlemon.admin.repository.sys;

import org.springframework.data.repository.Repository;

import com.sproutlemon.admin.entity.sys.SysAccount;

public interface SysAccountRepository extends Repository<SysAccount, Long> {

	SysAccount findByAccount(String account);

}
