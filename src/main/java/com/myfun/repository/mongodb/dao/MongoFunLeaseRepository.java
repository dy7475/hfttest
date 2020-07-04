package com.myfun.repository.mongodb.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.myfun.repository.mongodb.po.MongoFunLeaseBean;

@NoRepositoryBean
public interface MongoFunLeaseRepository extends MongoRepository<MongoFunLeaseBean, String> {
}
