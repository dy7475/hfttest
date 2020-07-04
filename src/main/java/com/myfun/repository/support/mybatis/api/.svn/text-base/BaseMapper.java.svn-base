package com.myfun.repository.support.mybatis.api;

import java.io.Serializable;

import com.myfun.repository.support.annotation.SwitchDB;

@SwitchDB
public interface BaseMapper<T, ID extends Serializable> {
	@Deprecated
	int insert(T record);

	int insertSelective(T record);

	int deleteByPrimaryKey(ID id);

	int updateByPrimaryKeySelective(T record);

	int updateByPrimaryKey(T record);

	T selectByPrimaryKey(ID id);

}
