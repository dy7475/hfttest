package com.myfun.repository.admindb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.po.AdminFunPersonalIntent;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminFunPersonalIntentMapper extends BaseMapper<AdminFunPersonalIntent, Integer> {

	/**
	 * 精英版数据移交
	 * @param sellId
	 * @param funArchiveIds
	 */
	void translateDataByArchiveId(@Param("sellId") String sellId, @Param("funArchiveIds") List<String> funArchiveIds);

	/**
	 * 精英版数据移交
	 * @param sellId
	 * @param string
	 */
	void translateDataById(@Param("sellId") String sellId, @Param("personalIds") List<String> personalIds);

	/**
	 * 精英版批量移交
	 * @param sellId
	 * @param oldSellId
	 */
	void translateDataByCreateUser(@Param("sellId") String sellId, @Param("oldSellId") String oldSellId);
}