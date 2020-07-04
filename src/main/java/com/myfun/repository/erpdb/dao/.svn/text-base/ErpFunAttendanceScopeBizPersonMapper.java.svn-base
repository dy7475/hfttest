package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunAttendanceScopeBizPerson;
import com.myfun.repository.erpdb.po.ErpFunAttendanceScopeBizPersonExample;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import java.util.Set;
import org.apache.ibatis.annotations.Param;

public interface ErpFunAttendanceScopeBizPersonMapper extends BaseMapper<ErpFunAttendanceScopeBizPerson, ErpFunAttendanceScopeBizPerson> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunAttendanceScopeBizPersonExample example);


	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunAttendanceScopeBizPersonExample example);


	/**
	 * @mbggenerated
	 */
	List<ErpFunAttendanceScopeBizPerson> selectByExample(ErpFunAttendanceScopeBizPersonExample example);


	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunAttendanceScopeBizPerson record,
			@Param("example") ErpFunAttendanceScopeBizPersonExample example);


	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunAttendanceScopeBizPerson record,
			@Param("example") ErpFunAttendanceScopeBizPersonExample example);


	@SwitchDB(type = SwitchDBType.CITY_ID)
    void insertBatch(@Param("shardCityId")Integer cityId, @Param("userList")List<ErpFunUsers> erpFunUsersList, @Param("attScopeId")Integer attScopeId, @Param("scopBizId")Integer id);
	
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunAttendanceScopeBizPerson> getScopeId(@Param("shardCityId")Integer cityId, @Param("userId") Integer userId);
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunAttendanceScopeBizPerson> getUserList(@Param("shardCityId")Integer cityId,  @Param("bizList")Set<Integer> bizList);

	/**
	 *  通过userId更新
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/5/25
	 */
	void updateByUserId(ErpFunAttendanceScopeBizPerson erpFunAttendanceScopeBizPersonPO);
}