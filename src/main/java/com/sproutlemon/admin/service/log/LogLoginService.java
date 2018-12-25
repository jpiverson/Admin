package com.sproutlemon.admin.service.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sproutlemon.admin.entity.log.LogLogin;
import com.sproutlemon.admin.repository.log.LogLoginRepository;

@Service
public class LogLoginService {

	@Autowired
	LogLoginRepository loginRepository;

	public LogLogin save(LogLogin logLogin) {
		return loginRepository.save(logLogin);
	}

}
