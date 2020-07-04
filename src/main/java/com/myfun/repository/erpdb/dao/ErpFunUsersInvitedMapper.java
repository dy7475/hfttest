package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.managecenter.sysmanager.vo.GetAllCompUserVo;
import com.myfun.erpWeb.managecenter.sysmanager.vo.GetCompNotInviteUserRoleVo;
import com.myfun.repository.erpdb.po.ErpFunUsersInvited;
import com.myfun.repository.erpdb.po.ErpFunUsersInvitedExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunUsersInvitedMapper extends BaseMapper<ErpFunUsersInvited, ErpFunUsersInvited> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunUsersInvitedExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunUsersInvitedExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunUsersInvited> selectByExample(ErpFunUsersInvitedExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunUsersInvited record, @Param("example") ErpFunUsersInvitedExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunUsersInvited record, @Param("example") ErpFunUsersInvitedExample example);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	void updateDataForArea(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("areaId")Integer areaId, @Param("regId")Integer regId);

    List<GetCompNotInviteUserRoleVo> getNotConsentUser(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId);

	ErpFunUsersInvited getUserByinviteId(@Param("shardCityId")Integer cityId,@Param("inviteId") Integer inviteId);

}