package com.sproutlemon.admin.repository.sys;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.sproutlemon.admin.entity.sys.SysRegion;

public interface SysRegionRepository extends Repository<SysRegion, Integer> {

	List<SysRegion> findByParentId(int parentId);
}
