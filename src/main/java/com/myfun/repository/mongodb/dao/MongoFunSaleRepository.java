package com.myfun.repository.mongodb.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.myfun.repository.mongodb.param.EsfListParam;
import com.myfun.repository.mongodb.po.MongoFunSaleBean;

@NoRepositoryBean
public interface MongoFunSaleRepository extends MongoRepository<MongoFunSaleBean, String> {
	public List<MongoFunSaleBean> getEsfList(EsfListParam esfListParam);
	
	/**
	 * 删除搜搜数据
	 * @param date
	 */
	public void deleteList(Date date);
}
