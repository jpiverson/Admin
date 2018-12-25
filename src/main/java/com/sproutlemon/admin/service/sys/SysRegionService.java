package com.sproutlemon.admin.service.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sproutlemon.admin.entity.sys.SysRegion;
import com.sproutlemon.admin.repository.sys.SysRegionRepository;

@Service
public class SysRegionService {

	@Autowired
	SysRegionRepository regionRepository;

	/**
	 * 查询所有省份
	 * 
	 * @return
	 */
	public List<SysRegion> findAllProvince() {
		return regionRepository.findByParentId(0);
	}

}
