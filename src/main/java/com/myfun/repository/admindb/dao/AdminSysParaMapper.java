package com.myfun.repository.admindb.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.po.AdminSysPara;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminSysParaMapper extends BaseMapper<AdminSysPara, String> {
	/**
	 * 查询左右参数列表
	 * 
	 * @return
	 */
	ArrayList<AdminSysPara> query();

	/**
	 * 普通的弹窗广告
	 * 
	 * @author 何传强
	 * @since 2017年6月27日
	 * @param paramIds
	 * @return
	 */
	List<AdminSysPara> getAdminSysPara(@Param("paramIds") String[] paramIds);
	
	/**
	 * 通过ID获取value
	 * @author 张宏利
	 * @since 2017年9月4日
	 * @param paramId
	 * @return
	 */
	String selectParamVlue(@Param("paramId") String paramId);

	
	
	@MapKey("paramId")
	Map<String,AdminSysPara> getAdminSysParaData(@Param("paramIds") String[] paramIds);

	/**
	 *  根据ID获取参数
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/14
	 */
	AdminSysPara getAdminSysParaById(@Param("paramId")String paramId);
	String getAdminSysParas(@Param("param")String param);
}