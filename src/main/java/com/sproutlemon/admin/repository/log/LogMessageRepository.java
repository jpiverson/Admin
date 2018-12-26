package com.sproutlemon.admin.repository.log;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sproutlemon.admin.entity.log.LogMessage;

public interface LogMessageRepository extends PagingAndSortingRepository<LogMessage, Long> {

}
