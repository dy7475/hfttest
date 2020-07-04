package com.myfun.service.business;

import java.io.Serializable;

import com.myfun.repository.support.mybatis.api.BaseMapper;

public abstract class AbstractService<T, ID extends Serializable> implements BaseService<T, ID> {
	protected BaseMapper<T, ID> baseMapper;

	@Override
	public int deleteByPrimaryKey(ID id) {
		return baseMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insertSelective(T record) {
		return baseMapper.insertSelective(record);
	}

	@Override
	public T selectByPrimaryKey(ID id) {
		return baseMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(T record) {
		return baseMapper.updateByPrimaryKeySelective(record);
	}

	@SuppressWarnings("deprecation")
	@Override
	public int updateByPrimaryKey(T record) {
		return baseMapper.updateByPrimaryKey(record);
	}

	@SuppressWarnings("deprecation")
	@Override
	public int insert(T record) {
		return baseMapper.insert(record);
	}
}
