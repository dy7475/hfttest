package com.myfun.repository.mongodb.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.myfun.repository.mongodb.dao.MongoFunLeaseRepository;
import com.myfun.repository.mongodb.po.MongoFunLeaseBean;
import com.myfun.repository.mongodb.support.repository.BaseMongoRepository;

@Repository
public class MongoFunLeaseRepositoryImpl extends BaseMongoRepository<MongoFunLeaseBean, String> implements MongoFunLeaseRepository {
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

}
