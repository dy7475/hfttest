package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunAttendanceGroupBizPerson;
import com.myfun.repository.erpdb.po.ErpFunAttendanceGroupBizPersonExample;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ErpFunAttendanceGroupBizPersonMapper extends BaseMapper<ErpFunAttendanceGroupBizPerson, ErpFunAttendanceGroupBizPerson> {

    /**
	 * @mbggenerated
	 */
	int countByExample(ErpFunAttendanceGroupBizPersonExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunAttendanceGroupBizPersonExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunAttendanceGroupBizPerson> selectByExample(ErpFunAttendanceGroupBizPersonExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunAttendanceGroupBizPerson record,
			@Param("example") ErpFunAttendanceGroupBizPersonExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunAttendanceGroupBizPerson record,
			@Param("example") ErpFunAttendanceGroupBizPersonExample example);

	@SwitchDB(type = SwitchDBType.CITY_ID)
    void insertBatch(@Param("shardCityId") Integer cityId, @Param("userList") List<ErpFunUsers> erpFunUsersList, @Param("groupId") Integer attScopeId, @Param("groupBizId") Integer id);

    /**
     * 根据用户ID查询考勤组的id
     */
    @SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunAttendanceGroupBizPerson> findGroupByUserId(@Param("shardCityId") Integer cityId, @Param("userId") Integer userId);


    List<ErpFunAttendanceGroupBizPerson> getUserList(@Param("shardCityId")Integer cityId, @Param("groupId")Integer groupId);

    /**
     * 通过userId更新
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/5/25
     */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	void updateByUserId(ErpFunAttendanceGroupBizPerson erpFunAttendanceGroupBizPersonPO);
}