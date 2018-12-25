package com.sproutlemon.admin.repository.user;

import org.springframework.data.repository.Repository;

import com.sproutlemon.admin.entity.user.UserAccount;

public interface UserAccountRepository extends Repository<UserAccount, Long> {

	UserAccount findByAccount(String account);

}
