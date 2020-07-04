package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;

import com.myfun.erpWeb.managecenter.buildData.param.FloorDataParam;
import com.myfun.erpWeb.managecenter.buildData.vo.BuildDataHouseDataVo;
import com.myfun.erpWeb.managecenter.buildData.vo.ErpFunBuildRuleDto;
import com.myfun.erpWeb.managecenter.param.GetRoofUnitNumListParam;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.po.ErpFunBuildRule;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.erpdb.po.ErpFunBuildRuleExample;
@SwitchDB(type = SwitchDBType.COMP_ID)
public interface ErpFunBuildRuleMapper extends BaseMapper<ErpFunBuildRule, ErpFunBuildRule> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunBuildRuleExample example);
	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunBuildRuleExample example);
	/**
	 * @mbggenerated
	 */List<ErpFunBuildRule> selectByExample(ErpFunBuildRuleExample example);
	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") ErpFunBuildRule record,@Param("example") ErpFunBuildRuleExample example);
	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") ErpFunBuildRule record,@Param("example") ErpFunBuildRuleExample example);
	/**
	 * 获取楼盘的栋单元楼列表 
	 * @author 臧铁
	 * @param param  buildId 主键      floor 第几楼        unit 单元         roof 栋
	 * @since 2017年6月20日
	 * @return
	 */
	List<ErpFunBuildRule> getRoofUnitNumList(@Param("shardCityId") Integer cityId,@Param("param") GetRoofUnitNumListParam map);
	void deleteBuildRuleByBuild(@Param("shardCityId") Integer cityId,@Param("param") Map<String, Object> param);
	List<ErpFunBuildRule> getBuildRoofUnits(@Param("shardCityId") Integer cityId,@Param("param") Map<String, Object> map);
	
	/**
	 * 获取楼盘资料转售转租数据
	 * @author 张宏利
	 * @since 2017年12月18日
	 * @param cityId
	 * @param map
	 * @return
	 */
	List<Integer> getHouseIdList(@Param("shardCityId") Integer cityId, @Param("param") Map<String, Object> map);

	List<BuildDataHouseDataVo> getHouseIdListV2(@Param("shardCityId") Integer cityId, @Param("param") Map<String, Object> map);
	
	List<Integer> getEntityIdsByBuildId(Integer cityId, Integer buildId);

	List<ErpFunBuildRuleDto> getFunBuildRuleList(@Param("shardCityId")Integer cityId, @Param("param") FloorDataParam param, @Param("personal") boolean personal);

	Integer countFunBuildRule(@Param("shardCityId")Integer cityId,@Param("buildId") Integer buildId,@Param("compId") Integer compId);

	int countFunBuildRuleByCondition(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("buildId") Integer buildId,@Param("sameFlag") String sameFlag);

	ErpFunBuildRule getFunBuildRuleOneByBuildId(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("buildId") Integer buildId,@Param("sameFlag") String sameFlag);

	void deleteBuildRuleByIds(@Param("shardCityId")Integer cityId,@Param("entityIds") String[] entityIds);

	List<ErpFunBuildRule> getSamFlag(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("buildId") Integer buildId,@Param("samFlag") String samFlag);

    void insertBatch(@Param("shardCityId")Integer cityId, @Param("paramList")List<ErpFunBuildRule> erpFunBuildRules);

	/**
	 * 统计某个楼盘的总户数(用户导入的或登记的)/转租/转售/已转入数
	 * @param cityId
	 * @param compId
	 * @param buildId
	 * @return
	 */
	Map<String,Integer> countTotalRoomAndSaleAndLease(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("buildId") Integer buildId);

	/**
	 * 获取某个楼盘的总栋数
	 */
	List<ErpFunBuildRule> countBuildTotalRoof(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("buildId") Integer buildId);
	
	/**
	 * 根据门店查询楼盘
	 */
	List<ErpFunBuildRule> selectByDeptId(@Param("shardCityId") Integer cityId,@Param("compId") Integer compId,@Param("deptId") Integer deptId, @Param("buildId") Integer buildId);
}

