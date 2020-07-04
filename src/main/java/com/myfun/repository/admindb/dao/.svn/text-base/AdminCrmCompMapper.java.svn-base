package com.myfun.repository.admindb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.po.AdminCrmComp;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminCrmCompMapper extends BaseMapper<AdminCrmComp, Integer> {
	AdminCrmComp getCrmCompNo(@Param("compId") Integer compId);

	/**
	 * 通过公司ID获取列表
	 * 
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/24
	 * @return
	 *
	 */
	List<AdminCrmComp> getListByCompId(@Param("compId") Integer compId);
}