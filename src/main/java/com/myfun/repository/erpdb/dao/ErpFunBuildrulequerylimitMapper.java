package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.managecenter.buildData.param.FloorDataParam;
import com.myfun.erpWeb.managecenter.buildData.param.MgrUserViewRightParam;
import com.myfun.erpWeb.managecenter.buildData.vo.ErpFunBuildrulequerylimitDto;
import com.myfun.repository.erpdb.po.ErpFunBuildrulequerylimit;
import com.myfun.repository.erpdb.po.ErpFunBuildrulequerylimitExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ErpFunBuildrulequerylimitMapper extends BaseMapper<ErpFunBuildrulequerylimit, ErpFunBuildrulequerylimit> {
	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunBuildrulequerylimitExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunBuildrulequerylimitExample example);

	/**
	 * @mbggenerated
	 */List<ErpFunBuildrulequerylimit> selectByExample(ErpFunBuildrulequerylimitExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") ErpFunBuildrulequerylimit record,@Param("example") ErpFunBuildrulequerylimitExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") ErpFunBuildrulequerylimit record,@Param("example") ErpFunBuildrulequerylimitExample example);

	@SwitchDB(type = SwitchDBType.DB_NAME)
	List<ErpFunBuildrulequerylimit> getQueryLimitList(@Param("shardDbName")String shardDbName, @Param("limitId")Integer limitId);
	
	/**
	 * 获取可查看的楼盘资料列表
	 * @author 张宏利
	 * @since 2018年4月8日
	 * @param cityId
	 * @param userId
	 * @return
	 */
	List<ErpFunBuildrulequerylimit> getUserViewBuilds(@Param("shardCityId")Integer cityId, @Param("userId")Integer userId);

	List<ErpFunBuildrulequerylimit> getBuildrulequerylimitList(@Param("shardCityId")Integer cityId,@Param("param") FloorDataParam param);

	List<ErpFunBuildrulequerylimitDto> getBuildrulequerylimitDtoList(@Param("shardCityId")Integer cityId,
																	 @Param("userIds") List<String> userIds,@Param("nowTime") String nowTime);

	ErpFunBuildrulequerylimit getBuildrulequerylimit(ErpFunBuildrulequerylimit model);

	void deleteBuildrulequerylimits(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId, @Param("ids")String[] ids);

	List<ErpFunBuildrulequerylimit> getBuildByUserId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("userId")Integer userId);


	List<ErpFunBuildrulequerylimitDto> getBuildrulequerylimitDtoNewList(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId);

	List<ErpFunBuildrulequerylimitDto> getBuildrulequerylimitDtoByNoOper(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,@Param("param")MgrUserViewRightParam param);


	List<ErpFunBuildrulequerylimitDto> getBuildrulequerylimitDtoByDifferentOper(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,@Param("oper")Byte oper,@Param("param")MgrUserViewRightParam param);

	List<ErpFunBuildrulequerylimit> getBuildLimitByBuildId(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,@Param("buildId")Integer buildId);

    List<ErpFunBuildrulequerylimit> getMgrUserViewBuilds(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("userId")Integer userId, @Param("nowTime")String nowTime);
}