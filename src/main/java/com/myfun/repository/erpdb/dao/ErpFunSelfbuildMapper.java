package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.myfun.erpWeb.managecenter.buildData.param.BuildListParam;
import com.myfun.erpWeb.managecenter.buildData.vo.ErpFunSelfbuildDto;
import com.myfun.repository.support.annotation.SwitchDB;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.po.ErpFunSelfbuild;
import com.myfun.repository.erpdb.po.ErpFunSelfbuildKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.erpdb.po.ErpFunSelfbuildExample;

public interface ErpFunSelfbuildMapper extends BaseMapper<ErpFunSelfbuild, ErpFunSelfbuildKey> {
	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunSelfbuildExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunSelfbuildExample example);

	/**
	 * @mbggenerated
	 */List<ErpFunSelfbuild> selectByExample(ErpFunSelfbuildExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") ErpFunSelfbuild record,@Param("example") ErpFunSelfbuildExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") ErpFunSelfbuild record,@Param("example") ErpFunSelfbuildExample example);

	void deleteSelfbuildByBuild(@Param("shardCityId") Integer cityId,@Param("param") Map<String, Object> param);

	List<ErpFunSelfbuildDto> getFunSelfBuildList(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
												 @Param("buildNameOrCode") String buildNameOrCode, @Param("orderBy") String orderBy,
												 @Param("buildIds") String buildIds);
	
	ErpFunSelfbuild getFunSelfOneByBuildId(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("buildId") Integer buildId);

	void deleteSelfBuild(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId);

	/**
	 * 楼盘ID肯定存在，不需要权限获取楼盘资料列表
	 * @param cityId
	 * @param param
	 * @return
	 */
	List<ErpFunSelfbuildDto> getFunBuildList(@Param("shardCityId") Integer cityId,@Param("compId")Integer compId,@Param("param") BuildListParam param,
											 @Param("sectionIdList")Set<Integer> sectionIdList);

	@SwitchDB
	List<ErpFunSelfbuildDto>  getFunBuildListByDiffrentOper(@Param("shardCityId") Integer cityId,@Param("compId") Integer compId,@Param("userId") Integer userId,
	                                                   	@Param("deptId") Integer deptId,@Param("nowTime")String nowTime,@Param("oper")Byte oper,@Param("buildNameOrCode") String buildNameOrCode);


	List<ErpFunSelfbuildDto> getBuildListByDiffrentOper(@Param("shardCityId") Integer cityId,@Param("compId") Integer compId,@Param("oper")Byte oper,@Param("param") BuildListParam param,
                                                        @Param("deptId") Integer deptId,@Param("sectionIdList")Set<Integer> sectionIdList);

	@SwitchDB
	List<ErpFunSelfbuildDto> getFunSelfBuildListByBuildIds(@Param("shardCityId") Integer cityId,@Param("compId") Integer compId,@Param("builldList") Set<Integer> builldList);
}