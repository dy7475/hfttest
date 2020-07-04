package com.myfun.repository.agencydb.dao;

import java.util.List;
import java.util.Map;

import com.myfun.repository.agencydb.dto.AgencyFunUsersDto;
import com.myfun.repository.agencydb.param.AgencyFunUsersParam;
import com.myfun.repository.agencydb.po.AgencyFunUsers;
import com.myfun.repository.agencydb.po.AgencyFunUsersKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.agencydb.po.AgencyFunUsersExample;
import org.apache.ibatis.annotations.Param;

public interface AgencyFunUsersMapper extends BaseMapper<AgencyFunUsers, AgencyFunUsersKey> {

	/**
	 * @mbggenerated
	 */
	int countByExample(AgencyFunUsersExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AgencyFunUsersExample example);

	/**
	 * @mbggenerated
	 */List<AgencyFunUsers> selectByExample(AgencyFunUsersExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") AgencyFunUsers record,@Param("example") AgencyFunUsersExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") AgencyFunUsers record,@Param("example") AgencyFunUsersExample example);

	Integer updateFunUser(Map<String, Object> paramMap);

	AgencyFunUsers getFunUserByMobile(Map<String,Object> paramMap);

	List<AgencyFunUsers> getFunUserByBuildIdAndCityId(Map<String, Object> paramMap);

	Integer updateByCondition(Map<String, Object> paramMap);

	List<AgencyFunUsersDto> getFunUserListByBuildIdAndCityId(AgencyFunUsersParam agencyFunUsersParam);

	List<AgencyFunUsers> selectByCondition(Map<String, Object> pMap);

    void insertForFastDfs(@Param("dfsParamList") List<Map<String, Object>> pMap);
}