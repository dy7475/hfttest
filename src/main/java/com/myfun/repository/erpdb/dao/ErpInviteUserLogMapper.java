package com.myfun.repository.erpdb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.erpWeb.managecenter.sysmanager.param.GetInvitationRegListParam;
import com.myfun.erpWeb.managecenter.vo.ErpInviteUserLogVo;
import com.myfun.repository.erpdb.po.ErpInviteUserLog;
import com.myfun.repository.erpdb.po.ErpInviteUserLogExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpInviteUserLogMapper extends BaseMapper<ErpInviteUserLog, ErpInviteUserLog> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ErpInviteUserLogExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpInviteUserLogExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpInviteUserLog> selectByExample(ErpInviteUserLogExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpInviteUserLog record,
			@Param("example") ErpInviteUserLogExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpInviteUserLog record, @Param("example") ErpInviteUserLogExample example);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpInviteUserLogVo> getInvitationRegList(@Param("shardCityId")Integer cityId, @Param("paramData")GetInvitationRegListParam param);
}