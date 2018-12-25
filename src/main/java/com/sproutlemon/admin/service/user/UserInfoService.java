package com.sproutlemon.admin.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sproutlemon.admin.repository.user.UserInfoRepository;

@Service
public class UserInfoService {

	@Autowired
	UserInfoRepository infoRepository;

}
