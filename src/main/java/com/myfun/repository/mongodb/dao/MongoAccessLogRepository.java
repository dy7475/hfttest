package com.myfun.repository.mongodb.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.myfun.repository.mongodb.param.AccessLogParam;
import com.myfun.repository.mongodb.po.MongoAccessLogBean;

@NoRepositoryBean
public interface MongoAccessLogRepository extends MongoRepository<MongoAccessLogBean, String> {

	List<MongoAccessLogBean> getAccessLogList(AccessLogParam param);
}
