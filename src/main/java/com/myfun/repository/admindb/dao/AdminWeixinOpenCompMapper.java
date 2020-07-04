package com.myfun.repository.admindb.dao;

import com.github.pagehelper.Page;
import com.myfun.repository.admindb.dto.AdminWeixinOpenCompDto;
import com.myfun.repository.admindb.param.AdminWeixinOpenCompParam;
import com.myfun.repository.admindb.po.AdminWeixinOpenComp;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.admindb.po.AdminWeixinOpenCompExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AdminWeixinOpenCompMapper extends BaseMapper<AdminWeixinOpenComp, Integer> {
	/**
	 * @mbggenerated
	 */
	int countByExample(AdminWeixinOpenCompExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminWeixinOpenCompExample example);

	/**
	 * @mbggenerated
	 */List<AdminWeixinOpenComp> selectByExample(AdminWeixinOpenCompExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") AdminWeixinOpenComp record,@Param("example") AdminWeixinOpenCompExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") AdminWeixinOpenComp record,@Param("example") AdminWeixinOpenCompExample example);

	/**
	 * 微信列表
	 * **/
	Page<AdminWeixinOpenCompDto> getPublicWechatList(AdminWeixinOpenCompParam weixinOpenCompParam);
	
	AdminWeixinOpenComp getWeixinOpenCompByCompID(Integer compId);

	void updateWeixinOpenCompByCompId(AdminWeixinOpenComp upWeixinOpenComp);

	void insertForFastDfs(@Param("dfsParamList") List<Map<String, Object>> pMap);
}